package com.bol.test;

import java.util.Scanner;

public class Board {

	int pit, player;
	Scanner input = new Scanner(System.in);
	int[] board = new int[14];

	void printBoard() {
		int i = 0;
		System.out.println("");
		for (i = 13; i > 7; i--) {
			System.out.print("\t" + board[i]);
		}
		System.out.print("\n\n" + board[0]);
		System.out.println("\t\t\t\t\t\t\t" + board[7] + "\n");
		for (i = 1; i < 7; i++) {
			System.out.print("\t" + board[i]);
		}
		System.out.println("\n");

	}

	void initilizeBoard() {
		for (int i = 1; i < 7; i++) {
			board[i] = 6;
			board[i + 7] = 6;
		}
	}

	boolean move(int pit, int playerIndex) {
		int i;
		pit += playerIndex;
		int stones = board[pit] + pit;
		board[pit] = 0;

		for (i = pit + 1; i <= stones; i++) {
			if (playerIndex == 0) {
				if ((i % 14) != 0)
					board[i % 14]++;
				else
					stones++;
			} else {
				if ((i % 14) != 7)
					board[i % 14]++;
				else
					stones++;
			}
		}
		if ((stones % 14 == 7 && playerIndex == 0) || (stones % 14 == 0 && playerIndex == 7)) {
			return true;
		}
		if (stones % 14 <= 6 && stones % 14 >= 1 && board[stones % 14] == 1 && board[14 - stones % 14] != 0
				&& playerIndex == 0) {
			System.out.println("You will add " + board[14 - (stones % 14)] + " stones to big pit");
			board[7] = board[7] + 1 + board[14 - (stones % 14)];
			board[14 - (stones % 14)] = 0;
			board[stones % 14] = 0;
		}

		if (stones % 14 <= 13 && stones % 14 >= 8 && board[stones % 14] == 1 && board[14 - stones % 14] != 0
				&& playerIndex == 7) {
			System.out.println("You will add " + board[14 - (stones % 14)] + " stones to big pit");
			board[0] = board[0] + 1 + board[14 - (stones % 14)];
			board[14 - (stones % 14)] = 0;
			board[stones % 14] = 0;
		}
		return false;
	}

	int gameOver() {
		int i;
		for (i = 1; i < 7; i++) {
			if (board[i] != 0)
				break;
			if (i == 6)
				return 0;
		}

		for (i = 8; i < 14; i++) {
			if (board[i] != 0)
				break;
			if (i == 13)
				return 7;
		}
		return -1;
	}

	void findWinner(int player) {
		int i;
		int player1StoneCount = 0;
		int player2StoneCount = 0;
		if (player == 0) {
			player1StoneCount = board[7];
			player2StoneCount = board[0];
			for (i = 8; i <= 13; i++) {
				player2StoneCount = player2StoneCount + board[i];
				board[i] = 0;
			}
			board[0] = player2StoneCount;
		} else {
			player2StoneCount = board[0];
			for (i = 1; i < 7; i++) {
				player1StoneCount = player1StoneCount + board[i];
				board[i] = 0;
			}
			board[7] = player1StoneCount;
		}

		System.out.println("Game Ended!");
		printBoard();
		if (player1StoneCount > player2StoneCount)
			System.out.println("\nPlayer1 wins!\n");
		else if (player1StoneCount < player2StoneCount)
			System.out.println("\nPlayer2 wins\n");
		else
			System.out.println("\nBoth have same stone count. Play again!!\n");
	}

}
