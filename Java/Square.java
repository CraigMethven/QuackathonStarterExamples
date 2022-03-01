import java.awt.Color;
import javax.swing.*;

public class Square {
	JFrame myScreen;
	JButton myButton;
	int x;
	int y;
	public static int squareSize;
	
	public void init(JFrame tempScreen, int tempX, int tempY) {
		//Set variables
		myScreen = tempScreen;
		x = tempX;
		y = tempY;
		//Initialise button
		myButton = new JButton();
		//Add button to screen
		myScreen.add(myButton);
		//Set size and location of button
		myButton.setBounds(x*(squareSize+1),y*(squareSize+1),squareSize,squareSize);
		//Set colour
		myButton.setBackground(Color.green);
		
		//Add mouse listeners
		myButton.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        hoverIn();
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        hoverOut();
		    }
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        click();
		    }
		});
		
	}
	
	public void hoverIn() {
		myButton.setBackground(Color.blue);
	}
	
	public void hoverOut() {
		myButton.setBackground(Color.orange);
	}
	
	public void click() {
		myButton.setBackground(Color.red);
	}
	
}
