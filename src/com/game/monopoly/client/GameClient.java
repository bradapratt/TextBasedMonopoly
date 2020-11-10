package com.game.monopoly.client;

import com.apps.util.Prompter;
import com.game.monopoly.Game;

import java.io.IOException;
import java.util.Scanner;

public class GameClient {
    public static void main(String[] args) throws IOException {
        /**
         * Just some test code for the moment, this will be deleted later -Brad
         */
//        Prompter p1 = new Prompter(new Scanner(System.in));
//        String name = p1.prompt("Please enter your name: ");
//        System.out.println(name);
        Game game1 = new Game();
        game1.setUp();

    }
}
