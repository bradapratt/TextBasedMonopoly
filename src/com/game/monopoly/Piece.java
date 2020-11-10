package com.game.monopoly;

import java.util.ArrayList;
import java.util.List;

enum Piece {
    SCOTTISH_TERRIER, BATTLESHIP, RACE_CAR, TOP_HAT, PENGUIN, T_REX, CAT, RUBBER_DUCKY;

    /**
     * Generates a list of toStrings for enum class. Useful for comparing against user input.
     * @return pieces
     */
    public static List<String> classToString(){
        List<String> pieces = new ArrayList<>();
        pieces.add(Piece.SCOTTISH_TERRIER.toString());
        pieces.add(Piece.BATTLESHIP.toString());
        pieces.add(Piece.RACE_CAR.toString());
        pieces.add(Piece.TOP_HAT.toString());
        pieces.add(Piece.PENGUIN.toString());
        pieces.add(Piece.T_REX.toString());
        pieces.add(Piece.CAT.toString());
        pieces.add(Piece.RUBBER_DUCKY.toString());

        return pieces;
    }
}
