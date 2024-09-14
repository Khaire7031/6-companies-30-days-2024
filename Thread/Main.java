package Thread;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount sbi = new BankAccount();

        Runnable task = new Runnable() {

            @Override
            public void run() {
                sbi.withDraw(50);
            }

        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        Thread t3 = new Thread(task, "Thread 3");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Transcation is done");
    }
}
