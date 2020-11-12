package com.game.monopoly;

/**
 * Class CommunityChest represents the Community Chest space on a Monopoly Board.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/11/2020
 */
import com.apps.util.Prompter;
import java.util.concurrent.ThreadLocalRandom;

public class CommunityChest extends RandomCard{
    private static final int MIN = 1;
    private static final int MAX = 6;
    public CommunityChest() {
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
        Message.landedCommunityChest();
    }

    /**
     * Generate random int to choose a "card" and take actions of that card.
     */
    public void drawCard(Player player, int diceRoll){
        int rand = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
        switch (rand){
            case 1:
                Message.CommunityChestCard1();
                Bank.pay(player, 200);
                break;
            case 2:
                Message.CommunityChestCard2();
                Bank.collect(player, 50);
                break;
            case 3:
                Message.CommunityChestCard3();
                Bank.collect(player, 150);
                break;
            case 4:
                Message.CommunityChestCard4();
                Bank.pay(player, 45);
                break;
            case 5:
                Message.CommunityChestCard5();
                Bank.collect(player, 100);
                break;
            case 6:
                Message.CommunityChestCard6();
                Bank.pay(player, 200);
                break;
        }
    }
}
