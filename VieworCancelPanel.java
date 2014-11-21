import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;


public class VieworCancelPanel extends JPanel

{
	public VieworCancelPanel()
	{
	
		
		JPanel loginCenter = new JPanel();
	
	loginCenter.setLayout(new FlowLayout());
	loginCenter.setPreferredSize(new Dimension(WelcomeFrame.WIDTH-(WelcomeFrame.WIDTH/100),WelcomeFrame.HEIGHT-(WelcomeFrame.HEIGHT/100)));
	loginCenter.setBackground(new Color(100, 100,100).brighter());
	loginCenter.setBorder( BorderFactory.createTitledBorder(null, "Login",0,0,
			new Font ("Tahoma", Font.ITALIC, 18),Color.blue));
	
	
	// create labels for user name and password
	JLabel usernameLabel = new JLabel("Username:");
	JLabel passwordLabel  = new JLabel("Password:");
	usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

	
	// create textfield for password and username
	JTextField username = new JTextField();
	username.setPreferredSize(new Dimension(300,30));
	JPasswordField password = new JPasswordField();
	password.setPreferredSize(new Dimension(300,30));
	
	// create login and cancel buttons
	JButton  loginBtn = new JButton("Login");
	JButton  cancelBtn = new JButton("Clear");
	loginBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
	loginBtn.setPreferredSize(new Dimension(100,35));
	cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
	cancelBtn.setPreferredSize(new Dimension(100,35));
	JButton  registerBtn = new JButton("Register");
	registerBtn.setPreferredSize(new Dimension(200,40));
	registerBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
	registerBtn.setForeground(Color.black);
	
	
	// add components to panel
	loginCenter.add(usernameLabel);
	loginCenter.add(username);
	loginCenter.add(passwordLabel);
	loginCenter.add(password);
	loginCenter.add(loginBtn);
	loginCenter.add(cancelBtn);
	//loginSouth.add(registrationLabel);
	

	// add to makeReservationPanel
	add(loginCenter, BorderLayout.CENTER);
	setVisible(true);
	
	
	//TODO: Implements addActionListner for Login and Clear buttons
	
	}
	
}
