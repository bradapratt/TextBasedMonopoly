package com.game.monopoly.client;

import com.apps.util.Prompter;
import com.game.monopoly.Game;

import java.io.IOException;
import java.util.Scanner;

public class GameClient {
    public static void main(String[] args) throws IOException {
        Game game1 = new Game();
        game1.startGame();
    }
}
