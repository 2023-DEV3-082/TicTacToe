package com.ttt.tdd;

import com.ttt.exceptions.TicTacToeException;

public class TicTacToe {

	private Character[][] board = { { '\0', '\0', '\0' }, { '\0', '\0', '\0' }, { '\0', '\0', '\0' } };
	private char lastPlayer = '\0';

	public void play(int column, int row) {

		if (board[column - 1][row - 1] != '\0') {
			throw new TicTacToeException("Field is occupied!");
		} else {
			board[column - 1][row - 1] = 'X';
		}
		lastPlayer = nextPlayer();
	}

	public char nextPlayer() {
		if (lastPlayer == 'X') {
			return 'O';
		}
		return 'X';
	}

}
