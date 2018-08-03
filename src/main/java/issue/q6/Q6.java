package issue.q6;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/6
 */
public class Q6 {
    // AtomXXX类可以保证可见性吗？请写一个程序来证明
    // 可以
    private int i = 0;
    private AtomicInteger ai = new AtomicInteger(0);

    void incre() {
        for (int j = 0; j < 10000; j++) {
//            i++;
            ai.getAndIncrement();
        }
    }

    void decre() {
        for (int j = 0; j < 10000; j++) {
//            i--;
            ai.getAndDecrement();
        }
    }

    int get() {
//        return i;
        return ai.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Q6 q = new Q6();

        Thread tDec = new Thread(q::decre);
        Thread tInc = new Thread(q::incre);

        tInc.start();
        tDec.start();

        Thread.sleep(3000);
        System.out.println(q.get());
    }
}
