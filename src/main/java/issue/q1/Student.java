package issue.q1;

/**
 * @author ZhangYuanzhuo
 * @since 2017/9/6
 */
public class Student {
    private String name;
    private String sid;

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        System.out.println(Thread.currentThread().getName() + " setName start");
        try {
            Thread.sleep(2000);
            this.name = name;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " setName end");
    }

    public String getSid() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sid;
    }

    public synchronized void setSid(String sid) {
        System.out.println(Thread.currentThread().getName() + " setSid start");
        try {
            Thread.sleep(1000);
            this.sid = sid;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " setSid end");
    }

}
