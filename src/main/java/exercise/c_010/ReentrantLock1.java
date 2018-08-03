package exercise.c_010;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ZhangYuanzhuo.
 */
public class ReentrantLock1 {
    Lock lock = new ReentrantLock();

    void m() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(500);

                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void n() {
        lock.lock();
        System.out.println("n");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock1 r = new ReentrantLock1();
        new Thread(r::m).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r::n).start();
    }
}
