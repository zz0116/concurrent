package issue.q1;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/6
 */
public class Q1 {
    // A�߳�����ִ��һ�������е�ͬ��������B�߳��Ƿ����ͬʱִ��ͬһ�������еķ�ͬ��������
    // ����
    // ͬ�ϣ�B�߳��Ƿ����ͬʱִ��ͬһ�������е���һ��ͬ��������
    // ����
    public static void main(String[] args) {
        Student student = new Student();

        new Thread(() -> {
            student.setName("lisi");
        }).start();

        new Thread(() -> {
            System.out.println(student.getName());
        }).start();

        new Thread(() -> {
            student.setSid("3");
        }).start();

    }

}
