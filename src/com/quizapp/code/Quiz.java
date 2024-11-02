package com.quizapp.code;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

public class Quiz implements ActionListener{
	String[] questions =  { "Which company created java?",
   						    "Which year was java released?",
						    "What was Java originally called?",
						    "Who owns Java now?"
						  };
	String[][] options ={
						 {"Apple", "Microsoft", "Oracle", "Sun MicroSystems"},
						 {"1975", "1989", "1995", "1972"},
						 {"Apple", "Latte", "Oak", "Koffing"},
						 { "Microsoft", "Oracle","Google", "Sun MicroSystems"}
						};
	
	char[] answers = {'D', 'C', 'C', 'B'};
	int guess;
	int index;
	int correctedGuesses;
	int totalQuestions = questions.length;
	int result;
	int seconds = 10;
	

	JFrame frame = new JFrame();
	JTextField textField = new JTextField();
	JTextArea textArea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JLabel answerLabelA = new JLabel();
	JLabel answerLabelB = new JLabel();
	JLabel answerLabelC = new JLabel();
	JLabel answerLabelD = new JLabel();
	
	JLabel timerLabel = new JLabel();
	JLabel secondsLeft = new JLabel();
	
	JTextField numberRight = new JTextField();
	JTextField percentage = new JTextField();
	
	
	Timer timer = new Timer(1000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			secondsLeft.setText((String.valueOf(seconds)));
			if(seconds <= 0) {
				displayAnswer();
			}
		}
		
	});
	
	public Quiz() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(null);
		frame.setResizable(false);
		
		
		
		textField.setBounds(0, 0, 650, 50);
		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(25, 255, 0));
		textField.setFont(new Font("Ink Free", Font.BOLD, 30));
		textField.setBorder(BorderFactory.createBevelBorder(1));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setDisabledTextColor(new Color(25, 255, 0));
		
		
		textArea.setBounds(0, 50, 650, 50);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(new Color(25, 25, 25));
		textArea.setForeground(new Color(25, 255, 0));
		textArea.setFont(new Font("MV Boli", Font.BOLD, 25));
		textArea.setBorder(BorderFactory.createBevelBorder(1));
		textArea.setEditable(false);
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(new Color(25, 255, 0));
		
		buttonA.setBounds(10, 110, 80, 80);
		buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
//		buttonA.setMargin(new Insets(10, 0, 10, 0));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		
		buttonB.setBounds(10, 210, 80, 80);
		buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(10, 310, 80, 80);
		buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(10, 410, 80, 80);
		buttonD.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		
		answerLabelA.setBounds(125, 100, 500, 100);
		answerLabelA.setBackground(new Color(50, 50, 50));
		answerLabelA.setForeground(new Color(25, 255, 0));
		answerLabelA.setFont(new Font("MV Boli", Font.PLAIN, 35));
		
		answerLabelB.setBounds(125, 200, 500, 100);
		answerLabelB.setBackground(new Color(50, 50, 50));
		answerLabelB.setForeground(new Color(25, 255, 0));
		answerLabelB.setFont(new Font("MV Boli", Font.PLAIN, 35));
		
		
		answerLabelC.setBounds(125, 300, 500, 100);
		answerLabelC.setBackground(new Color(50, 50, 50));
		answerLabelC.setForeground(new Color(25, 255, 0));
		answerLabelC.setFont(new Font("MV Boli", Font.PLAIN, 35));
		
		answerLabelD.setBounds(125, 400, 500, 100);
		answerLabelD.setBackground(new Color(50, 50, 50));
		answerLabelD.setForeground(new Color(25, 255, 0));
		answerLabelD.setFont(new Font("MV Boli", Font.PLAIN, 35));
		
		secondsLeft.setBounds(535, 510, 100, 100);
		secondsLeft.setBackground(new Color(25, 25, 25));
		secondsLeft.setForeground(new Color(255, 0, 0));
		secondsLeft.setFont(new Font("Times New Roman", Font.BOLD, 60));
		secondsLeft.setBorder(new CircularBorder(5));
