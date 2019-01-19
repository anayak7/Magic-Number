import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class magicNum {
	
	JFrame frame = new JFrame("MagicNum"); //creating a frame object name MagicNum
	JPanel panel = new JPanel(); //creating a panel object to be placed into the frame later
	JTextArea text = new JTextArea(5, 60); //creating new text area object
	JTextField text1 = new JTextField(30); //creating another text area object for inputs
	JButton guess = new JButton("GUESS"); //creating a button meant for guesses and submitting them
	
	int guessNum = -1;
	int num = 0;
	
	//constructor that sets up the gui
	public magicNum()
	{
		//setting frame attributes
		frame.add(panel); //placing the panel inside of the frame
		frame.setVisible(true); //making the frame visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //setting default close behavior to exit the application
		frame.setSize(450, 225); //setting size of frame

		//setting panel attributes
		panel.setBackground(new Color(203, 216, 219)); //setting panel color to a RGB value
		panel.add(text); //placing the text area inside panel
		panel.add(text1); //placing text1 inside of panel
		
		//setting text area attributes
		text.setBackground(Color.WHITE); //setting text area to be black
		text.setFont(new Font("Monaco", Font.BOLD, 12)); //setting font & size
		text.setForeground(new Color(14, 14, 14)); //setting color of text
		text.setPreferredSize(new Dimension(5, 40)); //the amount of text that can fit needs to match the dimensions of text area
		text.setLineWrap(true);
		text.setEditable(false); //this textarea is not editable
		
		text1.setBackground(Color.WHITE); //setting text area to be black
		text1.setFont(new Font("Monaco", Font.BOLD, 12)); //setting font & size
		text1.setForeground(new Color(14, 14, 14)); //setting color of text
		text1.setPreferredSize(new Dimension(3, 30)); //the amount of text that can fit needs to match the dimensions of text area
		//text1.setLineWrap(true);
		
		
		//setting guess button attributes
		guess.setPreferredSize(new Dimension(170, 50));
		guess.setFont(new Font("Monaco", Font.BOLD, 16));
		guess.setForeground(Color.WHITE);
		guess.setBackground( new Color(203, 216, 219));
		guess.setOpaque(false);
		guess.setBorderPainted(false);
		panel.add(guess);
		guess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String input = (text1.getText()); //storing user input
				//System.out.println("input is: "+ input);
				
				if(input.equals("Y") || input.equals("y"))
				{
					start();
					
				} else if (input.equals("N") || input.equals("n"))
				{
					System.exit(0);
					
				} else {
					
					guessNum = Integer.parseInt(input); //parsing string to int					
					
					if(guessNum > 100 || guessNum < 0)
					{
						text.setText("Invalid guess. Please enter another number between 0 and 100");
					}
					else if(guessNum < num)
					{
						System.out.println("in the second else if");
						text.setText("Guess is less than the magic number.");
						
					}
					else if(guessNum > num)
					{
						text.setText("Guess is greater than the magic number.");
						
					} else {
						text.setText("Good job! You guessed the magic number! Do you want to play again? Type Y/N and press guess!");
					}
					
				}
				
			}
			});
		
		start();


	}
	
	//chooses a random number & displays starting message 
	public void start()
	{
		num = (int)(Math.random() *100) + 0; //generating a random num between 0-100
		System.out.println("random number is: " + num);
		
		text.setText("The computer has chosen the magic number! It's between 0 - 100. Enter a number to see if your guess is right.");
		text1.setText("Enter your input here.");
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new magicNum(); //creating a new magicNum instance
		

	}

}
