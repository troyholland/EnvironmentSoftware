package OceanQuestions;



import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import MainApplet.AppletMain;
import RootClasses.QInterface;
import RootClasses.QuestionPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Q10Screen extends JPanel implements QInterface{

	//creates an object of the QuestionPanel class
	private QuestionPanel genericPanel;
	//creates an object of the AppletMain class
	private AppletMain applet;

	//String array holding the question that the user sees and answers
	//format: {question, correct answer, answerA, answerB, answerC};
	String[] question = new String[]{"What ways can you help save our earth?", 
			"B", "A. Take long showers", "B. Recycle newspapers ", "C. Leave the lights on when you are not in the room"};

	//String containing the fun fact that the user will see after
	//they correctly answer the question
	String funFact = "If every American recycled just one-tenth of "
			+ "\ntheir newspapers, we would save about 25,000,000 "
			+ "\ntrees a year!";

	/**
	 * public Q10Screen
	 * Class constructor
	 * @param appletParameter
	 * @param basePanel
	 */
	public Q10Screen(AppletMain appletParameter, QuestionPanel basePanel)
	{
		//set the applet to appletParameter
		applet = appletParameter;
		//set genericPanel to basePanel
		genericPanel = basePanel;

		//set the screen that the user will see
		setUpScreen();
	}

	/**
	 * public void setUpScreen()
	 * sets up the screen that the user will see
	 */
	public void setUpScreen()
	{
		//set the layout to a new BorderLayout
		setLayout(new BorderLayout());

		//display the question
		//--including the multiple choice answer option
		displayQuestion();

		//creates a JButton called submitButton with the phrase
		//"Submit!" on it
		JButton submitButton = new JButton("Submit!");
		//set the font for the JButton
		submitButton.setFont(new Font("Courier", Font.PLAIN, 14));
		//adds an actionListener to the JButton
		submitButton.addActionListener(new toNextQButtonListener());
		//remove everything from the JPanel
		genericPanel.qButtonPanel.removeAll();
		//add the JButton to the panel
		genericPanel.qButtonPanel.add(submitButton);

		//add genericPanel to the screen
		add(genericPanel);
	}

	@Override
	public void isAnswerCorrect(String userAnswer) {
		//String for the possible outcomes due to the 
		//users input
		String correct = "Correct!";
		String incorrect = "Incorrect!";
		String tooManyChars = "You have entered too many characters.\n **Please try again.";
		String notAValidOpt = "You have entered an invalid character.\n **Please choose from A to C.";

		//String containing the correct answers
		String correctAnswer = question[1];
		String correctAnswerLower = "b";

		//case: if the user enters too many characters (answer should only
		//be one char)
		if (userAnswer.length() > 1)
			//show a dialog box with error message
			JOptionPane.showMessageDialog(this, tooManyChars, "INVALID INPUT", JOptionPane.YES_NO_OPTION);
		//case: if the user enters a char that is not a-c
		else if(!userAnswer.equals("A") && !userAnswer.equals("a") && !userAnswer.equals("B") && !userAnswer.equals("b") &&
				!userAnswer.equals("C") && !userAnswer.equals("c"))
			//show a dialog box with error message
			JOptionPane.showMessageDialog(this, notAValidOpt, "INVALID INPUT", JOptionPane.YES_NO_OPTION);
		//case: if the user enters a character a-c
		else
		{
			//case: if the user enters the correct answer
			if(userAnswer.equals(correctAnswer) || userAnswer.equals(correctAnswerLower))
			{
				//show a dialog box telling the user that they are correct
				JOptionPane.showMessageDialog(this, correct, "VALID INPUT", JOptionPane.PLAIN_MESSAGE);
				//display the fun fact
				displayFunFact();

				//move the view to the next question
				applet.q10toGame();
			}
			//case: if the user enters the incorrect answer
			else
			{
				//show a dialog box telling the user that they are incorrect
				JOptionPane.showMessageDialog(this, incorrect, "VALID INPUT", JOptionPane.PLAIN_MESSAGE);
				//increase the amount of points for the game as penalty
				incrementPoints(); // for earth game
			}
		}
	}


	@Override
	public void displayFunFact() 
	{
		//show a message dialogue box with the fun fact
		JOptionPane.showMessageDialog(this, funFact, "FUN FACT", JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * class toNextQButtonListener
	 * nested class containing the action
	 * listener for the JButtons
	 */
	class toNextQButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//get the text from the user input
			String userInput = genericPanel.field.getText();
			//check to see if the input reflects the 
			//correct answer
			isAnswerCorrect(userInput);
		}
	}

	/**
	 * public void displayQuestion()
	 * function to display the questions and 
	 * possible answers for the user to view
	 */
	@Override
	public void displayQuestion() {
		// TODO Auto-generated method stub
		//add the question and possible answers to the JPanel
		genericPanel.questionText.setText(question[0] + "\n" + question[2] + 
				"\n" +  question[3] + "\n" + question[4]);
	}

	// not used in last 5 questions for game
	@Override
	public int getPoints() {
		return 0;
	}

	// not used in last 5 questions for game
	@Override
	public void incrementPoints()
	{

	}

}