package UnitTests;

import OtherScreens.ReviewScreen;
import MainApplet.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

// test reviewScreen functionality
public class ReviewScreenTest {

	private ReviewScreen reviewScreen;
	private AppletMain myAppletTest;
	
	//create a ReviewScreen
	@Before
	public void testReviewScreen() {
		myAppletTest = new AppletMain();
		reviewScreen = new ReviewScreen(myAppletTest);
	}
	
	//test ReviewScreen
	@Test
	public void testReviewScreenNotNull() {
		
		assertNotNull(reviewScreen);
	}
	
	//test createListModel()
	@Test
	public void createListModelTest() {
		
		//create DefaultListModel
		reviewScreen.createListModel();
		
		//test if listModel is not null
		assertNotNull(reviewScreen.listModel);
		
	}
	
	//test createQuestionSection()
	@Test
	public void createQuestionSectionTest() {
		
		//string to hold actual text of qLabel1
		String qLabel1Text = new String();
		
		//create question section (and therefore qLabel1)
		reviewScreen.createQuestionSection();
		
		//get text of qLabel1
		qLabel1Text = reviewScreen.qLabel1.getText().toString();
		
		//test if text of qLabel1 is as expected
		assertEquals(qLabel1Text, "We'd keep 200 million pounds of plastic out of landfills by recycling");
	}
	
	//test createAnswerSection()
	@Test
	public void createAnswerSectionTest() {
		
		//string to hold actual text of answerField1
		String answerField1Text = new String();
		
		//create question section (and therefore answerField1)
		reviewScreen.createAnswerSection();
		
		//get text of answerField1
		answerField1Text = reviewScreen.answerField1.getText().toString();
		
		//test if text of answerField1 is as expected
		assertEquals(answerField1Text, "");
		
	}
}
