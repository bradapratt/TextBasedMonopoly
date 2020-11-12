package com.game.monopoly;

/**
 * Test class for Dice.java.
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