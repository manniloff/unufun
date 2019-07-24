import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Class Store have static Queue , Class Producer and Class Consumer
 * have access to this queue and can make changes in him
 */

class Store {
    private static Queue<Car> queue = new LinkedList<>();
    private boolean canStart = false;

    /**
     * void setQueue - in this method Queue is filled with random objects of Car type
     */
    void setQueue() throws NoSuchAlgorithmException {
        for (int i = 1; i <= InputData.storeStoke; i++) {
            queue.add(new Car(CarModel.getRandomModel(), CarType.getRandomType(), (int) (Math.random() * 200)));
        }
    }

    Queue<Car> getQueue() {
        return queue;
    }

    /**
     * void add - synchronized method which adds object of Car type in Queue
     */
    synchronized void poll() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        try {

            Thread.sleep(500);
            Car car = queue.poll();
            System.out.println("\u001B[31m" + Thread.currentThread().getName() + " buy " + car.getCarModel() + " " + car.getCarType() + " " + car.getCarSpeed() + " ,left " + queue.size() + " cars");
        }catch (NullPointerException e){
            System.out.println("Throws an exception: "+e);
        }
        notifyAll();
    }

    /**
     * void poll - synchronized method which remove object of Car type from Queue
     */
    synchronized void add() throws InterruptedException, NoSuchAlgorithmException {
        while (queue.size() >= InputData.topLayer) {
            canStart = false;
            wait();
        }
        if (canStart) {
            try {

                Thread.sleep(200);
                Car newCar = new Car(CarModel.getRandomModel(), CarType.getRandomType(), (int) (Math.random() * 200));
                queue.add(newCar);
                System.out.println("\u001B[34m" + Thread.currentThread().getName() + " add " + newCar.getCarModel() + " " + newCar.getCarType() + " " + newCar.getCarSpeed() + " car to store, total: " + queue.size());
            }catch (NullPointerException e){
                System.out.println("Thread throw an exception: "+e);
            }
        } else if (queue.size() <= InputData.bottomLayer) {
            canStart = true;
        }
        notifyAll();
    }
}




