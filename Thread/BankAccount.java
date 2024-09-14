package Thread;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 105;

    private final Lock lock = new ReentrantLock();

    public void withDraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);

        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + " processing withdrawal");
                    if (balance >= amount) {
                        try {
                            Thread.sleep(3000); // Simulating database operation
                        } catch (InterruptedException e) {
                            System.out.println("Database Error: " + e.getMessage());
                        }
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName()
                                + " : Withdrawal successful. Remaining balance: " + balance);
                    } else {
                        System.out.println(Thread.currentThread().getName() + " : Insufficient balance");
                    }
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " : Could not acquire the lock. Will try later.");
            }
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// public synchronized void withDraw(int amount) {
// System.out.println(Thread.currentThread().getName() + " attempting to
// withdraw " + amount);

// if (balance >= amount) {
// System.out.println(Thread.currentThread().getName() + " processing with
// withdraw");
// try {
// Thread.sleep(10000);
// } catch (InterruptedException e) {
// System.out.println("Message : " + e.getMessage());
// }
// balance = balance - amount;
// System.out.println(Thread.currentThread().getName() + " : Withdraw Done
// Remaining amount : " + balance);

// } else {
// System.out.println(Thread.currentThread().getName() + " : Insufficient
// Balance");
// }
// }
