/*
 *  interface for questions
 */

package RootClasses;

public interface QInterface {
	public void displayQuestion();
	public int getPoints();
	public void incrementPoints();
	public void isAnswerCorrect(String userAnswer);
	public void displayFunFact();
}
