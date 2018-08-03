package exercise.c_005;

/**
 * 三种办法都能解决高并发脏读问题，存在问题是count++的不是原子操作
 * 检测不出来明显的时间快慢
 *
 * Created by ZhangYuanzhuo on 2017/8/4.
 */
public class T {
    volatile int count = 0;

    /*synchronized*/ void m() {
        for (int i = 0; i < 1000; i++) {
//            synchronized (this) { // 主要是count++的问题
            count++;
            }
//        }
    }

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                t.m();
                System.out.println(Thread.currentThread().getName() + " end");
            }).start();
        }
        long end = System.currentTimeMillis();

        Thread.sleep(100); // 防止main()主线程抢先
        System.out.println("time used: " + (end - start));
        System.out.println("count = " + t.count);
    }
}