//		secondsLeft.setOpaque(true);
		secondsLeft.setHorizontalAlignment(JTextField.CENTER);
		secondsLeft.setText(String.valueOf(seconds));
		
		timerLabel.setBounds(535, 475, 100, 25);
		timerLabel.setBackground(new Color(50, 50, 50));
		timerLabel.setForeground(new Color(255, 0, 0));
		timerLabel.setFont(new Font("MV Boli", Font.PLAIN, 16));
		timerLabel.setHorizontalAlignment(JTextField.CENTER);
		timerLabel.setText("TIMER >:D");
		
		
		numberRight.setBounds(225, 225, 200, 100);
		numberRight.setBackground(new Color(25, 25, 25));
		numberRight.setForeground(new Color(25, 255, 0));
		numberRight.setFont(new Font("Ink Free", Font.BOLD, 50));
		numberRight.setBorder(BorderFactory.createBevelBorder(1));
		numberRight.setHorizontalAlignment(JTextField.CENTER);
		numberRight.setEditable(false);
		
		
		percentage.setBounds(225, 325, 200, 100);
		percentage.setBackground(new Color(25, 25, 25));
		percentage.setForeground(new Color(25, 255, 0));
		percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		

		
		frame.add(textField);
		frame.add(textArea);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(answerLabelA);
		frame.add(answerLabelB);
		frame.add(answerLabelC);
		frame.add(answerLabelD);
		frame.add(secondsLeft);
		frame.add(timerLabel);
		
		frame.setVisible(true);
		
		nextQuestion();
	}
	
	public void nextQuestion() {
		if(index >= totalQuestions) {
			results();
		} else {
			textField.setText("Question " + (index + 1));
			textArea.setText(questions[index]);
			answerLabelA.setText(options[index][0]);
			answerLabelB.setText(options[index][1]);
			answerLabelC.setText(options[index][2]);
			answerLabelD.setText(options[index][3]);
			timer.start();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(e.getSource() == buttonA) {
				if(answers[index] == 'A') {
					correctedGuesses++;
				}
		}else if(e.getSource() == buttonB) {
				if(answers[index] == 'B') {
					correctedGuesses++;
				}
		} else if(e.getSource() == buttonC) {
			if(answers[index] == 'C') {
				correctedGuesses++;
			}
		} else if(e.getSource() == buttonD) {
			if(answers[index] == 'D') {
				correctedGuesses++;
			}
		}
		
		displayAnswer();
	}
	
	
	public void displayAnswer() {
		
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(answers[index] != 'A') {
			answerLabelA.setForeground(new Color(255, 0, 0));
		}
		if(answers[index] != 'B') {
			answerLabelB.setForeground(new Color(255, 0, 0));
		}
		if(answers[index] != 'C') {
			answerLabelC.setForeground(new Color(255, 0, 0));
		}
		if(answers[index] != 'D') {
			answerLabelD.setForeground(new Color(255, 0, 0));
		}
		
		// this will be called after validation to pause before moving to the next question
		//set the disabled buttons enabled
		//resets the label color to green
		//increment index and call nextQuestion()
		
		Timer pause = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerLabelA.setForeground(new Color(25, 255, 0));
				answerLabelB.setForeground(new Color(25, 255, 0));
				answerLabelC.setForeground(new Color(25, 255, 0));
				answerLabelD.setForeground(new Color(25, 255, 0));
				

				seconds = 10;
				secondsLeft.setText(String.valueOf(seconds));
				
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;
				nextQuestion();
			}
			
		});
		pause.setRepeats(false);
		pause.start();
	}
	
	
	public void results(){
		frame.remove(answerLabelA);
		frame.remove(answerLabelB);
		frame.remove(answerLabelC);
		frame.remove(answerLabelD);
		frame.remove(buttonA);
		frame.remove(buttonB);
		frame.remove(buttonC);
		frame.remove(buttonD);
		
		
		
		result = (int)(correctedGuesses /(double) totalQuestions * 100);
		textField.setText("RESULTS");
		textArea.setText("");
		
		numberRight.setText(correctedGuesses+ "/" + totalQuestions);
		percentage.setText(result+"%");
		
		secondsLeft.setText("0");
		
		frame.add(numberRight);
		frame.add(percentage);
		
		
		// Refresh frame
//	    frame.revalidate();
	    frame.repaint();
//	    frame.setVisible(true);
	}
	
	
}
class CircularBorder implements Border {
    private int thickness;

    public CircularBorder(int thickness) {
        this.thickness = thickness;
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED); 
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawOval(x + thickness / 2, y + thickness / 2, width - thickness, height - thickness);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness); // Return insets to accommodate the border thickness
    }
}



