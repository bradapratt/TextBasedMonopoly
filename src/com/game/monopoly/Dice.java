package com.game.monopoly;

/**
 * Dice represents a six-sided die, and implements a roll function for the Monopoly game.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/11/2020
 */
import java.util.concurrent.ThreadLocalRandom;

class Dice {
    private static final int MIN_ROLL = 1;
    private static final int NUM_SIDES = 6;

    /**
     * Returns a random number between the set bounds
     * @return - [1, 7)
     */
    public static int rollDice(){
        int rand = ThreadLocalRandom.current().nextInt(MIN_ROLL, NUM_SIDES + 1);
        return rand;
    }

}
