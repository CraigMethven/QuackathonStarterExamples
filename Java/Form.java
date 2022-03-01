import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Form {
	JFrame f;
	Square[][] theSquares;
	int gridSize = 5;
	JLabel myLabel;
	
	public static void main(String[] args) {
		//Run the form
		new Form();
	}
	
	Form(){
		//Initialise the form
		f = new JFrame();
		//Set the size
		f.setSize(1600,1000);
		//Set it so that java doesn't automatically move things for you
		f.setLayout(null);
		//Have it close properly
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Make it appear
		f.setVisible(true);
		
		//Set the square size in the square class
		Square.squareSize = 120;
		//Initialise the square array
		theSquares = new Square[gridSize][gridSize];
		//Loop through each square and set it up
		for(int x = 0; x<gridSize;x++) {
			for(int y = 0;y<gridSize;y++) {
				theSquares[x][y] = new Square();
				theSquares[x][y].init(f, x, y);
			}
		}
		
		//Create the label
		myLabel = new JLabel();
		//Add it to the screen
		f.add(myLabel);
		//Set the text using HTML and CSS
		myLabel.setText("<html><body style = background-color:blue;color:yellow;><h1>Mwahhahahahahah");
		//Set the size
		myLabel.setBounds(f.getWidth()-300,0,300,100);
	}
}
