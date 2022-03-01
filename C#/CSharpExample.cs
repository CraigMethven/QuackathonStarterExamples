using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CQuackathonExample
{
    public partial class MyForm : Form
    {
        //My components
        myPanels[,] panels;
        //the x and y of the grid
        int gridSize = 5;
        Label myLabel;

        //Auto generated - runs when form starts
        public MyForm()
        {
            //Here by default - just ignore it
            InitializeComponent();
            //Set screen size
            this.SetBounds(0, 0, 1600,1000);
            //Initialise size of squares on the screen
            myPanels.squareSize = 180;

            //Initialise my array of components
            panels = new myPanels[gridSize,gridSize];
            //Loop through array
            for (int x = 0; x < gridSize; x++)
            {
                for(int y = 0; y < gridSize; y++)
                {
                    //Populate array
                    panels[x, y] = new myPanels();
                    //Initialise the components
                    panels[x, y].init(this, x, y);
                }
            }

            //For the wee label
            myLabel = new Label();
            this.Controls.Add(myLabel);
            myLabel.Text = "Weeeeeeeeeee";
            myLabel.BackColor = Color.Gold;
            myLabel.ForeColor = Color.Red;
            myLabel.Font = new Font("Serif", 24);
            myLabel.SetBounds(this.Width-400, 0, 400, 50);
        }
    }

    public class myPanels
    {
        Panel myPanel;
        Form myScreen;
        int x;
        int y;
        //Static variable to store the size of the component
        public static int squareSize;

        public void init(Form tempForm, int tempX, int tempY)
        {
            //Set variables
            myScreen = tempForm;
            x = tempX;
            y = tempY;
            //Create panel
            myPanel = new Panel();
            myPanel.BackColor = Color.Green;
            //Set size based on x and y
            myPanel.SetBounds((squareSize+1)*x, (squareSize+1)*y, squareSize, squareSize);
            //Add to screen
            myScreen.Controls.Add(myPanel);
            //Add actions
            myPanel.MouseEnter += new EventHandler(enteredMyPanel);
            myPanel.MouseLeave += new EventHandler(leftMyPanel);
            myPanel.Click += new EventHandler(clickedMyPanel);
        }

        private void enteredMyPanel(object sender, EventArgs e)
        {
            myPanel.BackColor = Color.Blue;
        }

        private void leftMyPanel(object sender, EventArgs e)
        {
            myPanel.BackColor = Color.Orange;
        }

        private void clickedMyPanel(object sender, EventArgs e)
        {
            myPanel.BackColor = Color.Red;
        }
    }
}
