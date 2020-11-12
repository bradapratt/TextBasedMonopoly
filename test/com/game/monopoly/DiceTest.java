package com.game.monopoly;

/**
 * Test class for Dice.java.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/12/2020
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class DiceTest {

    @Test
    public void testRollDice() {
        for (int i = 0; i < 1000; i++){
            int roll = Dice.rollDice();
            if (roll > 6 || roll < 1){
                fail();
            }
        }
    }
}