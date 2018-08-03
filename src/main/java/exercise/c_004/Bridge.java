package exercise.c_004;

/**
 * 死锁例子，共享资源为桥
 *
 * @author Zhang Yuanzhuo.
 */
public class Bridge {
    private final Object bridgeEast;
    private final Object bridgeWest;

    public Bridge(final Object bridgeEast, final Object bridgeWest) {
        this.bridgeEast = bridgeEast;
        this.bridgeWest = bridgeWest;
    }

    public static void main(String[] args) {

        Bridge bridge = new Bridge(new Object(), new Object());
        Thread a = new Thread(() -> {
            synchronized (bridge.bridgeEast) {
                System.out.println("a is on the East");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (bridge.bridgeWest) {
                    System.out.println("a arrived the West");
                }
            }
        });

        Thread b = new Thread(() -> {
            synchronized (bridge.bridgeWest) {
                System.out.println("b is on the West");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (bridge.bridgeEast) {
                    System.out.println("b arrived the East");
                }
            }
        });

        a.start();
        b.start();
    }
}
