package com.game.monopoly;

import java.util.concurrent.ThreadLocalRandom;

class Dice {
    private final static int MIN_ROLL = 1;
    private static int numSides = 6;

    public static int rollDice(){
        int rand = ThreadLocalRandom.current().nextInt(MIN_ROLL, numSides + 1);
        return rand;
    }

}
