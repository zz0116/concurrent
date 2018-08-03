package issue.q3;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/6
 */
public class Q3 {
    // �߳��׳��쳣���ͷ�����
    // ��
    synchronized void m() throws Exception {
        Thread.sleep(3000);
        throw new Exception("�쳣�׳������ͷ�����");
    }

    synchronized void m1() {
        System.out.println("���ͷ�");
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
