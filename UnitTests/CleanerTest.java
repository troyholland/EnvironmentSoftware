package UnitTests;

import GameClasses.*;
import MainApplet.*;
import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

// test cleaner functionality
public class CleanerTest {

	private AppletMain testApplet;
	private Game testGame;
	private Board testBoard;
	private Cleaner testCleaner;
	
	// initialize before to reuse
	@Before
	public void testCleaner() {
		testApplet = new AppletMain();
		testGame = new Game(5, testApplet);
		testBoard = new Board(testGame, 5);
		testCleaner = new Cleaner(testBoard, 5);
	}
	
	@Test
	public void testConstructor() {
		// expected values to check
		int expectedX = 120;
		int expectedY = 120;
		
		int expectedCleanerLength = 1;
		
		int expectedCleanerXDirection = 1;
		int expectedCleanerYDirection = 0;
		
		// check if correct
		assertEquals(testCleaner.cleanerHeadX, expectedX, 0);
		assertEquals(testCleaner.cleanerHeadY, expectedY, 0);
		
		assertEquals(testCleaner.cleanerLength, expectedCleanerLength, 0);
		
		assertEquals(testCleaner.cleanerXDirection, expectedCleanerXDirection, 0);
		assertEquals(testCleaner.cleanerYDirection, expectedCleanerYDirection, 0);
		
	}
	
	@Test
	public void testTrashCollected() 
	{
		// make sure the cleaner is not hitting a trash on initialization
		assertFalse(testCleaner.trashCollected());
	}
	
	
	@Test
	public void testTrashRecycled() {
		// make sure the cleaner is not hitting a recycle bin on initialization
		assertFalse(testCleaner.trashRecycled());
	}
	
	@Test
	public void testCleanerBounds() {
		final int testCleanerSize = 40;
		
		// expected location
		Rectangle expected = new Rectangle(testCleaner.cleanerHeadX, testCleaner.cleanerHeadY, testCleanerSize, testCleanerSize);
		
		// test
		assertEquals(testCleaner.getCleanerBounds(), expected);
	}

	@Test
	public void testIncreaseCleanerLength() {
		// expected value
		int expected = testCleaner.cleanerLength + 1;
		
		testCleaner.increaseCleanerSize();
		
		// test
		assertEquals(testCleaner.cleanerLength, expected);
		
	}
	
	@Test
	public void testDecreaseCleanerLength() {
		testCleaner.increaseCleanerSize(); // increase the size at first, because the size can't be zero
		
		int expected = testCleaner.cleanerLength - 1;
		
		testCleaner.decreaseCleanerSize();
		
		// test
		assertEquals(testCleaner.cleanerLength, expected);
	}
}
