package OtherScreens;

import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;

import MainApplet.AppletMain;

import javax.swing.*;

public class ReviewScreen extends JPanel {

	private AppletMain applet;
	
	//TextFields onto which users drag and drop answers
    public JTextField answerField1, answerField2, answerField3, answerField4,
    	answerField5, answerField6, answerField7, answerField8, answerField9, 
    	answerField10;
    
    //draggable list of answers
    public JList list;
    
    //text of questions
    public JLabel qLabel1, qLabel2, qLabel3, qLabel4, qLabel5, qLabel6, qLabel7,
    	qLabel8, qLabel9, qLabel10;
    
    //topPanel contains draggable list of answers (JList)
    //questionPanel contains text of all questions (JLabels)
    //answerPanel contains all answer fields (JTextFields)
    //buttonPanel holds all buttons
    public JPanel topPanel, questionPanel, answerPanel, buttonPanel;
    
    //checkAnswers button checks answers for review quiz
    //returnHomeButton returns user to beginning of applet
	public JButton checkAnswersButton, returnHomeButton; 
	
    //list of answers
    public DefaultListModel listModel;
    
    //customized colors 
    public Color myOceanColor, myWoodColor, mySandColor, myGrassColor;

    //scroll pan to contain list of draggable answers
    public JScrollPane listView;
    
    //used to display questionPanel and answerPanel
    public JSplitPane splitPane;
    
    public ReviewScreen(AppletMain appletParameter) {
    	
    	super(new BorderLayout());
    	
    	applet = appletParameter;
    	
    	//customize colors
    	initColors();
        
        //set color as background of JPanel
        setBackground(myOceanColor);
        
        //create new JPanel to hold list 
        topPanel = new JPanel();
        
        //set color as background of topPanel
        topPanel.setBackground(myWoodColor);
        
        //create new JPanel to hold questions (JLabels)
        questionPanel = createQuestionSection();
        
        //create new JPanel to hold answer fields (JTextFields)
        answerPanel = createAnswerSection();  

        //create new JPanel to hold buttons (JButtons
		buttonPanel = createButtonSection(); 

		//create new DefaultListModel for answers 
        listModel = createListModel();
        
        list = createList(listModel);
        
        //add created items to screen
        addToScreen();
    }
    
    //customize colors
    public void initColors() {
    	
        myOceanColor = new Color(0, 191, 255);
        
        myWoodColor = new Color(139,69,19);
        
        myGrassColor = new Color(0, 128, 0);
        
        mySandColor = new Color (222, 184, 135);  
    	
    }

    //create question section of screen
    public JPanel createQuestionSection() {

    	//create grid layout for questionPanel
    	GridLayout questionGrid = new GridLayout(10,1);
        
    	//create questionPanel to contain questions (JLabels)
        questionPanel = new JPanel();
        
        //set layout of questionPanel to questionGrid
        questionPanel.setLayout(questionGrid);
        
        //set color of questionPanel
        questionPanel.setBackground(mySandColor);
        
        //create JLabels for each question
        createQuestions();
        
        //set font for each question
        setQuestionsFont();
        
        //add questions to questionPanel
        addQuestionsToQuestionPanel();

        return questionPanel;
        
    }
    
    //create JLabels for each question
    public void createQuestions() {
    
        qLabel1 = new JLabel("We'd keep 200 million pounds of plastic out of landfills by recycling");
        
        qLabel2 = new JLabel("We can save the earth by");
        
        qLabel3 = new JLabel("Recycling a ton of paper saves");
        
        qLabel4 = new JLabel("Each year, Americans use roughly");
        
        qLabel5 = new JLabel("You can recycle glass");
        
        qLabel6 = new JLabel("By burning junk mail received by all Americans daily, you could heat");
        
        qLabel7 = new JLabel("Recycling 10% of newspapers annually would save about");
        
        qLabel8 = new JLabel("Annually, America produces enough plastic film to");
        
        qLabel9 = new JLabel("Recycling an aluminum can saves enough energy to run a television for");
        
        qLabel10 = new JLabel("Every minute, the world recycles");
        
    }
    
