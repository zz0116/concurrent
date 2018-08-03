package issue.q3;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/6
 */
public class Q3 {
    // 线程抛出异常会释放锁吗？
    // 会
    synchronized void m() throws Exception {
        Thread.sleep(3000);
        throw new Exception("异常抛出，会释放锁吗？");
    }

    synchronized void m1() {
        System.out.println("锁释放");
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        new Thread(() -> {
            try {
                q3.m();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            q3.m1();
        }).start();
    }
}
