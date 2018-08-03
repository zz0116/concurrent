package issue.q9;

import java.util.concurrent.CountDownLatch;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/9
 */
public class Q9 {
    // 写一个程序，在main线程中启动100个线程
    // 100个线程完成后，主线程打印“完成”
    // 使用join()和countdownlatch都可以完成，请比较异同
    public static void main(String[] args) throws InterruptedException {
        // 1
//        for (int i = 0; i < 100; i++) {
//            Thread t = new Thread();
//            t.start();
//            t.join();
//        }
//        System.out.println("Done");

        // 2
//        Thread[] threads = new Thread[100];
//        for (int i = 0; i < 100; i++) {
//            threads[i] = new Thread();
//            threads[i].start();
//        }
//        for (Thread t : threads) {
//            t.join();
//        }
//        System.out.println("Done");

        // 3
        CountDownLatch latch = new CountDownLatch(100);
        new Thread(() -> {
            try {
                for (int i = 0; i < 100; i++) {
                    latch.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Done");
        }).start();

        for (int i = 0; i < 100; i++) {
            new Thread().start();
            latch.countDown();
        }
    }
}
