package issue.q8;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/6
 */
public class Q8 {
    // дһ������ģ������
    // �ĵã������Ƕ��������̣߳�����ͬ��˳����ס��������
    synchronized void m(Q8 q) {
        System.out.println(Thread.currentThread().getName() + " enter m1");
            System.out.println("get " + this + " locked");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (q) {
                System.out.println("get " + q + " locked");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        System.out.println(Thread.currentThread().getName() + " quit m1");
    }

    public static void main(String[] args) {
        Q8 q1 = new Q8();
        Q8 q2 = new Q8();

        new Thread(() -> {
            q1.m(q2);
        }).start();

        new Thread(() -> {
            q2.m(q1);
        }).start();
    }
}
