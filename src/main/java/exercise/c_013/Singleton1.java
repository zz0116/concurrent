package exercise.c_013;

/**
 * 问题在于类加载的时候会直接new一个对象，当系统中这种类较多时，启动速度会变慢
 * 现在流行的设计是 延迟加载
 *
 * Created by ZhangYuanzhuo.
 */
public class Singleton1 {
    private Singleton1() {
    }

    private static Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton1.getInstance());
            }).start();
        }
    }
}
