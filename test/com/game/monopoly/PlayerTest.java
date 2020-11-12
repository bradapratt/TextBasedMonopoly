package com.game.monopoly;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class PlayerTest {


    /**
     * Player moves to location
     */
    @Test
    public void playerMovesToSpace(){
        Player p1 = new Player("Steve",Piece.BATTLESHIP,1);
        Property prop1 = new Property("Boardwalk", 400, 100);
        p1.setLocation(2);  //Player is on Community Chest
        p1.movePlayer(7); //Player rolls a 7 and moves to Chance
        assertEquals(9,p1.getLocation());
        System.out.println(p1.getLocation());
    }

    @Test
    public void playerPassesGoAndStaysInRangeOfBoard(){
        Player p1 = new Player("Steve",Piece.BATTLESHIP,1);
        p1.setLocation(35);
        p1.movePlayer(8);
        assertEquals(5,p1.getLocation());
        System.out.println(p1.getLocation());
    }
    @Test
    public void addPropertyToPlayerPropertyList(){
        Player p1 = new Player("Steve",Piece.BATTLESHIP,1);
        Property prop1 = new Property("Boardwalk", 400, 100);
        Property prop2 = new Property("Park Place",350,35);
        p1.addProperty(prop1);
        p1.addProperty(prop2);
        assertEquals("Boardwalk",p1.getProperties().get(0).getName());
        assertEquals(350,p1.getProperties().get(1).getPrice());
    }

    @Test
    public void removePropertyFromPlayerList(){
        Player p1 = new Player("Steve",Piece.BATTLESHIP,1);
        Property prop1 = new Property("Boardwalk", 400, 100);
        Property prop2 = new Property("Park Place",350,35);
        p1.addProperty(prop1);
        p1.addProperty(prop2);
        p1.removeProperty(prop1);
        assertEquals(1,p1.getProperties().size());
    }

    @Test
    public void walletZeroAndAllPropertiesRemovedIfBankrupt(){
        Player p1 = new Player("Steve",Piece.BATTLESHIP,1);
        Property prop1 = new Property("Boardwalk", 400, 100);
        Property prop2 = new Property("Park Place",350,35);
        p1.addProperty(prop1);
        p1.addProperty(prop2);
        p1.declareBankruptcy();
        assertEquals(0,p1.getWallet());
        assertEquals(0,p1.getProperties().size());
    }

    @Test
    public void playerTransfersAssets(){
        Player p1 = new Player("Steve",Piece.BATTLESHIP,1);
        Player p2 = new Player("Joe",Piece.CAT,2);
        Property prop1 = new Property("Boardwalk", 400, 100);
        Property prop2 = new Property("Oriental Avenue",100,6);
        p2.addProperty(prop2);
        p1.addProperty(prop1);
        p1.movePlayer(6);
        p1.declareBankruptcy(p2);
        assertEquals(0,p1.getProperties().size());
        assertEquals(2,p2.getProperties().size());

    }
}
