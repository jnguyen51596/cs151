import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class CheckInPanel extends JPanel  implements ChangeListener
{
	// private Model model;

	public CheckInPanel(Model m)
	{
		
		this.setSize(280, 400);
		 this.setLayout(new GridBagLayout());
		 this.setBackground(new Color(79, 79, 82).brighter());
		 this.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		 
		 // create panel for check in
		 JPanel  checkInPanel = new JPanel();
		 checkInPanel.setLayout(new GridBagLayout());
		 checkInPanel.setBackground(new Color(79, 79, 82).brighter());
		 
		 // create panel for  buttons
		JPanel   checkInBtnPanel =new JPanel();
		checkInBtnPanel.setLayout(new GridLayout(1,3));
		checkInBtnPanel.setBackground(new Color(79, 79, 82).brighter());
		
		 // create  labels for check-in/out
		 JLabel checkinLabel = new JLabel("  Check-in:");
		 JLabel checkoutLabel = new JLabel("  Check-out:");
		 checkinLabel.setForeground(Color.black);
		 checkoutLabel.setForeground(Color.black);
		 checkinLabel.setPreferredSize(new Dimension(90,30));
		 checkoutLabel.setPreferredSize(new Dimension(90,30));
		 checkinLabel.setFont(new Font("Tahoma", Font.BOLD,13));
		 checkoutLabel.setFont(new Font("Tahoma",Font.BOLD,13));
		 
		 // create  text field for check-in/out
		 JTextField checkinTextField = new JTextField();
		 JTextField checkoutTextField = new JTextField();
		 checkinTextField.setPreferredSize(new Dimension(90,30));
		 checkoutTextField.setPreferredSize(new Dimension(90,30));
		 
		 // create buttons for room type & label
		  JLabel buttonTypeLabel = new JLabel("  Room Type:");
		  buttonTypeLabel.setFont(new Font("Tahoma", Font.BOLD,13));
		  JButton twoHundredBtn = new JButton("$200");
		  JButton  oneHundredBtn = new JButton("$100");
		  twoHundredBtn.setPreferredSize(new Dimension (90,40));
		  twoHundredBtn.setFont(new Font("Tahoma",Font.BOLD,14));
		  oneHundredBtn.setPreferredSize(new Dimension (90,40));
		  oneHundredBtn.setFont(new Font("Tahoma",Font.BOLD,14));
		 
		 // add components to checkInPanel
		  GridBagConstraints c = new GridBagConstraints();
		  c.fill = GridBagConstraints.HORIZONTAL;
		  c.weightx = 0.8;
		  c.gridx = 0;
		  c.gridy = 0;
		  checkInPanel.add(checkinLabel,c);
		  c.gridx = 1;
		  c.gridy = 0;
		  checkInPanel.add(checkoutLabel,c);
		  c.gridx = 0;
		  c.gridy = 1;
		  checkInPanel.add(checkinTextField,c);
		  c.gridx = 1;
		  c.gridy = 1;
		  checkInPanel.add(checkoutTextField,c);
		  
		  // add components to checkInBtnPanel
		 checkInBtnPanel.add(buttonTypeLabel);
		 checkInBtnPanel.add(twoHundredBtn);
		 checkInBtnPanel.add(oneHundredBtn);
		 
		 // add two panels to this panel
		 c.gridy =0;
		
		 this.add(checkInPanel,c);
		 c.gridy =1;
          c.insets = new Insets(10,0,0,0);		
		 this.add(checkInBtnPanel,c);
		 this.setVisible(true);
		 
		//TODO add ActionListener to Buttons
			// $200Btn 
			 //$100Btn
		
		
		
		
		
	}

	
	
	
	
	public void stateChanged(ChangeEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
