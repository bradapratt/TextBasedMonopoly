package com.game.monopoly;

import java.util.concurrent.ThreadLocalRandom;

class Dice {
    private static final int MIN_ROLL = 1;
    private static final int NUM_SIDES = 6;

    public static int rollDice(){
        int rand = ThreadLocalRandom.current().nextInt(MIN_ROLL, NUM_SIDES + 1);
        return rand;
    }

}
