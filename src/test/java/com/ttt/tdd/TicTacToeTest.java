package com.ttt.tdd;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.ttt.exceptions.TicTacToeException;

public class TicTacToeTest {

	TicTacToe ticTacToe = new TicTacToe();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void initializeNewTicTacToeGame() {
		assertNotNull(ticTacToe);
	}

	@Test
	public void checkIfDashBoardOccupied() {
		ticTacToe.play(2, 1);
		exception.expect(RuntimeException.class);
		Exception exception = assertThrows(TicTacToeException.class, () -> {
			ticTacToe.play(2, 1);
		});
		String expectedMessage = "Field is occupied!";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

}
