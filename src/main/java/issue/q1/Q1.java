package issue.q1;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/6
 */
public class Q1 {
    // A线程正在执行一个对象中的同步方法，B线程是否可以同时执行同一个对象中的非同步方法？
    // 可以
    // 同上，B线程是否可以同时执行同一个对象中的另一个同步方法？
    // 不行
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
