package exercise.c_009;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by ZhangYuanzhuo.
 */
public class MyContainer4<T> {
    private /*volatile*/ List<T> list = new LinkedList<>();

    void add(T t) {
        list.add(t);
    }

    int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer<Object> myContainer = new MyContainer<>();
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 start");
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 end");
        }).start();

        new Thread(() -> {
            System.out.println("t1 start");
            for (int i = 0; i < 10; i++) {
                if (myContainer.size() == 5) {
                    latch.countDown();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                myContainer.add(new Object());
                System.out.println("t1 add " + i);
            }
            System.out.println("t1 end");
        }).start();
    }
}
