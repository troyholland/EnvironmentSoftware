//
// Project 4
// Name: Alex, Jill, Nik, Troy
// E-mail: akm77@georgetown.edu, jas502@georgetown.edu, tgh9@georgetown.edu
// Instructor: Singh
// COSC 150
//
// In accordance with the class policies and Georgetown's Honor Code,
// I certify that, with the exceptions of the lecture notes and those
// items noted below, I have neither given nor received any assistance
// on this project.
//
// Description: JApplet for educational environmental game. It allows users to answer questions
// and play games after answering questions. At the end, users can quiz themselves
// on what they have learned and try to beat their high score.
//

package MainApplet;

import javax.swing.JApplet;
import javax.swing.SwingUtilities;

import EarthQuestions.*;
import OceanQuestions.*;
import GameClasses.Game;
import OtherScreens.*;
import RootClasses.QuestionPanel;

public class AppletMain extends JApplet {
	// applet dimensions
	private static final int frameWidth = 720;
	private static final int frameHeight = 520;

	// game
	private Game newGame;

	private AppletMain myApplet;

	// opening screens
	private HomeScreen newHome;
	private PurposeScreen newPurpose;
	
	// broad question panel
	private QuestionPanel genericQPanel;
	
	// questions
	private Q1Screen newQ1;
	private Q2Screen newQ2;
	private Q3Screen newQ3;
	private Q4Screen newQ4;
	private Q5Screen newQ5;
	private Q6Screen newQ6;
	private Q7Screen newQ7;
	private Q8Screen newQ8;
	private Q9Screen newQ9;
	private Q10Screen newQ10;
	
	// review screen
	private ReviewScreen newReview;
		
	// each function moves to a different view
	public void purposeToHome() {
		// remove old view
		remove(newPurpose);

		// create and add new view
		newHome = new HomeScreen(myApplet);
		add(newHome);

		// update screen
		validate();
		repaint();

	}
	
	public void homeToQ1() {
		remove(newHome);
		
		newQ1 = new Q1Screen(myApplet, genericQPanel);
		add(newQ1);
		
		validate();
		repaint();
		
	}
	
	public void q1toq2() {
		int points = newQ1.getPoints(); // points that are passed to first game
		
		remove(newQ1);
		newQ1.remove(genericQPanel);
		
		newQ2 = new Q2Screen(myApplet, points, genericQPanel);
		add(newQ2);
		
		validate();
		repaint();
		
		
	}
	
	public void q2toq3() {
		
		int points = newQ2.getPoints();
		
		remove(newQ2);
		newQ2.remove(genericQPanel);
		
		newQ3 = new Q3Screen(myApplet, points, genericQPanel);
		add(newQ3);
		
		validate();
		repaint();
		
	}
	
	public void q3toq4() {
		
		int points = newQ3.getPoints();
		
		remove(newQ3);
		newQ3.remove(genericQPanel);
		
		newQ4 = new Q4Screen(myApplet, points, genericQPanel);
		
		add(newQ4);
		
		validate();
		repaint();
		
	}
	
	public void q4toq5() {
		
		int points = newQ4.getPoints();
		
		remove(newQ4);
		newQ4.remove(genericQPanel);
		
		newQ5 = new Q5Screen(myApplet, points, genericQPanel);
		
		add(newQ5);
		
		validate();
		repaint();
		
	}
	
	public void q5toGame() {
		// final points based on number of incorrect answers in previous 5 Qs
		int intToPassToGame = newQ5.getPoints();
		
		remove(newQ5);
		newQ5.remove(genericQPanel);
		
		newGame = new Game(intToPassToGame, myApplet);

		add(newGame);

		validate();
		repaint();
		
	}

	

	public void gameToq6() {
		remove(newGame);

		genericQPanel.changeBackground();
		newQ6 = new Q6Screen(myApplet, genericQPanel);
		add(newQ6);

		validate();
		repaint();

	}
	
	public void q6toq7() {
		remove(newQ6);
		newQ6.remove(genericQPanel);
		
		newQ7 = new Q7Screen(myApplet, genericQPanel);
		add(newQ7);
		
		validate();
		repaint();
		
	}
	
	public void q7toq8() {
		remove(newQ7);
		newQ7.remove(genericQPanel);
		
		newQ8 = new Q8Screen(myApplet, genericQPanel);
		add(newQ8);
		
		validate();
		repaint();
		
	}
	
	public void q8toq9() {
		remove(newQ8);
		newQ8.remove(genericQPanel);
		
		newQ9 = new Q9Screen(myApplet, genericQPanel);
		add(newQ9);
		
		validate();
		repaint();
		
	}
	
	public void q9toq10() {
		remove(newQ9);
		newQ9.remove(genericQPanel);
		
		newQ10 = new Q10Screen(myApplet, genericQPanel);
		add(newQ10);
		
		validate();
		repaint();
		
	}
	
	
	public void q10toGame() {
		remove(newQ10);
		newQ10.remove(genericQPanel);

		add(newGame);

		validate();
		repaint();
		
	}
	
	public void gameToReview() {
		remove(newGame);
		
		newReview = new ReviewScreen(this);
		
		add(newReview);
		
		validate();
		repaint();
	}
	
	public void reviewToPurpose(){
		remove(newReview);
		
		add(newPurpose);
		
		validate();
		repaint();
	}
	

	// executed upon creation
	public void init() {
		myApplet = this;
		
		// set up JApplet
		setSize(frameWidth, frameHeight);
		setVisible(true);

		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					// create initial panels to 'start' application
					genericQPanel = new QuestionPanel();
					newPurpose = new PurposeScreen(myApplet);

					add(newPurpose);
					
					validate();
					repaint();
				}

			});
		} catch (Exception e) {
			System.err.println("error");
		}

	}
}
