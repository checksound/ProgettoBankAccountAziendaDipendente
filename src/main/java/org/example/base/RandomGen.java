package org.example.base;

import java.util.Random;

public class RandomGen {

    private static Random random = new Random();

    public static int getRandom() {
        return random.nextInt(0, 100);
    }

}
