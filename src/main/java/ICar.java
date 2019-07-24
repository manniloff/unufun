/**
 * Interface ICar describe methods which need to be implemented
 * in class cu implement this interface
 */

public interface ICar {
    CarModel getCarModel();

    void setCarModel(CarModel carModel);

    CarType getCarType();

    void setCarType(CarType carType);

    int getCarSpeed();

    void setCarSpeed(int carSpeed);

}
