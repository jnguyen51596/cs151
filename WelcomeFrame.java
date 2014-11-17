import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javafx.scene.layout.BorderWidths;

import javax.swing.*;

/**
 * This class is to run when application started. Ask user to
 * make reservation, view, or cancel their reservation.
 * @author Soe Lin Tun
 *
 */

public class WelcomeFrame 
{
	// the size of the Welcome Frame
	public static final int WEIDTH = 450;
	public static final int HEIGHT =300;
	
	
	/**
	 * This constructor construct  WelcomeFrame with
	 * two JButtons and JPanel
	 */
	public WelcomeFrame()
	{
		// Create JFrame
		JFrame welcomeFrame = new JFrame();
		welcomeFrame.setTitle("Welcome to JSK Hotel Reservation System");
		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeFrame.setSize(WEIDTH, HEIGHT);
		welcomeFrame.setLayout(new BorderLayout());
		
		// Create JButton for make a reservation
		JButton  makeReservation  = new JButton ("Make a Reservation");
		makeReservation.setBorderPainted(true);
		makeReservation.setBackground(Color.WHITE.darker());
		makeReservation.setForeground(Color.blue.brighter());
		makeReservation.setFont(new Font("Tahoma", Font.ITALIC, 20));
		makeReservation.setPreferredSize(new Dimension(300,60));
		
		// Create JButton for view/cancel a reservation
		JButton   viewOrCancel  = new JButton ("View/Cancel a Reservation");
		viewOrCancel.setBorderPainted(true);
		viewOrCancel.setBackground(new Color(59, 89, 182));
		viewOrCancel.setForeground(Color.blue.brighter());
		viewOrCancel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		viewOrCancel.setPreferredSize(new Dimension(300,60));
		
		//Create  JPanel
		JPanel   welcomePanel = new JPanel();
		welcomePanel.setLayout(new FlowLayout());
		welcomePanel.setBackground(new Color(79, 79, 82).brighter());
		welcomePanel.add(makeReservation);
		welcomePanel.add(viewOrCancel);
		
		
		// Display JFrame
		welcomeFrame.add(welcomePanel,BorderLayout.CENTER);
		welcomeFrame.setVisible(true);
		
		
		//TODO:Need To Add addActionListner  on both JButtons
	}
	
	public static void main(String [] args)
	{
		WelcomeFrame test = new WelcomeFrame();
	}
	

}
