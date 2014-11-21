import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
public class RegistrationPanel extends JPanel
{

	public RegistrationPanel()
	{
		setBackground(new Color(100, 100,100).brighter());
		JPanel registerCenter = new JPanel();
		// panel customization
		registerCenter.setLayout(new FlowLayout());
		registerCenter.setAlignmentX(LEFT_ALIGNMENT);
		registerCenter.setAlignmentY(LEFT_ALIGNMENT);
		registerCenter.setPreferredSize(new Dimension(380,280));
		registerCenter.setBackground(new Color(100, 100,100).brighter());
		registerCenter.setBorder( BorderFactory.createTitledBorder(null, "Registration",0,0,
				new Font ("Tahoma", Font.ITALIC, 18),Color.blue));
		
		
		// create labels for user name and password
		JLabel  firstnameLabel = new JLabel("Frist Name:");
		JLabel  lastnameLabel = new JLabel("Last Name:"	);
		JLabel  dateofbirthLabel = new JLabel("Date of Birth:");
		JLabel usernameLabel = new JLabel("Username:");
		JLabel passwordLabel  = new JLabel("Password:");
		JLabel confirmpasswordLabel = new JLabel("Confirm Password:");
		// customize labels
		firstnameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lastnameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		dateofbirthLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		confirmpasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		firstnameLabel.setPreferredSize(new Dimension(100,30));
		lastnameLabel.setPreferredSize(new Dimension(100,30));
		usernameLabel.setPreferredSize(new Dimension(100,30));
		dateofbirthLabel.setPreferredSize(new Dimension(100,30));
		passwordLabel.setPreferredSize(new Dimension(100,30));
		confirmpasswordLabel.setPreferredSize(new Dimension(120,30));
		
		// create textfield for password and username
		//textfield
		JTextField firstname= new JTextField();
		firstname.setPreferredSize(new Dimension(250,30));
		JTextField lastname= new JTextField();
		lastname.setPreferredSize(new Dimension(250,30));
		JTextField username = new JTextField();
		username.setPreferredSize(new Dimension(250,30));
		JTextField  dateofbirth = new JTextField();
		dateofbirth.setText("mm/dd/yyyy");
		dateofbirth.setPreferredSize(new Dimension(250,30));
		
		JPasswordField password = new JPasswordField();
		password.setPreferredSize(new Dimension(250,30));
		JPasswordField confirmpassword = new JPasswordField();
		confirmpassword.setPreferredSize(new Dimension(230,30));
		
		// create register and cancel buttons
		JButton  registerBtn = new JButton("Register");
		JButton  cancelBtn = new JButton("Clear");
		JButton  backBtn	= new JButton("Back");
		registerBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		registerBtn.setPreferredSize(new Dimension(100,35));
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancelBtn.setPreferredSize(new Dimension(100,35));
		backBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		// add components to panel
		registerCenter.add(firstnameLabel);
		registerCenter.add(firstname);
		registerCenter.add(lastnameLabel);
		registerCenter.add(lastname);
		registerCenter.add(usernameLabel);
		registerCenter.add(username);
		registerCenter.add(dateofbirthLabel);
		registerCenter.add(dateofbirth);
		registerCenter.add(passwordLabel);
		registerCenter.add(password);
		registerCenter.add(confirmpasswordLabel);
		registerCenter.add(confirmpassword);
		
		// button panel 
		JPanel btnPanel = new JPanel();
		btnPanel.setBackground(new Color(100, 100,100).brighter());
		btnPanel.setLayout(new GridLayout(1,3));
		btnPanel.add(registerBtn);
		btnPanel.add(cancelBtn);
		
		
		
		// add to makeReservationPanel
		
		add(backBtn,BorderLayout.NORTH);
		add(registerCenter, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.SOUTH);
		setVisible(true);
		
		
		//TODO: Implements addActionListner for register, and Clear buttons
		
		
		
		
	}
	
	public static void main (String [] args)
	{
		JFrame j = new JFrame();
		j.setSize(420, 480);
		RegistrationPanel n = new RegistrationPanel();
		j.add(n);
		j.setVisible(true);
	}
	
}
