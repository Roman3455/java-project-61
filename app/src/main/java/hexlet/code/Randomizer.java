package hexlet.code;

import java.util.Random;

public class Randomizer {
    public static int getRandomIntNum(int bound) {
        Random randomNum = new Random();

        return randomNum.nextInt(bound);
    }
}
