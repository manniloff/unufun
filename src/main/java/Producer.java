/**
 * Producer is a class which responsible about behavior of all
 * threads of this class.
 * <p>
 * This class implements interface Runnable and realized method run
 * which contain condition of running of thread
 */

public class Producer implements Runnable {
    private Store store;
    private EndProgram endProgram = new EndProgram();

    /**
     * @param store
     */
    Producer(Store store) {
        this.store = store;
    }

    /**
     * Describe behavior of producers threads
     */
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            boolean endSignal = endProgram.getIsRunning();
            if (!endSignal) {
                Thread.currentThread().interrupt();
            } else {

                try {
                    store.add();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        }
    }
}

