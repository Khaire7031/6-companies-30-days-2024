package Thread;
public class Deadlock {

    // Resources
    private static final Object pen = new Object();
    private static final Object paper = new Object();

    public static void main(String[] args) {
        // Create instances of PersonA and PersonB
        PersonA personA = new PersonA();
        PersonB personB = new PersonB();

        // Start both threads
        personA.start();
        personB.start();
    }

    // PersonA class extends Thread
    static class PersonA extends Thread {
        @Override
        public void run() {
            synchronized (pen) {
                System.out.println("Person A: Holding the pen and waiting for the paper...");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

                synchronized (paper) {
                    System.out.println("Person A: Got the paper and writing...");
                }
            }
        }
    }

    // PersonB class extends Thread
    static class PersonB extends Thread {
        @Override
        public void run() {
            synchronized (paper) {
                System.out.println("Person B: Holding the paper and waiting for the pen...");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

                synchronized (pen) {
                    System.out.println("Person B: Got the pen and writing...");
                }
            }
        }
    }
}
