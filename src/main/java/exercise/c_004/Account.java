package exercise.c_004;

/**
 * 死锁例子，共享资源为from和to两个账户
 *
 * @author Zhang Yuanzhuo.
 */
public class Account {
    double balance;
    String name;

    public Account(String name) {
        this.name = name;
    }

    void withdraw(double amount) {
        balance -= amount;
    }

    void deposit(double amount) {
        balance += amount;
    }

    @Override
    public String toString() {
        return name;
    }

    static void transfer(Account from, Account to, double amount) {
        synchronized (from) {
            try {
                System.out.println(from + " locked");
                Thread.sleep(1);
                from.withdraw(amount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (to) {
                try {
                    System.out.println(from + " locked");
                    Thread.sleep(1);
                    to.deposit(amount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        Account a = new Account("a");
        Account b = new Account("b");

        new Thread(() -> {
            System.out.println("a -> b transfer...");
            transfer(a, b, 1.0);
            System.out.println("a -> b success!");
        }).start();

        new Thread(() -> {
            System.out.println("b -> a transfer...");
            transfer(b, a, 2.0);
            System.out.println("b -> a success!");
        }).start();
    }

}
