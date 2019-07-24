/**
 * Interface ICar describe methods which need to be implemented
 * in class cu implement this interface
 */

public interface ICar {
    public CarModel getCarModel();

    public void setCarModel(CarModel carModel);

    public CarType getCarType();

    public void setCarType(CarType carType);

    public int getCarSpeed();

    public void setCarSpeed(int carSpeed);

}
