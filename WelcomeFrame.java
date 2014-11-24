import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.layout.BorderWidths;

import javax.swing.*;

/**
 * This class is to run when application started. Ask user to
 * make reservation, view, or cancel their reservation.
 * @author Soe Lin Tun
 *
 */

public class WelcomeFrame extends JFrame
{
	// the size of the Welcome Frame
	public static final int WIDTH = 500;
	public static final int HEIGHT =400;
	private Model model;
	private UserLoginFrame userLoginFrame ;
	private  ManagerLoginFrame  managerLoginFrame;
	/**
	 * This constructor construct  WelcomeFrame with
	 * two JButtons and JPanel
	 */
	public WelcomeFrame()
	{
		model = new Model();
		
		
		
		// Create JFrame
		setTitle("Welcome to JSK Hotel Reservation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		setLocation(100, 0);
		final JFrame welcomeframe = this;
	
	
		
		// create panel to hold components
		final JPanel mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setBackground(new Color(79,79,82).brighter());
		// create buttons for user to choose manager or user
		JButton userBtn  = new JButton("Guest");
		JButton managerBtn = new JButton("Manager");
		userBtn.setPreferredSize(new Dimension (150,50));
		userBtn.setFont(new Font ("Serif",Font.ITALIC, 28));
		userBtn.setForeground(Color.black);
		managerBtn.setPreferredSize(new Dimension (150,50));
		managerBtn.setFont(new Font ("Serif",Font.ITALIC, 28));
		managerBtn.setForeground(Color.black);
		
		// add buttons to btnPanel
		final JPanel btnPanel = new JPanel(new GridLayout(1,2,10,10));
		btnPanel.setBackground(new Color(79,79,82).brighter());
		btnPanel.add(userBtn);
		btnPanel.add(managerBtn);
		
		
		// add btnPanel to mainPanel
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		mainPanel.add(btnPanel, c);
		
		
		add(mainPanel);
		setVisible(true);
				
		// add action for user button
		 userBtn.addActionListener(new
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				userLoginFrame = new UserLoginFrame(model, welcomeframe); // pass the model and frame
				userLoginFrame.setVisible(true);
				setVisible(false);
			
			}
				
				
		});
		
		//  add action for manager login button
		 managerBtn.addActionListener(new
					ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					managerLoginFrame = new ManagerLoginFrame(model,welcomeframe ); // pass the model and frame
					managerLoginFrame.setVisible(true);
					setVisible(false);
				
				}
					
					
			});
		
		
}

	public static void main(String [] args)
	{
		WelcomeFrame test = new WelcomeFrame();
	}
	

}
