package com.game.monopoly.client;

/**
 * Main class for the Text-Based Monopoly game.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/10/2020
 */
import com.game.monopoly.Game;
import java.io.IOException;

public class GameClient {
    public static void main(String[] args) throws IOException {
        Game game1 = new Game();
        game1.startGame();
    }
}
