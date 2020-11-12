package com.game.monopoly;

import com.apps.util.Prompter;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.*;

public class BankTest {
    private Player p1;
    private Player p2;
    private Property prop1;
    private TaxSpace tax1;
    private FreeParking park;

    @Before
    public void setUp() {
        p1 = new Player("John", Piece.CAT, 1);
        p2 = new Player("Sara", Piece.RUBBER_DUCKY, 2);
        p1.setWallet(1500);
        p2.setWallet(1500);
        prop1 = new Property("Atlantic Avenue", 260, 22);
        tax1 = new TaxSpace("Income Tax", 200);
        park = new FreeParking();
    }

    @Test
    public void testPayForPropertyWalletGreaterThanPropPrice() {
        assertTrue(Bank.payForProperty(p1, prop1.getPrice()));
        assertEquals(1240, p1.getWallet());
    }

    @Test
    public void testPayForPropertyWalletLessThanPropPrice() {
        p1.setWallet(100);

        assertFalse(Bank.payForProperty(p1, prop1.getPrice()));
        assertEquals(100, p1.getWallet());
    }

    @Test
    public void testPayForPropertyWalletEqualToPropertyPrice() {
        p1.setWallet(260);

        assertTrue(Bank.payForProperty(p1, 260));
        assertEquals(0, p1.getWallet());
    }

    @Test
    public void testPayRentToPlayerTwoWithPlayerOneEnoughMoney() {
        prop1.setOwner(p2);
        int rent = prop1.rent(6);
        Bank.payRent(p1, p2, rent);
        assertEquals(1478, p1.getWallet());
        assertEquals(1522, p2.getWallet());
    }

    @Test
    public void testPayRentToPlayerTwoWithPlayerOneNotEnoughMoney() {
        p1.setWallet(20);
        prop1.setOwner(p2);
        int rent = prop1.rent(5);
        Bank.payRent(p1, p2, rent);

        assertEquals(0, p1.getWallet());
        assertTrue(p1.isBankrupt());
    }

    @Test
    public void testPayRentToPlayerTwoWithPlayerOneEqualMoney() {
        p1.setWallet(22);
        prop1.setOwner(p2);
        int rent = prop1.rent(4);
        Bank.payRent(p1, p2, rent);

        assertEquals(0, p1.getWallet());
        assertEquals(1522, p2.getWallet());
    }

    @Test
    public void testPayTaxIntoFreeParking() throws Exception {
        Prompter input = new Prompter(new Scanner(new File("responses/responses.txt")));
        tax1.execute(p1, 5, input);

        assertEquals(1300, p1.getWallet());
//        assertEquals(200, FreeParking.getFreeParking());

    }
}