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
	public RoomInfoPanel(Model m,final JFrame reservationframe, final JFrame welcomeframe)
	{
		 model =m;
	     
		 this.setLayout(new GridBagLayout());
		 this.setBackground(new Color(79, 79, 82).brighter());
		 this.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		
		 // create test area with scroll bar for room info
		 JTextArea roominfoTextArea = new JTextArea(12,23);
		 JScrollPane  roominfoScrollPane = new JScrollPane(roominfoTextArea);
		 
		 
		 // create  label for panel
		 JLabel titleLabel = new JLabel("     Available Rooms");
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
		 c.fill =  GridBagConstraints.VERTICAL;
		 c.weightx = 1;
		 c.gridy = 0;
		 c.gridx = 0;
		 this.add(titleLabel,c);
		
		 c.weighty = 1;
		 c.gridy = 1;
		 c.gridx =0;
		 c.insets = new Insets(0,2,0,0);
		
		this.add(roominfoScrollPane,c);
		
		c.anchor  = GridBagConstraints.BELOW_BASELINE_TRAILING;
		c.fill =  GridBagConstraints.HORIZONTAL;
		 c.gridy = 5;
		 c.gridx = 1;
		 this.add(confirmBtn, c);
		 
		 c.gridy = 5;
		 c.gridx = 2;
		 this.add(transactionDoneBtn,c);
		 
		 //TODO add ActionListener to Buttons
			
		 // confrimBtn 
			 
		 
		 
		 
		 //transactionDoneBtn
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
