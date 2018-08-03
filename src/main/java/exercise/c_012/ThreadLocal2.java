package exercise.c_012;

import java.util.concurrent.TimeUnit;

/**
 * t1 null
 * t2 exercise.c_012.ThreadLocal2$Person@658afb6a
 * ThreadLocal使用时需要通过set方法new出对象才能调用
 * 也就是说保证了每个线程都有自己的对象
 *
 * Created by ZhangYuanzhuo.
 */
public class ThreadLocal2 {
//    /*volatile*/ static Person p = new Person();
    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("t1 " + tl.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                tl.set(new Person());
                System.out.println("t2 " + tl.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    static class Person {
        String name = "zhangsan";

    }
}
