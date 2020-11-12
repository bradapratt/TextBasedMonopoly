package com.game.monopoly;

/**
 * Test class for Railroad.java.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/12/2020
 */
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
    private Railroad prop2;
    private Railroad prop3;
    private Railroad prop4;

    @Before
    public void setUp() {
        p1 = new Player("John", Piece.CAT, 1);
        p2 = new Player("Sara", Piece.RUBBER_DUCKY, 2);
        p1.setWallet(1500);
        p2.setWallet(1500);
        prop1 = new Railroad("Reading Railroad", 200);
        prop2 = new Railroad("Pennsylvania RR", 200);
        prop3 = new Railroad("B&O RR", 200);
        prop4 = new Railroad("Short Line", 200);
    }

    @Test
    public void testRentOneRROwnedByP1() throws Exception{
        Prompter input = new Prompter(new Scanner(new File("responses/responses.txt")));
        prop1.execute(p1, 5, input);
        prop1.execute(p2, 5, input);

        assertEquals(1325, p1.getWallet());
        assertTrue(prop1.isOwned());
        assertTrue(p1.equals(prop1.getOwner()));
        assertEquals(1475, p2.getWallet());

    }

    @Test
    public void testRentTwoRROwnedByP1() throws Exception{
        Prompter input = new Prompter(new Scanner(new File("responses/responses.txt")));
        prop1.execute(p1, 5, input);
        prop2.execute(p1, 5, input);
        prop2.execute(p2, 5, input);

        assertEquals(1150, p1.getWallet());
        assertTrue(prop2.isOwned());
        assertTrue(p1.equals(prop2.getOwner()));
        assertEquals(1450, p2.getWallet());

    }

    @Test
    public void testExecuteBuyRRNotCurrentlyOwned() throws Exception {
        Prompter input = new Prompter(new Scanner(new File("responses/responses.txt")));
        prop1.execute(p1, 5, input);

        assertEquals(1300, p1.getWallet());
        assertTrue(prop1.isOwned());
        assertTrue(p1.equals(prop1.getOwner()));
    }
}