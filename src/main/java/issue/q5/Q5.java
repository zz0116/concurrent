package issue.q5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/6
 */
public class Q5 {
    // 写一个程序，证明AtomXXX类比synchronized更高效
    private AtomicInteger ai = new AtomicInteger(0);
    private Integer i = new Integer(0);

    void aiM() {
        ai.getAndIncrement();
    }

    synchronized void iM() {
        i ++;
    }

    public static void main(String[] args) throws InterruptedException {
        Q5 q5 = new Q5();

        List<Thread> iMTs = new ArrayList<>();
        List<Thread> aiMTs = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            iMTs.add(new Thread(() -> {
                for (int j = 0; j < 10000000; j++) {
                    q5.iM();
                }
            }));
        }

        for (int i = 0; i < 10; i++) {
            aiMTs.add(new Thread(() -> {
                for (int j = 0; j < 10000000; j++) {
                    q5.aiM();
                }
            }));
        }

        long s2 = System.currentTimeMillis();
        for (Thread aiMT : aiMTs) {
            aiMT.start();
            aiMT.join();
        }
        long e2 = System.currentTimeMillis();

        long s1 = System.currentTimeMillis();
        for (Thread iMT : iMTs) {
            iMT.start();
            iMT.join();
        }
        long e1 = System.currentTimeMillis();

        System.out.println("i " + (e1 - s1));
        System.out.println("ai " + (e2 - s2));
    }
}
