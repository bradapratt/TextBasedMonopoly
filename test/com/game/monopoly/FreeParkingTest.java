package com.game.monopoly;

/**
 * Test class for FreeParking.java.
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FreeParkingTest {
    FreeParking freep;
    Player player1;
/*
    @Before
    public void setUp() throws Exception {
        freep = new FreeParking();
        player1 = new Player("Bob", Piece.TOP_HAT, 1);
        FreeParking.setFreeParking(0);
    }

    @Test
    public void testAddToFreeParking_validAmount() {
        assertEquals(0, FreeParking.getFreeParking());
        FreeParking.addToFreeParking(1000);
        assertEquals(1000, FreeParking.getFreeParking());
    }

    @Test
    public void testAddToFreeParking_invalidAmount() {
        assertEquals(0, FreeParking.getFreeParking());
        FreeParking.addToFreeParking(-1000);
        assertEquals(0, FreeParking.getFreeParking());
    }

    @Test
    public void testCollectFreeParking() {
        assertEquals(0, FreeParking.getFreeParking());
        FreeParking.addToFreeParking(1000);
        assertEquals(1000, FreeParking.getFreeParking());
        assertEquals(1500, player1.getWallet());

        freep.collectFreeParking(player1);
        assertEquals(0, FreeParking.getFreeParking());
        assertEquals(2500, player1.getWallet());
    }
 */
}