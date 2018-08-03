package exercise.c_007;

/**
 * 在写的操作里面延时，以达到脏读的效果
 *
 * Created by ZhangYuanzhuo.
 */
public class T {
    private double blood = 100.0;
    private String skill;

    void loseBlood(String skill, double value) {
        this.skill = skill;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        blood -= value;
    }

    double getBlood() {
        return blood;
    }

    public static void main(String[] args) {
        T t = new T();

        new Thread(() -> {
            t.loseBlood("hit", 20.0);
            System.out.println(Thread.currentThread().getName() + " blood = " + t.getBlood());
        }).start();

        new Thread(() -> System.out.println(Thread.currentThread().getName() + " blood = " + t.getBlood())).start();
    }
}
