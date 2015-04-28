package OtherScreens;

import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;

import MainApplet.AppletMain;

import javax.swing.*;

public class ReviewScreen extends JPanel {

	private AppletMain applet;
	
    public JTextField answerField1, answerField2, answerField3, answerField4,
    	answerField5, answerField6, answerField7, answerField8, answerField9, 
    	answerField10;
    
    public JList list;
    
    public JLabel qLabel1, qLabel2, qLabel3, qLabel4, qLabel5, qLabel6, qLabel7,
    	qLabel8, qLabel9, qLabel10;
    
    public JPanel topPanel, questionPanel, answerPanel, buttonPanel;
    
    public DefaultListModel listModel;
    
    public Color myOceanColor, myWoodColor, mySandColor, myGrassColor;

    public ReviewScreen(AppletMain appletParameter) {
    	super(new BorderLayout());
    	
    	applet = appletParameter;
    	
        myOceanColor = new Color(0, 191, 255);
        
        setBackground(myOceanColor);
        
        topPanel = new JPanel();
        
        myWoodColor = new Color(139,69,19);
        
        topPanel.setBackground(myWoodColor);
        
        questionPanel = createQuestionSection();
        
        answerPanel = createAnswerSection();  

		buttonPanel = createButtonSection(); 

        listModel = createListModel();
        
        list = new JList(listModel);
        
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        
        list.setVisibleRowCount(1);
        
        list.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        list.setDragEnabled(true);
        
        list.setTransferHandler(new TransferHandler() {

            public boolean importData(TransferHandler.TransferSupport info) {
            	
                JList.DropLocation dl = (JList.DropLocation)info.getDropLocation();
                
                DefaultListModel listModel = (DefaultListModel)list.getModel();
                
                int index = dl.getIndex();
                
                boolean insert = dl.isInsert();
                
                // Get the current string under the drop.
                String value = (String)listModel.getElementAt(index);

                // Get the string that is being dropped.
                Transferable t = info.getTransferable();
                
                return false;
                
            }
            
            public int getSourceActions(JComponent c) {

                return COPY;
                
            }
            
            protected Transferable createTransferable(JComponent c) {
            	
                JList list = (JList)c;
                
                Object[] values = list.getSelectedValues();
        
                StringBuffer buff = new StringBuffer();

                for (int size = 0; size < values.length; size++) {
                	
                    Object val = values[size];
                    
                    buff.append(val == null ? "" : val.toString());
                    
                    if (size != values.length - 1) {
                    	
                        buff.append("\n");
                        
                    }
                    
                }
                
                return new StringSelection(buff.toString());
                
            }
            
        });
        
        list.setDropMode(DropMode.ON_OR_INSERT);
        
        JScrollPane listView = new JScrollPane(list);
        
        listView.setPreferredSize(new Dimension(720, 40));
        
        topPanel.add(listView);
       
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                questionPanel, answerPanel);

        splitPane.setBackground(myGrassColor);
        
        add(splitPane, BorderLayout.CENTER);
        
        add(topPanel, BorderLayout.PAGE_START);
        
        add(buttonPanel, BorderLayout.SOUTH);
        
        validate();
        
        repaint();

