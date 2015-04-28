package OtherScreens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MainApplet.AppletMain;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeScreen extends JPanel {
	private AppletMain applet;
	
	// panels and buttons
	private JPanel openQuizButtonPanel;
	private JButton openQuizButton;
	
	// background
	private Image backgroundImageEarth;
	private Image scaledBackgroundImageEarth;
	
	public HomeScreen(AppletMain appletParameter)
	{
		applet = new AppletMain();
		applet = appletParameter;
		
		// create background image
        ImageIcon myBackgroundImageEarth = new ImageIcon(this.getClass().getResource("/leavesBackground.jpg"));
        backgroundImageEarth = myBackgroundImageEarth.getImage();
        scaledBackgroundImageEarth = backgroundImageEarth.getScaledInstance(720, 520, Image.SCALE_FAST);

		setUpScreen();
	}
	
	public void setUpScreen()
	{
		setLayout(new BorderLayout());
		setOpaque(false);
		
		// info about what we'll be doing
		JLabel appInfoLabel = new JLabel("<html><br><I><B>Some Instructions:</I></B><br>-- Here, you'll learn about protecting the earth!<br><br>"
				+ "-- To do so, you'll be given five multiple choice questions to answer<br><br>"
				+ "-- After these five questions, you'll have the opportunity to play an interactive game"
				+ "(which is affected by how well you answer these five questions!)<br><br>"
				+ "-- Upon the game's completion, you'll be given another five multiple choice questions<br><br>"
				+ "-- After these five questions, you'll have another opportunity to play a new interactive"
				+ " game (which is not affected by how well you answer these five questions...you deserve "
				+ "some stress free fun!)<br><br>"
				+ "-- Regardless, answer all questions wisely! And know that recycling benefits both "
				+ "land and sea!<br><br>"
				+ "-- Upon the second game's completion, you will have the opportunity to review your learning with a "
				+ "drag and drop quiz!</html>");
		appInfoLabel.setFont(new Font("Courier", Font.PLAIN, 18));
		appInfoLabel.setForeground(Color.WHITE);
		appInfoLabel.setHorizontalAlignment(JLabel.CENTER);
		
		//  button to progress to game
		openQuizButtonPanel = new JPanel();
		openQuizButtonPanel.setOpaque(false);
		openQuizButtonPanel.setBackground(Color.WHITE);
		openQuizButton = new JButton("Let's Get Going!");
		openQuizButton.setFont(new Font("Courier", Font.PLAIN, 14));
		openQuizButton.addActionListener(new toNextQuestionButtonListener());
		openQuizButtonPanel.add(openQuizButton);
		
		add(appInfoLabel, BorderLayout.PAGE_START);
		add(openQuizButtonPanel, BorderLayout.PAGE_END);
	}
	
	class toNextQuestionButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			applet.homeToQ1();
		}
	}
	
	/*
	 * for background
	 */
	@Override
	protected void paintComponent(Graphics background) 
	{
	    super.paintComponent(background);
	    background.drawImage(scaledBackgroundImageEarth, 0, 0, this);
	}
}
