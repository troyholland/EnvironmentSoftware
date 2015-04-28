package RootClasses;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.border.LineBorder;

import java.awt.Graphics;
import java.awt.Image;

public class QuestionPanel extends JPanel
{
	// for inside class use
	private JPanel questionArea;
	private JPanel submitArea;
	
	// for outside class use
	public JTextArea questionText;
	public JPanel qButtonPanel;
	public JTextField field;
	
	public boolean newBackground; // for changing backgrounds
	
	// background
	private Image backgroundImageEarth;
	private Image scaledBackgroundImageEarth;
	private Image backgroundImageWater;
	private Image scaledBackgroundImageWater;
	
	public QuestionPanel()
	{
		newBackground = false;
		
		// create background image
        ImageIcon myBackgroundImageEarth = new ImageIcon(this.getClass().getResource("/leavesBackground.jpg"));
        backgroundImageEarth = myBackgroundImageEarth.getImage();
        scaledBackgroundImageEarth = backgroundImageEarth.getScaledInstance(720, 520, Image.SCALE_FAST);
        
        // create background image
        ImageIcon myBackgroundImageWater = new ImageIcon(this.getClass().getResource("/waterBackground.jpg"));
        backgroundImageWater = myBackgroundImageWater.getImage();
        scaledBackgroundImageWater = backgroundImageWater.getScaledInstance(720, 520, Image.SCALE_FAST);
        
        setUpScreen();
	}
	
	public void setUpScreen()
	{
		setLayout(new BorderLayout());
		
		// title
		JLabel titleSummary = new JLabel("<html><br>Let's See What You Know!</html>");
		titleSummary.setFont(new Font("Courier", Font.PLAIN, 30));
		titleSummary.setForeground(Color.BLACK);
		titleSummary.setHorizontalAlignment(JLabel.CENTER);
		titleSummary.setVerticalAlignment(JLabel.CENTER);
		
		// holds question
		questionArea = new JPanel();
		questionArea.setBackground(Color.WHITE);
		questionArea.setOpaque(false);
		questionArea.setLayout(new BorderLayout());

		// holds submission
		submitArea = new JPanel();
		submitArea.setOpaque(false);

		//  button to submit to next question
		qButtonPanel = new JPanel();
		qButtonPanel.setOpaque(false);

		// display question
		questionText = new JTextArea();
		questionText.setWrapStyleWord(true);
		questionText.setLineWrap(true);
		questionText.setFont(new Font("Courier", Font.BOLD, 18));
		questionText.setEditable(false);
		questionText.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		// where info is input
		field = new JTextField("", 5);
		field.setHorizontalAlignment(JTextField.RIGHT);
		field.setBorder(new LineBorder(Color.BLACK, 2, true));

		// add to layouts
		questionArea.add(titleSummary, BorderLayout.NORTH);
		questionArea.add(questionText, BorderLayout.CENTER);
		submitArea.add(field);
		submitArea.add(qButtonPanel);
	
		add(questionArea, BorderLayout.PAGE_START);
		add(submitArea, BorderLayout.PAGE_END);
	}
	
	// change when we want ocean background
	public void changeBackground()
	{
		if(newBackground == false)
			newBackground = true;
		else if(newBackground == true)
			newBackground = false;
	}
	
	/*
	 * for background
	 */
	@Override
	protected void paintComponent(Graphics background) 
	{
	    super.paintComponent(background);
	    if(newBackground)
	    	background.drawImage(scaledBackgroundImageWater, 0, 0, this);
	    else
	    	background.drawImage(scaledBackgroundImageEarth, 0, 0, this);
	}
}
