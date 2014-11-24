import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Guest<3.1>
 * This Frame will show after user clicked make a reservation button
 * @author Soe Lin Tun
 *
 */
public class ReservationFrame  extends JFrame 

{
	private Model model;
	private RoomInfoPanel roomInfoPanel;
	private CheckInPanel checkInPanel;
	
	public ReservationFrame(Model m,final JFrame previousframe)
	{
		 model =m;
		// create JFrame
		 setTitle("Reservation System");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(850, 450);
		 setLocation(200, 100);
		 model = new Model();

		 //create mainPanel
		 JPanel  mainmenuPanel=new JPanel (); 
		 mainmenuPanel.setLayout(new GridBagLayout());
		 mainmenuPanel.setBackground(new Color(79, 79, 82).brighter());
		 roomInfoPanel = new RoomInfoPanel(model,this, previousframe);
		 checkInPanel = new  CheckInPanel (model);
		 
		// cancel button which direct back to previous frame
			JButton mainmenuBtn = new JButton(" Main Menu ");
			mainmenuBtn.setPreferredSize(new Dimension(200,40));
			mainmenuBtn.setFont(new Font ("Serif",Font.BOLD, 20));
			mainmenuBtn.setForeground(Color.white);
			mainmenuBtn.setBackground(Color.GRAY);
			mainmenuBtn.setOpaque(true);
			mainmenuBtn.setBorder(BorderFactory.createEmptyBorder());
			
			
			// add action to mainmenu button
			mainmenuBtn.addActionListener(new
					ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					previousframe.setVisible(true);
					setVisible(false);
				}
					
					
			});
			
		 
		  // add components to mainmenuPanel
		 GridBagConstraints c = new GridBagConstraints();
		 c.fill = GridBagConstraints.ABOVE_BASELINE_LEADING;
		  c.insets = new Insets(0,5,5,10);
		  c.gridx=0;
		  c.gridy =1;
		  c.gridheight=2;
		 mainmenuPanel.add(checkInPanel, c);
		  
		 c.weightx =1;
		 c.weighty = 1;
		 c.gridx=1;
		 c.gridy =1;
		 mainmenuPanel.add(roomInfoPanel,c);
		 
		 c.fill = GridBagConstraints.HORIZONTAL;
		 c.gridx = 0;
		 c.gridy = 0;
		 mainmenuPanel.add(mainmenuBtn , c);
		 
		 // add to frame and make frame visible
		 add(mainmenuPanel);
		 setVisible(true);
	}
	
	

	
	
}
