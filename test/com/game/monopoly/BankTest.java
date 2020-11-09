package com.game.monopoly;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {
    private Player p1;
    private Player p2;
    private Property prop1;

    @Before
    public void setUp() {
        p1 = new Player("John", Piece.CAT);
        p2 = new Player("Sara", Piece.RUBBER_DUCKY);
        p1.setWallet(1500);
        p2.setWallet(1500);
        prop1 = new Property("Atlantic Avenue", 260, 22);
    }

    @Test
    public void testPayForPropertyWalletGreaterThanPropPrice() {
        assertTrue(Bank.payForProperty(p1, 260));
    }

    @Test
    public void testPayForPropertyWalletLessThanPropPrice() {
        p1.setWallet(100);

        assertFalse(Bank.payForProperty(p1, 260));
    }

    @Test
    public void testPayForPropertyWalletEqualToPropPrice() {
        p1.setWallet(260);

        assertTrue(Bank.payForProperty(p1, 260));
    }

    @Test
    public void testPayRentToPlayerTwoWithPlayerOneEnoughMoney() {
        assertTrue(Bank.payRent(p1, p2, prop1.getRentAmt()));
        assertEquals(1478, p1.getWallet());
        assertEquals(1522, p2.getWallet());
    }

    @Test
    public void testPayRentToPlayerTwoWithPlayerOneNotEnoughMoney() {
        p1.setWallet(20);

        assertFalse(Bank.payRent(p1, p2, prop1.getRentAmt()));
        assertEquals(20, p1.getWallet());
        assertEquals(1500, p2.getWallet());
    }

    @Test
    public void testPayRentToPlayerTwoWithPlayerOneEqualMoney() {
        p1.setWallet(22);

        assertTrue(Bank.payRent(p1, p2, prop1.getRentAmt()));
        assertEquals(0, p1.getWallet());
        assertEquals(1522, p2.getWallet());
    }

    @Test
    public void testPayIntoFreeParking() {
        // TODO
    }
}