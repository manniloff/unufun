/**
 * Consumer is a class which responsible about behavior of all
 * threads of this class.
 * <p>
 * This class implements interface Runnable and realized method run
 * which contain condition of running of thread
 */

public class Consumer implements Runnable {
    private Store store;

    Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (store.getQueue().isEmpty()) {
                Thread.currentThread().interrupt();
                System.out.println("Program Exit");
                System.exit(0);
            } else {
                try {
                    store.poll();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(e);
                }
            }
        }
    }
}
