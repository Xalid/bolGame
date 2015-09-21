package com.bol.test;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		board.initilizeBoard();
		board.printBoard();
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		boolean turn = false;
		int playerIndex = 0;

		System.out.println("In order to choose which player to start first among Player1 and Player2,"
				+ "Player1 will enter 0 for even or 1 for odd and then I will generate a random integer"
				+ "if random integer is same category that Player1 entered, Player1 will start otherwise Player2 will start");

		System.out.println("\nPlayer1 enter 0 for even or 1 for odd");

		if (input.nextInt() % 2 == random.nextInt() % 2) {
			System.out.println("Player1 will start");
		} else {
			System.out.println("Player2 will start");
			playerIndex = 7;
		}

		while (board.gameOver() == -1) {

			do {

				if (board.gameOver() == 0 || board.gameOver() == 7) {
					break;
				}

				if (turn) {
					System.out.println("You got an extra turn");
				}

				System.out.println("\n Enter the pit number (It must be between 1 and 6)");
				board.pit = input.nextInt();

				while (board.pit > 6 || board.pit < 1) {
					System.out.println("Choose pit between 1 and 6");
					board.pit = input.nextInt();
				}

				while (board.board[board.pit + playerIndex] == 0) {
					System.out.println("The selected pit has no stones. Choose a different one.\n");
					board.pit = input.nextInt();
					while (board.pit > 6 || board.pit < 1) {
						System.out.println("Choose pit between 1 and 6");
						board.pit = input.nextInt();
					}
				}

				turn = board.move(board.pit, playerIndex);
				board.printBoard();

				if (!turn) {
					System.out.println("Turn Changed");
					System.out.println("---------------------------------------------------------------------------");
					if (playerIndex == 0) {
						playerIndex = 7;
					} else {
						playerIndex = 0;
					}

				} else
					continue;

			} while (turn);

		}
		board.findWinner(board.gameOver());
	}

}
