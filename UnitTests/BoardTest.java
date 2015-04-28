package UnitTests;

import static org.junit.Assert.*;
import org.junit.Test;

import MainApplet.*;
import GameClasses.*;

public class BoardTest 
{
	// testing constructor of board
	@Test
	public void testConstructor() {
		AppletMain testApplet = new AppletMain();
		
		int difficulty = 5;
		int expectedTrashCollectedScore = 0;
		
		Game testGame = new Game(difficulty, testApplet);
		Board testBoard = new Board(testGame, difficulty);
		
		// check if expected value true
		assertEquals(testBoard.getTrashCollectedScore(), expectedTrashCollectedScore);
	}

}
