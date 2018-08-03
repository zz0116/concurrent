package exercise.c_012;

import java.util.concurrent.TimeUnit;

/**
 * Created by ZhangYuanzhuo.
 */
public class ThreadLocal1 {
    /*volatile*/ static Person p = new Person();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(p.name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                p.name = "lisi";
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    static class Person {
        String name = "zhangsan";
    }
}
