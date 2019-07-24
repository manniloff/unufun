import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class catch input data for running program
 * conform user wishes
 */

@Getter
class InputData {
    static int topLayer;
    static int bottomLayer;
    static int storeStoke;
    Scanner scanner = new Scanner(System.in);
    List<Thread> consumers = new ArrayList<>();
    List<Thread> producers = new ArrayList<>();
    Store store = new Store();

    InputData() {
        insertStoreStock();
        insertHeightLayer();
        insertLowerLayer();
        numberOfConsumers();
        numberOfProducers();
    }

    /**
     * in this method program read number of consumers
     * from keyboard and generate threads for this consumers
     */
    private void numberOfConsumers() {
        //Insert number of Consumers from keyboard
        System.out.println("Insert number of Consumers: ");
        int numberOfConsumers = scanner.nextInt();

        for (int i = 0; i < numberOfConsumers; i++) {
            consumers.add(new Thread(new Consumer(store), "Consumer" + i));
        }
    }

    /**
     * in this method program read number of producers
     * from keyboard and generate threads for this consumers
     */
    private void numberOfProducers() {

        //Insert number of Producers from keyboard
        System.out.println("Insert number of Producers: ");
        int numberOfProducers = scanner.nextInt();

        for (int i = 0; i < numberOfProducers; i++) {
            String threadName = "Producer" + i;
            producers.add(new Thread(new Producer(store), threadName));

        }
    }

    /**
     * in this method program read top layer for producers
     */
    private void insertHeightLayer() {
        System.out.println("Insert height layer:");
        topLayer = scanner.nextInt();
    }

    /**
     * in this method program read bottom layer for producers
     */
    private void insertLowerLayer() {
        System.out.println("Insert lower layer:");
        bottomLayer = scanner.nextInt();
        if (bottomLayer >= topLayer) {
            System.out.println("Bottom layer can't be more then top layer,Insert lower layer again:");
            bottomLayer = scanner.nextInt();
        }

    }

    /**
     * in this method program read size of Queue
     */
    private void insertStoreStock() {
        System.out.println("Insert existing stoke:");
        storeStoke = scanner.nextInt();
    }

}
