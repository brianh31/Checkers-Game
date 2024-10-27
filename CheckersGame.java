package com.minicheckers;

import java.util.Scanner;

public class CheckersGame {
    public static void main(String[] args) {
        Board board = new Board();
        Player player = new Player("Player");
        AIPlayer ai = new AIPlayer("AI");

        board.initializeBoard();
        board.displayBoard();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Player's turn
            System.out.println(player.getName() + "'s Turn:");
            System.out.println("Enter move (format: row1 col1 row2 col2): ");
            int fromRow = scanner.nextInt();
            int fromCol = scanner.nextInt();
            int toRow = scanner.nextInt();
            int toCol = scanner.nextInt();

            if (board.movePiece(fromRow, fromCol, toRow, toCol, player)) {
                board.displayBoard();
            } else {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            // Check for game over
            if (board.isGameOver()) {
                System.out.println("Game over! " + player.getName() + " wins!");
                break;
            }

            // AI's turn
            System.out.println(ai.getName() + "'s Turn:");
            ai.makeMove(board);
            board.displayBoard();

            // Check for game over
            if (board.isGameOver()) {
                System.out.println("Game over! " + ai.getName() + " wins!");
                break;
            }
        }

        scanner.close();
    }
}
