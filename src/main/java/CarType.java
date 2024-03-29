import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * This Enum contain type of Car which used when
 * random we created object of Car type
 * <p>
 * CarType getRandomType - this method get one random element
 * from enum CarType
 */

public enum CarType {
    SEDAN,
    HATCHBACK,
    WAGON,
    CROSSOVER,
    SUV,
    TRUCK,
    MPV,
    SPORT,
    COUPE,
    CONVERTIBLE;

    public static CarType getRandomType() throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        return values()[random.nextInt(values().length)];
    }
}