    //set font for each question
    public void setQuestionsFont() {
        
        qLabel1.setFont(new Font("Magneto", Font.BOLD, 12));
        
        qLabel2.setFont(new Font("Magneto", Font.BOLD, 12));
        
        qLabel3.setFont(new Font("Magneto", Font.BOLD, 12));
        
        qLabel4.setFont(new Font("Magneto", Font.BOLD, 12));
        
        qLabel5.setFont(new Font("Magneto", Font.BOLD, 12));
        
        qLabel6.setFont(new Font("Magneto", Font.BOLD, 12));
        
        qLabel7.setFont(new Font("Magneto", Font.BOLD, 12));
        
        qLabel8.setFont(new Font("Magneto", Font.BOLD, 12));
        
        qLabel9.setFont(new Font("Magneto", Font.BOLD, 12));
        
        qLabel10.setFont(new Font("Magneto", Font.BOLD, 12));
        
    }
    
    //add questions to questionPanel
    public void addQuestionsToQuestionPanel() {
    	
        questionPanel.add(qLabel1);
        
        questionPanel.add(qLabel2);

        questionPanel.add(qLabel3);

        questionPanel.add(qLabel4);
  
        questionPanel.add(qLabel5);
        
        questionPanel.add(qLabel6);
        
        questionPanel.add(qLabel7);
        
        questionPanel.add(qLabel8);
        
        questionPanel.add(qLabel9);

        questionPanel.add(qLabel10);
    	
    }
    
    //create answer section of screen
    public JPanel createAnswerSection() {
    	
        //create grid layout for answerPanel
    	GridLayout answerGrid = new GridLayout(10,1);
        
    	//create answerPanel to contain dragged and dropped answers
        answerPanel = new JPanel();
        
        //set layout of answerPanel to answerGrid
        answerPanel.setLayout(answerGrid);
        
        //set color of answerPanel
        answerPanel.setBackground(myGrassColor);

        //create answer fields
        createAnswerFields();
        
        //set initial text for each answer field
        setAnswerFieldInitialText();
        
        //enable drag for each answer field
        answerFieldEnableDrag();
        
        //add answer fields to answer panel
        addAnswerFieldsToAnswerPanel();
        
        return answerPanel;
        
    }
    
    //create JTextFields for each answer field
    public void createAnswerFields() {
    	
    	answerField1 = new JTextField(10);

    	answerField2 = new JTextField(10);
    	
    	answerField3 = new JTextField(10);
    	
    	answerField4 = new JTextField(10);
    	
    	answerField5 = new JTextField(10);
    	
    	answerField6 = new JTextField(10);
    	
    	answerField7 = new JTextField(10);
    	
    	answerField8 = new JTextField(10);
    	
    	answerField9 = new JTextField(10);
    	
    	answerField10 = new JTextField(10);
    	
    }
    
