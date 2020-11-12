package com.game.monopoly;

/**
 * Test class for Go.java.
 *
 * Authors: Bradley Pratt, Christopher Palmer, & Tyrone Moore
 * Last Edited: 11/11/2020
 */
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoTest {
    Go go1;
    Player player1;

    @Before
    public void setUp() throws Exception {
        go1 = new Go();
        player1 = new Player("Bob", Piece.TOP_HAT, 1);
    }
/*
    @Test
    public void collectGo() {
        assertEquals(1500, player1.getWallet());
        go1.collectGo(player1);
        assertEquals(1700, player1.getWallet());
    }*/
}