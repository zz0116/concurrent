package exercise.c_010;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ZhangYuanzhuo on 2017/8/5.
 */
public class ReentrantLock4 extends Thread {
    // 公平竞争和非公平竞争的区别
    private Lock lock = new ReentrantLock(false);

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " get the lock");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock4 r = new ReentrantLock4();
        new Thread(r).start();
        new Thread(r).start();
    }
}