    //make answer fields blank
    public void setAnswerFieldInitialText() {
    	
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
    
    //enable drag for each answer field
    public void answerFieldEnableDrag() {
    	
    	answerField1.setDragEnabled(true);
    	
    	answerField2.setDragEnabled(true);
    	
    	answerField3.setDragEnabled(true);
    	
    	answerField4.setDragEnabled(true);
    	
    	answerField5.setDragEnabled(true);
    	
    	answerField6.setDragEnabled(true);
    	
    	answerField7.setDragEnabled(true);
    	
    	answerField8.setDragEnabled(true);
    	
    	answerField9.setDragEnabled(true);
    	
    	answerField10.setDragEnabled(true);
    	
    }
    
    //add answer fields to answerPanel
    public void addAnswerFieldsToAnswerPanel() {
    	
    	answerPanel.add(answerField1);
    	
    	answerPanel.add(answerField2);
    	
    	answerPanel.add(answerField3);
    	
    	answerPanel.add(answerField4);
    	
    	answerPanel.add(answerField5);
    	
    	answerPanel.add(answerField6);
    	
    	answerPanel.add(answerField7);
    	
    	answerPanel.add(answerField8);
    	
    	answerPanel.add(answerField9);
    	
    	answerPanel.add(answerField10);
    	
    }

    //create button section of screen
    public JPanel createButtonSection() {
    	
    	//create buttonPanel
		buttonPanel = new JPanel();	
		
		//set background of buttonPanel
		buttonPanel.setBackground(myOceanColor);
	        
		//create buttons
		//checkAnswersButton checks answers to quiz
		checkAnswersButton = new JButton("Check Answers!");
		
		checkAnswersButton.setActionCommand("check answers");
		
		checkAnswersButton.addActionListener(new checkButtonListener());
		
		//returnHomeButton returns user to home screen
		returnHomeButton = new JButton("Finish");
		
		returnHomeButton.setActionCommand("finish");
		
		returnHomeButton.addActionListener(new checkButtonListener());
		
		//add buttons to buttonPanel	
		buttonPanel.add(checkAnswersButton);
	
		buttonPanel.add(returnHomeButton);
		
		//return buttonPanel
		return buttonPanel;
		
    }
    
    public JList createList(DefaultListModel listModel) {
    	
        //create new JList of answers
        list = new JList(listModel);
        
        //set layout so that answers appear one after another at top of screen
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        
        list.setVisibleRowCount(1);
        
        //set so user can only select one answer at a time
        list.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //make the elements of the list dragable
        list.setDragEnabled(true);
        
        //handle drag and drop operation
        list.setTransferHandler(new TransferHandler() {

            public boolean importData(TransferHandler.TransferSupport info) {
            	
                JList.DropLocation dl = (JList.DropLocation)info.getDropLocation();
                
                DefaultListModel listModel = (DefaultListModel)list.getModel();
                
                int index = dl.getIndex();
                
                boolean insert = dl.isInsert();
                
                //get current string under drop
                String value = (String)listModel.getElementAt(index);

                //get string that is being dropped.
                Transferable t = info.getTransferable();
                
                return false;
                
            }
            
            public int getSourceActions(JComponent c) {

                return COPY;
                
            }
            
            protected Transferable createTransferable(JComponent c) {
            	
                JList listTrans = (JList)c;
                
                Object[] values = listTrans.getSelectedValues();
        
                StringBuffer buff = new StringBuffer();

                //get string
                for (int size = 0; size < values.length; size++) {
                	
                    Object val = values[size];
                    
                    buff.append(val == null ? "" : val.toString());
                    
                    if (size != values.length - 1) {
                    	
                        buff.append("\n");
                        
                    }
                    
                }
                
                //return answer being dragged and dropped
                return new StringSelection(buff.toString());
                
            }
            
        });
        
        //set drop mode
        list.setDropMode(DropMode.ON_OR_INSERT);
        
        //return list
        return list;
    	
    }
    
    public void addToScreen() {
    	
        //create new JScrollPane to contain list
        listView = new JScrollPane(list);
        
        //set size of JScollPane
        listView.setPreferredSize(new Dimension(720, 40));
    	
    	//add listView to topPanel
        topPanel.add(listView);
       
        //split questionPanel and answerPanel for display
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                questionPanel, answerPanel);

        //set background of splitPane
        splitPane.setBackground(myGrassColor);
        
        //add splitPane to center of JPanel
        add(splitPane, BorderLayout.CENTER);
        
        //add topPanel to top of JPanel
        add(topPanel, BorderLayout.PAGE_START);
        
        //add buttonPanel to bottom of JPanel
        add(buttonPanel, BorderLayout.SOUTH);
        
        validate();
        
        repaint();
    }
    
    //clear JTextFields for next attempt at quiz
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
    
