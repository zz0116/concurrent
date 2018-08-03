package exercise.c_002;

/**
 * 不同的线程进行计算是不会脏读的，但是要防止主线程抢先输出
 *
 * @author Zhang Yuanzhuo.
 */
public class T {
    static int t;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            t = 0;
            for (int j = 0; j < 1000; j++) {
                new Thread(() -> t++).start();
            }
            Thread.sleep(500);
            System.out.println(t);
        }
    }
}
