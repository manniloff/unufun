import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

/**
 * Class Car describe object Car
 */

@Data
@AllArgsConstructor
class Car implements ICar {
    @NonNull
    private CarModel carModel;
    @NonNull
    private CarType carType;
    @NonNull
    private int carSpeed;

}