    //check answers for quiz (launched from checkAnswersButton)
    public void checkAnswers() {
    	
    	int score = 0;

    	//check text in answerField against correct answer for appropriate question
    	if (answerField1.getText().toString().equals("10% of plastic bottles used yearly")) {
    		
    		//if question is answered correctly, increment score
    		score++;
    		
    	}
    	
    	//check text in answerField against correct answer for appropriate question
    	if (answerField2.getText().toString().equals("recycling newspapers")) {
    		
    		//if question is answered correctly, increment score
    		score++;
    		
    	}
    	
    	//check text in answerField against correct answer for appropriate question
    	if (answerField3.getText().toString().equals("seventeen trees")) {
    		
    		//if question is answered correctly, increment score
    		score++;
    		
    	}
    	
    	//check text in answerField against correct answer for appropriate question
    	if (answerField4.getText().toString().equals("2.5 million plastic bottles")) {
    		
    		//if question is answered correctly, increment score
    		score++;
    		
    	}
    	
    	//check text in answerField against correct answer for appropriate question
    	if (answerField5.getText().toString().equals("forever")) {
    		
    		//if question is answered correctly, increment score
    		score++;
    		
    	}
    	
    	//check text in answerField against correct answer for appropriate question
    	if (answerField6.getText().toString().equals("250,000 homes")) {
    		
    		//if question is answered correctly, increment score
    		score++;
    		
    	}
    	
    	//check text in answerField against correct answer for appropriate question
    	if (answerField7.getText().toString().equals("25 million trees")) {
    		
    		//if question is answered correctly, increment score
    		score++;
    		
    	}
    	
    	//check text in answerField against correct answer for appropriate question
    	if (answerField8.getText().toString().equals("shrink wrap Texas")) {
    		
    		//if question is answered correctly, increment score
    		score++;
    		
    	}
    	
    	//check text in answerField against correct answer for appropriate question
    	if (answerField9.getText().toString().equals("3 hours")) {
    		
    		//if question is answered correctly, increment score
    		score++;
    		
    	}
    	
    	//check text in answerField against correct answer for appropriate question
    	if (answerField10.getText().toString().equals("113,200 aluminium cans")) {
    		
    		//if question is answered correctly, increment score
    		score++;
    		
    	}
    	
    	//if score is 0, alert user
    	if (score == 0) {
    		
	        JOptionPane.showMessageDialog(this, "Oh no!"
					+ "\nYou did not get any questions"
					+ "\ncorrect. Try again and show"
					+ "\nwhat you've learned today!",
	    			"Review Opportunity", JOptionPane.PLAIN_MESSAGE);
	        
    	}
    	
    	//if score is greater than 0 and less than 10, alert user
    	else if ((score > 0) && (score < 10)) {
    		
	        JOptionPane.showMessageDialog(this, "Nice work!"
					+ "\nYou sure have learned a lot today."
					+ "\nYou got " + score + " out of 10 questions"
					+ "\ncorrect! Try and beat your score.",
	    			"Review Opportunity", JOptionPane.PLAIN_MESSAGE);
	        
    	}
  
    	//if score is 10 out of 10, alert user
    	else {
    		
	        JOptionPane.showMessageDialog(this, "Fantastic job!"
					+ "\nYou sure have learned a lot today."
					+ "\nYou got " + score + " out of 10 questions"
					+ "\ncorrect! Way to go!",
	    			"Review Opportunity", JOptionPane.PLAIN_MESSAGE);
	        
    	}
    	
    	//clear text in all answer fields
    	clearAnswers();
    	
    }
    
    //finishes quiz and returns user to home screen (launched from returnHomeButton)
    public void finish() {

    	//hide listView
    	listView.setVisible(false);
    	
    	//hide questionPanel
    	questionPanel.setVisible(false);
    	
    	//hide answerPanel
    	answerPanel.setVisible(false);
    	
    	//remove buttonPanel
    	remove(buttonPanel);
    	
    	//display encouraging message to user
        JOptionPane.showMessageDialog(this, "Now it's up to you"
        		+ "\nto go save the world!",
    			"Time to Act", JOptionPane.PLAIN_MESSAGE);
        
        applet.reviewToPurpose();
        
    }

    //handles user clicking buttons
	class checkButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			//if checkAnswersButton is pressed
			if ("check answers".equals(e.getActionCommand())){
				
				//check answers
				checkAnswers();
				
			}
			
			//if returnHomeButton is pressed
			if ("finish".equals(e.getActionCommand())){
				
				//finish quiz 
				finish();
				
			}
			
		}
		
	}
    
	//create list model and list containing answers
    public DefaultListModel createListModel() {
    	
    	//create DefaultListModel
        listModel = new DefaultListModel();
        
        //add elements to listModel (draggable answers)
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
        
        //return listModel
        return listModel;
        
    }
    
}