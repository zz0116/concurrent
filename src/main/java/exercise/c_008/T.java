package exercise.c_008;

/**
 * Created by ZhangYuanzhuo.
 */
public class T {
    private volatile boolean help = true;

    void m() {
        System.out.println(Thread.currentThread().getName() + " start...");
        while (help) {
            // 中间做点什么的时候线程就有可能去常量池里面看一下help的值
            /*try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println(Thread.currentThread().getName() + " end...");
    }

    public static void main(String[] args) {
        T t = new T();

        new Thread(t::m).start();

        // 主线程有可能抢在前面把help设为false
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.help = false;
    }
}
