package com.game.monopoly;

public class CommunityChest extends RandomCard{
    public CommunityChest(String name) {
        super(name);
    }

    @Override
    public void execute(Player player, int diceRoll) {

    }

    @Override
    public void displayMessage() {
    }

    /**
     * Generate random int to choose a "card" (possibly use a switch statement) and
     * take actions of that card.
     */
    public void drawCard(){
    }
}
