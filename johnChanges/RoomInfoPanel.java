import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class  is View of the MVC  and 
 * show the room informations
 * @author Soe Lin Tun
 *
 */

public class RoomInfoPanel extends JPanel implements ChangeListener
{
	  private Model model;
	  private PrintReceiptFrame printFrame;
	  
        /**
         * Constructs the GUI for the guest user to see the rooms available
         * @param m the model object
         * @param reservationframe the JFrame object
         * @param welcomeframe the JFrame object
         */
	public RoomInfoPanel(Model m,final JFrame reservationframe, final JFrame welcomeframe)
	{
		 model =m;
	     
		 this.setLayout(new GridBagLayout());
		 this.setBackground(new Color(79, 79, 82).brighter());
		 this.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		 
		 // create  labels for check-in/out
		 JLabel checkinLabel = new JLabel("  Check-in:");
		 JLabel checkoutLabel = new JLabel("  Check-out:");
		 checkinLabel.setForeground(Color.black);
		 checkoutLabel.setForeground(Color.black);
		 checkinLabel.setPreferredSize(new Dimension(110,30));
		 checkoutLabel.setPreferredSize(new Dimension(110,30));
		 checkinLabel.setFont(new Font("Tahoma", Font.BOLD,14));
		 checkoutLabel.setFont(new Font("Tahoma",Font.BOLD,14));
		 
		 // create  text field for check-in/out
		 JTextField checkinTextField = new JTextField("mm/dd/yyyy");
		 JTextField checkoutTextField = new JTextField("mm/dd/yyyy");
		 checkinTextField.setPreferredSize(new Dimension(110,30));
		 checkoutTextField.setPreferredSize(new Dimension(110,30));
		 
		 // create buttons for room type & label
		  JLabel buttonTypeLabel = new JLabel("  Room Type:");
		  buttonTypeLabel.setFont(new Font("Tahoma", Font.BOLD,16));
		  JButton twoHundredBtn = new JButton("$200");
		  JButton  oneHundredBtn = new JButton("$100");
		  twoHundredBtn.setPreferredSize(new Dimension (90,40));
		  twoHundredBtn.setFont(new Font("Tahoma",Font.BOLD,14));
		  oneHundredBtn.setPreferredSize(new Dimension (90,40));
		  oneHundredBtn.setFont(new Font("Tahoma",Font.BOLD,14));
		 
		
		 // create test area with scroll bar for room info
		 JTextArea roominfoTextArea = new JTextArea(12,23);
		 JScrollPane  roominfoScrollPane = new JScrollPane(roominfoTextArea);
		 
		 
		 // create  label for panel
		 JLabel titleLabel = new JLabel("   Available Rooms");
		 titleLabel.setForeground(Color.blue);
		 titleLabel.setAlignmentX(CENTER_ALIGNMENT);
		 titleLabel.setPreferredSize(new Dimension(230,50));
		 titleLabel.setFont(new Font("Tahoma", Font.ITALIC,24));
		 
		// create buttons for confirm and cancel
		 JButton confirmBtn = new JButton("Confirmed");
		 JButton transactionDoneBtn = new JButton("Transaction Done");
		 confirmBtn.setPreferredSize(new Dimension (85,40));
		 confirmBtn.setFont(new Font("Tahoma",Font.BOLD,14));
		 transactionDoneBtn.setPreferredSize(new Dimension (150,40));
		 transactionDoneBtn.setFont(new Font("Tahoma",Font.BOLD,14));
		 
		 // add component to this panel
		  GridBagConstraints c = new GridBagConstraints();
		 
		  c.gridx = 1;
		  c.gridy = 0;
		  this.add(checkinLabel,c);
		
		  c.gridx = 2;
		  c.gridy = 0;
		this.add(checkoutLabel,c);
		
		  c.gridx = 1;
		  c.gridy = 1;
		 this.add(checkinTextField,c);
		 
		  c.gridx = 2;
		  c.gridy = 1;
		 this.add(checkoutTextField,c);
		 
		  c.gridx = 0;
		  c.gridy = 2;
		 this.add(buttonTypeLabel,c);
		 
		  c.gridx = 1;
		  c.gridy = 2;
		 this.add(twoHundredBtn,c);
		 
		  c.gridx = 2;
		  c.gridy = 2;
		 this.add(oneHundredBtn,c);
		 
		 
		 c.gridx = 1;
		 c.gridy = 3;
		 this.add(titleLabel,c);
		
		 c.fill =  GridBagConstraints.HORIZONTAL;
		 c.gridy = 4;
		 c.gridx =0;
		 c.gridwidth = 3;
		
		this.add(roominfoScrollPane,c);
		
		c.anchor  = GridBagConstraints.BELOW_BASELINE_TRAILING;
		
		 c.gridy = 6;
		 c.gridx = 4;
		 this.add(confirmBtn, c);
		 
		 c.insets = new Insets(0,2,0,0);
		 c.gridy = 6;
		 c.gridx = 7;
		 this.add(transactionDoneBtn,c);
		 

		 //TODO add ActionListener to Buttons
			
		 // confrimBtn 
			 
		 
		 
		 
		 //transactionDoneBtn
                 // Redirects the user to the print receipt frame
		 	transactionDoneBtn.addActionListener(new
					ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					printFrame = new PrintReceiptFrame(model,welcomeframe);
					printFrame.setVisible(true);
					reservationframe.setVisible(false);
				
				}
					
					
			});
		 
		 
}

	
    public void stateChanged(ChangeEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

}
