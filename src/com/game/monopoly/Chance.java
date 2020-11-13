package com.game.monopoly;

/**
 * Class Chance represents the Chance space on a Monopoly board.
 * <p>
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/11/2020
 */

import com.apps.util.Prompter;

import java.util.concurrent.ThreadLocalRandom;

public class Chance extends RandomCard {
    private static final int MIN = 1;
    private static final int MAX = 6;

    public Chance() {
        super("Chance");
    }

    /**
     * Execute actions taken when landing on this space.
     * @param player - current player
     * @param diceRoll - current player's dice roll total
     */
    @Override
    public void execute(Player player, int diceRoll, Prompter input) {
        displayMessage();
        drawCard(player, diceRoll);
    }

    /**
     * Informs player they landed on Chance.
     */
    @Override
    public void displayMessage() {
        Message.landedChance();
    }

    /**
     * Generate random int to choose a "card" and take actions of that card.
     */
    public void drawCard(Player player, int diceRoll) {
        int rand = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
        switch (rand) {
            case 1:
                Message.ChanceCard1();
                Bank.pay(player, 400);
                break;
            case 2:
                Message.ChanceCard2();
                Bank.collect(player, 35);
                break;
            case 3:
                Message.ChanceCard3();
                Bank.collect(player, 200);
                break;
            case 4:
                Message.ChanceCard4();
                Bank.pay(player, 215);
                break;
            case 5:
                Message.ChanceCard5();
                Bank.collect(player, 100);
                break;
            case 6:
                Message.ChanceCard6();
                Bank.pay(player, 300);
                break;
        }
    }
}
