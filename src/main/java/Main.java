import java.security.NoSuchAlgorithmException;

/**
 * Class Main is responsible for start all needed classes
 * <p>
 * First of all it create instance of class InputData which start
 * all responsible for read from keyboard methods
 * <p>
 * Second it create instance of class Store which generate an random
 * Queue of object Car
 * <p>
 * Thirdly it create instance of class EndProgram which stop Producers
 * when user tap button 'q" and finish executing of program
 * <p>
 * In the fourth starts all threads of consumers, producers and endOfProgram
 */
public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        //Call and work with InputData
        InputData inputData = new InputData();

        //Create store statement
        Store store = new Store();
        store.setQueue();

        //Create EndProgram thread
        EndProgram endProgram = new EndProgram();

        //Start Consumers and Producers Threads
        inputData.getConsumers().forEach(Thread::start);
        inputData.getProducers().forEach(Thread::start);

        //start end of program thread
        Thread endOfProgram = new Thread(endProgram,"EndProgram");
        endOfProgram.start();

    }
}
