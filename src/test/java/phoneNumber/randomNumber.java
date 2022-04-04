package phoneNumber;

import java.util.Random;

public class randomNumber {


    public String getRandomNumberString() {

        Random rnd = new Random();
        int firstNum = 0;
        int number = rnd.nextInt(999999999);

        return String.format("%01d%02d",firstNum,number);
    }
}
/**
 * Author : Naledi Constable
 * Class: randomNumber
 * Method : getRandomNumberString
 *Generates a 10 digit random number everytime you run
 */
