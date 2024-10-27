package com.minicheckers;

import java.util.Random;

public class AIPlayer extends Player {

    public AIPlayer(String name) {
        super(name);
    }

    public void makeMove(Board board) {
        // Simple random move logic for AI (expand with better algorithms as needed)
        Random rand = new Random();
        int fromRow, fromCol, toRow, toCol;

        do {
            fromRow = rand.nextInt(8);
            fromCol = rand.nextInt(8);
            toRow = fromRow + (rand.nextBoolean() ? 1 : -1);
            toCol = fromCol + (rand.nextBoolean() ? 1 : -1);
        } while (!board.movePiece(fromRow, fromCol, toRow, toCol, this));
    }
}
