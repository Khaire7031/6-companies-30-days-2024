package Thread;
public class NewMyThread extends Thread {

    NewMyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread is Running.....");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        NewMyThread t1 = new NewMyThread("PK");
        t1.start();
        // t1.interrupt();

    }
}