        JOptionPane.showMessageDialog(this, "Congratulations!"
				+ "\nYou have learned a lot today."
				+ "\nKnowledge is power. And you are on your"
				+ "\nway to helping to save the world!"
				+ "\nBut before you go, let's see what you've learned.",
    			"Review Opportunity", JOptionPane.PLAIN_MESSAGE);
        
    }

    public JPanel createQuestionSection() {

    	GridLayout questionGrid = new GridLayout(10,1);
        
        JPanel questionPanel = new JPanel();
        
        questionPanel.setLayout(questionGrid);
        
        mySandColor = new Color (222, 184, 135);  
        
        questionPanel.setBackground(mySandColor);
        
        qLabel1 = new JLabel("We'd keep 200 million pounds of plastic out of landfills by recycling");
        
        qLabel1.setFont(new Font("Magneto", Font.BOLD, 12));
        
        questionPanel.add(qLabel1);
        
        qLabel2 = new JLabel("We can save the earth by");
        
        qLabel2.setFont(new Font("Magneto", Font.BOLD, 12));
        
        questionPanel.add(qLabel2);

        qLabel3 = new JLabel("Recycling a ton of paper saves");
        
        qLabel3.setFont(new Font("Magneto", Font.BOLD, 12));
        
        questionPanel.add(qLabel3);
        
        qLabel4 = new JLabel("Each year, Americans use roughly");
        
        qLabel4.setFont(new Font("Magneto", Font.BOLD, 12));
        
        questionPanel.add(qLabel4);
        
        qLabel5 = new JLabel("You can recycle glass");
        
        qLabel5.setFont(new Font("Magneto", Font.BOLD, 12));
        
        questionPanel.add(qLabel5);
        
        qLabel6 = new JLabel("By burning junk mail received by all Americans daily, you could heat");
        
        qLabel6.setFont(new Font("Magneto", Font.BOLD, 12));
        
        questionPanel.add(qLabel6);
        
        qLabel7 = new JLabel("Recycling 10% of newspapers annually would save about");
        
        qLabel7.setFont(new Font("Magneto", Font.BOLD, 12));
        
        questionPanel.add(qLabel7);
        
        qLabel8 = new JLabel("Annually, America produces enough plastic film to");
        
        qLabel8.setFont(new Font("Magneto", Font.BOLD, 12));
        
        questionPanel.add(qLabel8);
        
        qLabel9 = new JLabel("Recycling an aluminum can saves enough energy to run a television for");
        
        qLabel9.setFont(new Font("Magneto", Font.BOLD, 12));
        
        questionPanel.add(qLabel9);

        qLabel10 = new JLabel("Every minute, the world recycles");
        
        qLabel10.setFont(new Font("Magneto", Font.BOLD, 12));
        
        questionPanel.add(qLabel10);

        return questionPanel;
        
    }
    
    public JPanel createAnswerSection() {
    	
    	GridLayout answerGrid = new GridLayout(10,1);
        
        JPanel answerPanel = new JPanel();
        
        answerPanel.setLayout(answerGrid);
        
        myGrassColor = new Color(0, 128, 0);
        
        answerPanel.setBackground(myGrassColor);

        answerField1 = new JTextField(10);
        
        answerField1.setText("");
        
        answerField1.setDragEnabled(true);
        
        answerPanel.add(answerField1);
        
        answerField2 = new JTextField(10);
        
        answerField2.setText("");
        
        answerField2.setDragEnabled(true);
        
        answerPanel.add(answerField2);
        
        answerField3 = new JTextField(10);
        
        answerField3.setText("");
        
        answerField3.setDragEnabled(true);
        
        answerPanel.add(answerField3);
        
        answerField4 = new JTextField(10);
        
        answerField4.setText("");
        
        answerField4.setDragEnabled(true);
        
        answerPanel.add(answerField4);
        
        answerField5 = new JTextField(10);
        
        answerField5.setText("");
        
        answerField5.setDragEnabled(true);
        
        answerPanel.add(answerField5);
        
        answerField6 = new JTextField(10);
        
        answerField6.setText("");
        
        answerField6.setDragEnabled(true);
        
        answerPanel.add(answerField6);
        
        answerField7 = new JTextField(10);
        
        answerField7.setText("");
        
        answerField7.setDragEnabled(true);
        
        answerPanel.add(answerField7);
        
        answerField8 = new JTextField(10);
        
        answerField8.setText("");
        
        answerField8.setDragEnabled(true);
        
        answerPanel.add(answerField8);
        
        answerField9 = new JTextField(10);
        
        answerField9.setText("");
        
        answerField9.setDragEnabled(true);
        
        answerPanel.add(answerField9);
        
        answerField10 = new JTextField(10);
        
        answerField10.setText("");
        
        answerField10.setDragEnabled(true);
        
        answerPanel.add(answerField10);
        
        return answerPanel;
        
    }
    
    public JPanel createButtonSection() {
    	
		buttonPanel = new JPanel();	
		
		buttonPanel.setBackground(myOceanColor);

		JButton checkAnswersButton = new JButton("Check Answers!");
		
		checkAnswersButton.setActionCommand("check answers");
		
		checkAnswersButton.addActionListener(new checkButtonListener());
		
		buttonPanel.add(checkAnswersButton);
		
		JButton returnHomeButton = new JButton("Finish");
		
		returnHomeButton.setActionCommand("finish");
		
		returnHomeButton.addActionListener(new checkButtonListener());
		
		buttonPanel.add(returnHomeButton);
		
		return buttonPanel;
		
    }
    
    public void clearAnswers() {
    	
    	answerField1.setText("");
    	
    	answerField2.setText("");
    	
    	answerField3.setText("");
    	
    	answerField4.setText("");
    	
    	answerField5.setText("");
    	
    	answerField6.setText("");
    	
    	answerField7.setText("");
    	
    	answerField8.setText("");
    	
    	answerField9.setText("");
    	
    	answerField10.setText("");
    	
    }
    
    public void checkAnswers() {
    	
    	int score = 0;

    	if (answerField1.getText().toString().equals("10% of plastic bottles used yearly")) {
    		
    		score++;
    		
    	}
    	
    	if (answerField2.getText().toString().equals("recycling newspapers")) {
    		
    		score++;
    		
    	}
    	
    	if (answerField3.getText().toString().equals("seventeen trees")) {
    		
    		score++;
    		
    	}
    	
    	if (answerField4.getText().toString().equals("2.5 million plastic bottles")) {
    		
    		score++;
    		
    	}
    	
    	if (answerField5.getText().toString().equals("forever")) {
    		
    		score++;
    		
    	}
    	
    	if (answerField6.getText().toString().equals("250,000 homes")) {
    		
    		score++;
    		
    	}
    	
    	if (answerField7.getText().toString().equals("25 million trees")) {
    		
    		score++;
    		
    	}
    	
    	if (answerField8.getText().toString().equals("shrink wrap Texas")) {
    		
    		score++;
    		
    	}
    	
    	if (answerField9.getText().toString().equals("3 hours")) {
    		
    		score++;
    		
    	}
    	
    	if (answerField10.getText().toString().equals("113,200 aluminium cans")) {
    		
    		score++;
    		
    	}
    	
    	if (score == 0) {
    		
	        JOptionPane.showMessageDialog(this, "Oh no!"
					+ "\nYou did not get any questions"
					+ "\ncorrect. Try again and show"
					+ "\nwhat you've learned today!",
	    			"Review Opportunity", JOptionPane.PLAIN_MESSAGE);
	        
    	}
    		
    	else if ((score != 0) && (score < 10)) {
    		
	        JOptionPane.showMessageDialog(this, "Nice work!"
					+ "\nYou sure have learned a lot today."
					+ "\nYou got " + score + " out of 10 questions"
					+ "\ncorrect! Try and beat your score.",
	    			"Review Opportunity", JOptionPane.PLAIN_MESSAGE);
	        
    	}
  
    	else {
    		
	        JOptionPane.showMessageDialog(this, "Fantastic job!"
					+ "\nYou sure have learned a lot today."
					+ "\nYou got " + score + " out of 10 questions"
					+ "\ncorrect! Way to go!",
	    			"Review Opportunity", JOptionPane.PLAIN_MESSAGE);
	        
    	}
    	
    	clearAnswers();
    	
    }
    
    public void finish() {

    	remove(topPanel);
    	
    	remove(buttonPanel);
    	
    	questionPanel.setVisible(false);
    	
    	answerPanel.setVisible(false);
    	
        JOptionPane.showMessageDialog(this, "Now it's up to you"
        		+ "\nto go save the world!",
    			"Time to Act", JOptionPane.PLAIN_MESSAGE);
        
        applet.reviewToPurpose();
        
    }

	class checkButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if ("check answers".equals(e.getActionCommand())){
				
				checkAnswers();
				
			}
			
			if ("finish".equals(e.getActionCommand())){
				
				finish();
				
			}
			
		}
		
	}
    
    public DefaultListModel createListModel() {
    	
    	//Create a list model and a list.
        DefaultListModel listModel = new DefaultListModel();
        
        listModel.addElement("250,000 homes");
        
        listModel.addElement("shrink wrap Texas");
        
        listModel.addElement("seventeen trees");
        
        listModel.addElement("113,200 aluminium cans");
        
        listModel.addElement("25 million trees");
        
        listModel.addElement("forever");
        
        listModel.addElement("recycling newspapers");
        
        listModel.addElement("2.5 million plastic bottles");
        
        listModel.addElement("3 hours");
        
        listModel.addElement("10% of plastic bottles used yearly");
        
        return listModel;
        
    }
    
}