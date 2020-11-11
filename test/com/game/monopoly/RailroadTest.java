package com.game.monopoly;

import com.apps.util.Prompter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.*;

public class RailroadTest {
    private Player p1;
    private Player p2;
    private Railroad prop1;

    @Before
    public void setUp() {
        p1 = new Player("John", Piece.CAT, 1);
        p2 = new Player("Sara", Piece.RUBBER_DUCKY, 2);
        p1.setWallet(1500);
        p2.setWallet(1500);
        prop1 = new Railroad("Reading Railroad", 200);
    }

    @Test
    public void rent() {
    }

    @Test
    public void testExecuteBuyRRNotCurrentlyOwned() throws Exception {
        Prompter input = new Prompter(new Scanner(new File("responses/responses.txt")));
        prop1.execute(p1, 5, input);

        assertEquals(1300, p1.getWallet());
        assertTrue(prop1.isOwned());
        assertTrue(p1.equals(prop1.getOwner()));
    }

    @Test
    public void displayMessage() {
    }
}