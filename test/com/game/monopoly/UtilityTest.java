package com.game.monopoly;

import com.apps.util.Prompter;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.*;

public class UtilityTest {
    private Player p1;
    private Player p2;
    private Utility prop1;
    private Utility prop2;

    @Before
    public void setUp() {
        p1 = new Player("John", Piece.CAT, 1);
        p2 = new Player("Sara", Piece.RUBBER_DUCKY, 2);
        p1.setWallet(1500);
        p2.setWallet(1500);
        prop1 = new Utility("Electric Company", 150);
        prop2 = new Utility("Water Works", 150);
    }

    @Test
    public void testRentOneUtilityOwnedByP1_7Rolled() throws Exception {
        Prompter input = new Prompter(new Scanner(new File("responses/responses.txt")));
        prop1.execute(p1, 5, input);
        prop1.execute(p2, 7, input);

        assertEquals(1378, p1.getWallet());
        assertTrue(prop1.isOwned());
        assertTrue(p1.equals(prop1.getOwner()));
        assertEquals(1472, p2.getWallet());
//        assertTrue(p1.getProperties().contains(prop1));
    }

    @Test
    public void testRentBothUtilityOwnedByP1_12Rolled() throws Exception {
        Prompter input = new Prompter(new Scanner(new File("responses/responses.txt")));
        prop1.execute(p1, 5, input);
        prop2.execute(p1, 5, input);
        prop1.execute(p2, 12, input);
        prop2.execute(p2, 7, input);

        assertEquals(1390, p1.getWallet());
        assertTrue(prop1.isOwned());
        assertTrue(prop2.isOwned());
        assertTrue(p1.equals(prop2.getOwner()));
        assertTrue(p1.equals(prop1.getOwner()));
        assertEquals(1310, p2.getWallet());
//        assertTrue(p1.getProperties().contains(prop1));
//        assertTrue(p1.getProperties().contains(prop2));
    }
}