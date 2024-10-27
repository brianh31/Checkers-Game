package com.minicheckers;

public class Board {
    private final Piece[][] board = new Piece[8][8];

    public void initializeBoard() {
        // Initialize player pieces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 1) {
                    board[i][j] = new Piece("AI");
                }
            }
        }

        // Initialize AI pieces
        for (int i = 5; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 1) {
                    board[i][j] = new Piece("Player");
                }
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j].getSymbol() + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean movePiece(int fromRow, int fromCol, int toRow, int toCol, Player player) {
        if (isValidMove(fromRow, fromCol, toRow, toCol, player)) {
            board[toRow][toCol] = board[fromRow][fromCol];
            board[fromRow][fromCol] = null;
            return true;
        }
        return false;
    }

    private boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, Player player) {
        // Add basic move validation logic (e.g., diagonal moves, capturing pieces)
        if (board[fromRow][fromCol] == null || !board[fromRow][fromCol].getOwner().equals(player.getName())) {
            return false;
        }
        // Example simple movement validation
        return Math.abs(fromRow - toRow) == 1 && Math.abs(fromCol - toCol) == 1 && board[toRow][toCol] == null;
    }

    public boolean isGameOver() {
        // Add simple game over logic (e.g., all pieces captured)
        return false;
    }
}
