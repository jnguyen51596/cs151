import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ReservationMainMenuFrame  extends JFrame 

{
	private Model model;
	private RoomInfoPanel roomInfoPanel;
	private CheckInPanel checkInPanel;
	
	public ReservationMainMenuFrame()
	{
		// create JFrame
		 setTitle("Main Menu");
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setSize(800, 380);
		 model = new Model();

		 //create mainPanel
		 JPanel  mainmenuPanel=new JPanel (); 
		 mainmenuPanel.setLayout(new GridBagLayout());
		 mainmenuPanel.setBackground(new Color(79, 79, 82).brighter());
		 roomInfoPanel = new RoomInfoPanel(model);
		 checkInPanel = new  CheckInPanel (model);
		 
		  // add components to mainmenuPanel
		 GridBagConstraints c = new GridBagConstraints();
		  c.fill = GridBagConstraints.VERTICAL;
		  
		  c.gridx=0;
		  c.gridy =0;
		  c.gridheight=3;
		 mainmenuPanel.add(checkInPanel,c);
		 c.weightx =1;
		 c.weighty = .1;
		 c.gridx=1;
		 c.gridwidth=6;
		 c.gridheight=10;
		 mainmenuPanel.add(roomInfoPanel,c);
		 
		 // add to frame and make frame visible
		 add(mainmenuPanel);
		 setVisible(true);
	}
	
	public static void main(String [ ] args)
	{
		 ReservationMainMenuFrame mf = new ReservationMainMenuFrame();
	}

	
	
}
