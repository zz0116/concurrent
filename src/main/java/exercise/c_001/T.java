package exercise.c_001;

/**
 * 初识多线程
 * 不能用run()，要用start()
 *
 * @author Zhang Yuanzhuo.
 */
public class T {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                Thread.sleep(500);
                System.out.println("Thread 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(100);
                System.out.println("Thread 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
