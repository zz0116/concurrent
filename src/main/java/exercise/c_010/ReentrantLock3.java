package exercise.c_010;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ZhangYuanzhuo on 2017/8/5.
 */
public class ReentrantLock3 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            try {
//                lock.lock();
                lock.lockInterruptibly();
                System.out.println("t1 start...");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t1 end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                t1.interrupt();
                lock.lockInterruptibly();
                System.out.println("t2 start...");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 end...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
    }
}
