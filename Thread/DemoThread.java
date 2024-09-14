package Thread;

public class DemoThread extends Thread {

    @Override
    public void run() {
        System.out.println("3 : " + "RUNNING");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // Different Stages of thred
        DemoThread t1 = new DemoThread();// New
        System.out.println("1 : " + t1.getState()); // print NEW

        t1.start();
        System.out.println("2 : " + t1.getState()); // print RUNNABLE

        Thread.sleep(100);
        System.out.println("4 : " + t1.getState()); // TIMED_WAITING beacause it is wainting

        t1.join();
        System.out.println("5 : " + t1.getState());
    }

}
