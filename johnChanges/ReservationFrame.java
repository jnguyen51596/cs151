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
 */
public class ReservationFrame  extends JFrame 

{
	private Model model;
	private RoomInfoPanel roomInfoPanel;
	private CheckInPanel checkInPanel;
	
        /**
         * Constructs a ReservationFrame panel , which is the GUI for the reservations 
         * @param m the model object
         * @param previousframe a JFrame object
         */
	public ReservationFrame(Model m,final JFrame previousframe)
	{
		 model =m;
		// create JFrame
		 setTitle("Reservation System");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(750, 550);
		 setLocation(200, 100);
		 model = new Model();

		 //create mainPanel
		 JPanel  mainmenuPanel=new JPanel (); 
		 mainmenuPanel.setLayout(new BorderLayout());
		 mainmenuPanel.setBackground(new Color(79, 79, 82).brighter());
		 roomInfoPanel = new RoomInfoPanel(model,this, previousframe);
		 checkInPanel = new  CheckInPanel (model);
		 
		// cancel button which direct back to previous frame
		 	JPanel btnPanel = new JPanel();
		 	btnPanel.setLayout(new GridBagLayout());
			JButton mainmenuBtn = new JButton(" Main Menu ");
			mainmenuBtn.setPreferredSize(new Dimension(200,40));
			mainmenuBtn.setFont(new Font ("Serif",Font.BOLD, 20));
			mainmenuBtn.setForeground(Color.white);
			mainmenuBtn.setBackground(Color.GRAY);
			mainmenuBtn.setOpaque(true);
			mainmenuBtn.setBorder(BorderFactory.createEmptyBorder());
			GridBagConstraints c = new GridBagConstraints();
			c.gridx =1;
			c.gridy =0;
			btnPanel.add(mainmenuBtn,c);
			
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
			

		 mainmenuPanel.add(btnPanel,BorderLayout.NORTH);
		 mainmenuPanel.add(roomInfoPanel,BorderLayout.CENTER);
		 

		 // add to frame and make frame visible
		 add(mainmenuPanel);
		 setVisible(true);
	}
	
	

	
	
}
