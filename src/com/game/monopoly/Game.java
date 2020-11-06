package com.game.monopoly;

import java.util.List;

public class Game {
    private List<Player> playerList;
    private List<Space> board;
    private int numRounds;
    private int numPlayers;

    /**
     * Initialize the board;
     */
    public Game() {
    }

    /**
     * Send welcome message to console, prompt players for info, set values, etc.
     */
    public void startGame(){
    }

    private void printWelcomeMsg(){

    }

    /**
     * Accessory method to startGame()
     */
    private void setUp(){
    }

    private int getNumRounds(){
        return 0;
    }

    private int getNumPlayers(){
        return 0;
    }

    /**
     * Create the player objects and initialize all their values.
     */
    private void initializePlayers(){
    }

    /**
     * Game will begin each round, and rotate through players' turns.
     */
    private void startRound(){
        //for each Player: rollDice() x2, Player.takeTurn()
    }

    /**
     * Game will end the round, display current rankings, notify #of rounds left, decrement round count.
     */
    private void endRound(){
    }

    /**
     * Accessory method for checking number rounds that are left.
     * @return
     */
    private int checkRoundCount(){
        return 0;
    }

    /**
     * Wrap up the game, display winners, ask players if they want to start another game.
     */
    private void endGame(){
    }

    /**
     * Displays current winner/rankings to console.
     */
    private void displayCurrentWinner(){
    }

    /**
     * Returns the roll for one six-sided die.
     * @return
     */
    private int rollDice(){
        return 0;
    }
}
