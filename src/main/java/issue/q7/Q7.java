package issue.q7;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/6
 */
public class Q7 {
    // дһ������֤��AtomXXX��Ķ��������������ԭ����
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName() + " in");
//                ai.getAndIncrement();
//                System.out.println(Thread.currentThread().getName() + " out");
            }).start();
        }
    }
}
