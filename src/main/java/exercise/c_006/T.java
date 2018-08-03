package exercise.c_006;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 比005更清晰
 * volatile无法解决问题，因为存在count--和m()里面两条语句之间的不是原子操作的问题
 * AtomicXxx跟volatile一样，还是不能解决语句中间不同步的问题
 *
 * Created by ZhangYuanzhuo.
 */
public class T {
//    private /*volatile*/ int count = 10;
    private AtomicInteger count = new AtomicInteger(10);

    /*synchronized*/ void m() {
        count.getAndDecrement();
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        T t = new T();
        for (int i = 0; i < 5; i++) {
            new Thread(t::m).start();
        }
    }
}
