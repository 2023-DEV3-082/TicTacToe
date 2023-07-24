package com.ttt.tdd;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class TicTacToeTest {

	@Test
	public void initializeNewTicTacToeGame() {
		TicTacToe ticTacToe = new TicTacToe();
		assertNotNull(ticTacToe);
	}

}
