package com.game.monopoly;

/**
 * Test class for Game.java.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/11/2020
 */
import com.apps.util.Prompter;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class GameTest {
    private Scanner scanner;
    private Prompter P1;
    private Game G1;

    @Before
    public void setUp() throws Exception {
        G1 = new Game();
    }
/*
    @Test
    public void testInputNumPlayers_whenValidNumber() throws FileNotFoundException {
        scanner = new Scanner(new File("responses/valid_input_number.txt"));
        P1 = new Prompter(scanner);

        G1.inputNumPlayers(P1);
        assertEquals(4, G1.getNumPlayers());
    }

    @Test
    public void testInputNumPlayers_whenInvalidNumber_lowerLimit() throws FileNotFoundException {
        scanner = new Scanner(new File("responses/invalid_input_numPlayers_lowerLimit.txt"));
        P1 = new Prompter(scanner);

        G1.inputNumPlayers(P1);
        assertEquals(2, G1.getNumPlayers());
    }

    @Test
    public void testInputNumPlayers_whenInvalidNumber_upperLimit() throws FileNotFoundException {
        scanner = new Scanner(new File("responses/invalid_input_numPlayers_upperLimit.txt"));
        P1 = new Prompter(scanner);

        G1.inputNumPlayers(P1);
        assertEquals(8, G1.getNumPlayers());
    }

    @Test
    public void testInputNumRounds_whenValidNumber() throws FileNotFoundException {
        scanner = new Scanner(new File("responses/valid_input_number.txt"));
        P1 = new Prompter(scanner);

        G1.inputNumRounds(P1);
        assertEquals(4, G1.getNumRounds());
    }

    @Test
    public void testInputNumRounds_whenInvalidNumber_lowerLimit() throws FileNotFoundException {
        scanner = new Scanner(new File("responses/invalid_input_numRounds_lowerLimit.txt"));
        P1 = new Prompter(scanner);

        G1.inputNumRounds(P1);
        assertEquals(1, G1.getNumRounds());
    }

    @Test
    public void testInputNumRounds_whenInvalidNumber_upperLimit() throws FileNotFoundException {
        scanner = new Scanner(new File("responses/invalid_input_numRounds_upperLimit.txt"));
        P1 = new Prompter(scanner);

        G1.inputNumRounds(P1);
        assertEquals(9999, G1.getNumRounds());
    }

    @Test
    public void testInitializePlayers_withMixedValidAndInvalid() throws FileNotFoundException {
        scanner = new Scanner(new File("responses/input_initializePlayers.txt"));
        P1 = new Prompter(scanner);

        G1.setNumPlayers(3);
        G1.initializePlayers(P1);
        assertEquals("Greg", G1.getPlayerList().get(0).getName());
        assertEquals("CAT", G1.getPlayerList().get(0).getGamePiece().toString());
        assertEquals("12G", G1.getPlayerList().get(1).getName());
        assertEquals("TOP_HAT", G1.getPlayerList().get(1).getGamePiece().toString());
        assertEquals("Santa", G1.getPlayerList().get(2).getName());
        assertEquals("T_REX", G1.getPlayerList().get(2).getGamePiece().toString());
    }

    @Test
    public void testCheckBankruptcy() {
        Player player1 = new Player("Greg", Piece.TOP_HAT, 1);
        player1.declareBankruptcy();
        Player player2 = new Player("Reginald", Piece.CAT, 2);

        G1.getPlayerList().add(player1);
        G1.getPlayerList().add(player2);

        assertEquals("Greg", G1.getPlayerList().get(0).getName());
        assertEquals("TOP_HAT", G1.getPlayerList().get(0).getGamePiece().toString());
        assertEquals("Reginald", G1.getPlayerList().get(1).getName());
        assertEquals("CAT", G1.getPlayerList().get(1).getGamePiece().toString());
        assertEquals(0, G1.getBankruptcies().size());

        G1.checkBankruptcy(player1);
        assertEquals("Reginald", G1.getPlayerList().get(0).getName());
        assertEquals("CAT", G1.getPlayerList().get(0).getGamePiece().toString());
        assertEquals("Greg", G1.getBankruptcies().peek().getName());
        assertEquals("TOP_HAT", G1.getBankruptcies().peek().getGamePiece().toString());
    }

    @Test
    public void testPassGo_playerPassedGo() {
        Player player1 = new Player("Greg", Piece.TOP_HAT, 1);
        player1.setPassedGo(true);
        G1.passGo(player1);

        assertEquals(1700, player1.getWallet());
    }

    @Test
    public void testPassGo_playerDidntPassGo() {
        Player player1 = new Player("Greg", Piece.TOP_HAT, 1);
        G1.passGo(player1);

        assertEquals(1500, player1.getWallet());
    }

    @Test
    public void testPlayAgain_withVariousResponses() throws FileNotFoundException {
        scanner = new Scanner(new File("responses/response-and-retry.txt"));
        P1 = new Prompter(scanner);

        G1.playAgain(P1); //input: y
        assertTrue(G1.wantsToPlayAgain());
        G1.playAgain(P1); //input: Y
        assertTrue(G1.wantsToPlayAgain());
        G1.playAgain(P1); //input: n
        assertFalse(G1.wantsToPlayAgain());
        G1.playAgain(P1); //input: N
        assertFalse(G1.wantsToPlayAgain());
        G1.playAgain(P1); //input: X, then n
        assertFalse(G1.wantsToPlayAgain());
    }
    */
}