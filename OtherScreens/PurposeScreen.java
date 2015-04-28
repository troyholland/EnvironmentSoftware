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

public class PurposeScreen extends JPanel{
	private AppletMain applet;

	// panels and buttons
	private JPanel openHomeButtonPanel;
	private JButton openHomeButton;
	
	// background
	private Image backgroundImageEarth;
	private Image scaledBackgroundImageEarth;

	public PurposeScreen(AppletMain appletParameter)
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
		// screen layout
		setLayout(new BorderLayout());
		setOpaque(false);

		// title
		JLabel titleLabel = new JLabel("<html><br><br>Protecting the World around Us</html>");
		titleLabel.setFont(new Font("Papyrus", Font.BOLD, 44));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		// intro info
		JLabel purposeLabel = new JLabel("<html>-- Let's learn about how <B>you</B> can protect<br>the earth!<br><br>"
				+ "-- How do our actions affect the Earth?<br><br>"
				+ "-- Can we do anything to fight the consequences <br>of pollution?<br><br>"
				+ "-- How important is <B>recycling</B> to our earth and its oceans?</html>");
		purposeLabel.setFont(new Font("Courier", Font.PLAIN, 20));
		purposeLabel.setForeground(Color.WHITE);
		purposeLabel.setHorizontalAlignment(JLabel.CENTER);

		//  button to progress to game
		openHomeButtonPanel = new JPanel();
		openHomeButtonPanel.setOpaque(false);
		openHomeButton = new JButton("What're We Doing Then?");
		openHomeButton.setFont(new Font("Courier", Font.PLAIN, 14));
		openHomeButton.setBackground(Color.BLACK);
		openHomeButton.addActionListener(new toHomeButtonListener());
		openHomeButtonPanel.add(openHomeButton);

		// add to screen
		add(titleLabel, BorderLayout.PAGE_START);
		add(purposeLabel, BorderLayout.CENTER);
		add(openHomeButtonPanel, BorderLayout.PAGE_END);
	}
	
	class toHomeButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			applet.purposeToHome();
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