package com.ttt.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
	public static final Character FIRST_PLAYER = 'X';
	public static final Character SECOND_PLAYER = 'O';
	public static final String FFIELD_IS_OCCUPIED = "Field is occupied!";
	public static final String ERROR_MSG_OF_X_VALUE_IF_OUTSIDE_THE_BOARD = "X value is outside the board!";
	public static final String ERROR_MSG_OF_Y_VALUE_IF_OUTSIDE_THE_BOARD = "Y value is outside the board!";
	public static final String X_IS_THE_WINNER = "X is the Winner";
	public static final String O_IS_THE_WINNER = "O is the Winner";
	public static final String ALL_FIELDS_ARE_FILLED_SO_ITS_DRAW = "It is a draw";


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
		String expectedMessage = FFIELD_IS_OCCUPIED;
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void playWithFIrstPlayer() {
		assertEquals(FIRST_PLAYER, ticTacToe.nextPlayer());
	}

	@Test
	public void givenLastTurnWasXWhenNextPlayerShouldBeO() {
		ticTacToe.play(1, 1);
		assertEquals(SECOND_PLAYER, ticTacToe.nextPlayer());
	}

	@Test
	public void whenXValueIsOutSideTheBoard() {
		Exception exception = assertThrows(TicTacToeException.class, () -> {
			ticTacToe.play(5, 2);
		});
		String expectedMessage = ERROR_MSG_OF_X_VALUE_IF_OUTSIDE_THE_BOARD;
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void whenYOutsideBoardThenRuntimeException() {
		Exception exception = assertThrows(TicTacToeException.class, () -> {
			ticTacToe.play(2, 6);
		});
		String expectedMessage = ERROR_MSG_OF_Y_VALUE_IF_OUTSIDE_THE_BOARD;
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void playWithVerticalLine() {
		ticTacToe.play(1, 1); // X
		ticTacToe.play(1, 2); // O
		ticTacToe.play(2, 1); // X
		ticTacToe.play(2, 2); // O
		String actual = ticTacToe.play(3, 1); // X
		assertEquals(X_IS_THE_WINNER, actual);
	}

	@Test
	public void playWithHorizontalLine() {
		ticTacToe.play(2, 1); // X
		ticTacToe.play(1, 1); // O
		ticTacToe.play(3, 1); // X
		ticTacToe.play(1, 2); // O
		ticTacToe.play(2, 2); // X
		String actual = ticTacToe.play(1, 3); // O
		assertEquals(O_IS_THE_WINNER, actual);
	}

	@Test
	public void playWithLeftDiagonal() {
		ticTacToe.play(1, 1); // X
		ticTacToe.play(1, 2); // O
		ticTacToe.play(2, 2); // X
		ticTacToe.play(1, 3); // O
		String actual = ticTacToe.play(3, 3); // X
		assertEquals(X_IS_THE_WINNER, actual);

	}

	@Test
	public void playWithRightDiagonal() {
		ticTacToe.play(1, 3); // X
		ticTacToe.play(1, 1); // O
		ticTacToe.play(2, 2); // X
		ticTacToe.play(1, 2); // O
		String actual = ticTacToe.play(3, 1); // X
		assertEquals(X_IS_THE_WINNER, actual);
	}

	@Test
	public void whenAllFieldsAreFilledThenDraw() {
		ticTacToe.play(1, 1);
		ticTacToe.play(1, 2);
		ticTacToe.play(1, 3);
		ticTacToe.play(2, 1);
		ticTacToe.play(2, 3);
		ticTacToe.play(2, 2);
		ticTacToe.play(3, 1);
		ticTacToe.play(3, 3);
		String actual = ticTacToe.play(3, 2);
		assertEquals(ALL_FIELDS_ARE_FILLED_SO_ITS_DRAW, actual);

	}

}
