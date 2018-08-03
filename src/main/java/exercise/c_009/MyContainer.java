package exercise.c_009;

import java.util.LinkedList;
import java.util.List;

/**
 * 曾经的面试题：（淘宝？）
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 *
 * Created by ZhangYuanzhuo.
 */
public class MyContainer<T> {
    private /*volatile*/ List<T> list = new LinkedList<>();

    void add(T t) {
        list.add(t);
    }

    int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer<Object> myContainer = new MyContainer<>();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myContainer.add(new Object());
                System.out.println("t1 add " + i);
            }
        }).start();

        new Thread(() -> {
            while (true) {
                if (myContainer.size() == 5) {
                    break;
                }
            }
            System.out.println("t2 end");
        }).start();
    }
}
