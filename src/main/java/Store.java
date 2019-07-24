import java.util.*;

/**
 * Class Store have static Queue , Class Producer and Class Consumer
 * have access to this queue and can make changes in him
 */

public class Store {
    private static Queue<Car> queue = new LinkedList<Car>();
    //static Queue<Car> q = (Queue<Car>) new HashSet<Car>();
    private boolean canStart = false;

    /**
     * void setQueue - in this method Queue is filled with random objects of Car type
     */
    void setQueue() {
        for (int i = 1; i <= InputData.storeStoke; i++) {
            queue.add(new Car(CarModel.getRandomModel(), CarType.getRandomType(), (int) (Math.random() * 200)));
        }
    }

    /**
     * Get Queue
     *
     * @return
     */
    Queue<Car> getQueue() {
        return queue;
    }

    /**
     * void add - synchronized method which adds object of Car type in Queue
     *
     * @return removed car
     * @throws InterruptedException
     */
    synchronized Car poll() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        Thread.sleep(500);
        Car car = queue.poll();
        System.out.println("\u001B[31m" + Thread.currentThread().getName() + " buy " + car.getCarModel() + " " + car.getCarType() + " " + car.getCarSpeed() + " ,left " + queue.size() + " cars");
        notify();
        return car;
    }

    /**
     * void poll - synchronized method which remove object of Car type from Queue
     *
     * @throws InterruptedException
     */
    synchronized void add() throws InterruptedException {
        while (queue.size() >= InputData.topLayer) {
            canStart = false;
            wait();
        }
        if (canStart) {
            Thread.sleep(200);
            Car newCar = new Car(CarModel.getRandomModel(), CarType.getRandomType(), (int) (Math.random() * 200));
            queue.add(newCar);
            System.out.println("\u001B[34m" + Thread.currentThread().getName() + " add " + newCar.getCarModel() + " " + newCar.getCarType() + " " + newCar.getCarSpeed() + " car to store, total: " + queue.size());
        } else if (queue.size() <= InputData.bottomLayer) {
            canStart = true;
        }
        notify();
    }
}




