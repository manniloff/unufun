import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * This Enum contain model of Car which used when
 * random we created object of Car type
 * <p>
 * CarModel getRandomType - this method get one random element
 * from enum CarModel
 */

public enum CarModel {

    BMW,
    MERCEDES,
    TOYOTA,
    VOLKSWAGEN,
    FORD,
    FERARRI,
    VAZ,
    DACIA,
    RENAULT,
    PORCHE;


    public static CarModel getRandomModel() throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        return values()[random.nextInt(values().length)];
    }
}
