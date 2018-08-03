package exercise.c_003;

/**
 * 当new出一堆线程的时候，各个线程抢着去执行，加上同步锁可以保证不会重入
 *
 * @author Zhang Yuanzhuo.
 */
public class T {
    static int t = 0;

    static /*synchronized*/ int addT() {
        t++;
        System.out.println(Thread.currentThread().getName() + ", t = " + t);
        return t;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                addT();
            }).start();
        }
    }
}
