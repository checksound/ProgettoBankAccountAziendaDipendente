package org.example.utils;

import java.util.Random;

public class RandomGen {

    private static Random random = new Random();

    public static int getRandom() {
        return random.nextInt(0, 4);
    }

}
