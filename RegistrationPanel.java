import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Guest<2.2>
 * This Panel show up when user clicked on Registration button
 * @author Soe Lin Tun
 *
 */
public class RegistrationPanel extends JPanel
{
	private Model model;
	public RegistrationPanel(Model m,final JPanel loginCenter, final JPanel loginSouth)
	{
		model = m ;
		setBackground(new Color(100, 100,100).brighter());
		JPanel registerCenter = new JPanel();
		// panel customization
		registerCenter.setLayout(new GridBagLayout());
		registerCenter.setPreferredSize(new Dimension(450,280));
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
		firstnameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lastnameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		dateofbirthLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		registerBtn.setFont(new Font("Serif", Font.BOLD, 15));
		registerBtn.setPreferredSize(new Dimension(100,35));
		cancelBtn.setFont(new Font("Serif", Font.BOLD, 15));
		cancelBtn.setPreferredSize(new Dimension(100,35));
		backBtn.setFont(new Font("Serif", Font.BOLD, 15));
		
		
		
		// add components to panel
		GridBagConstraints c = new GridBagConstraints();
		c.fill  = GridBagConstraints.HORIZONTAL;
	
		c.gridx = 0;
		c.gridy = 0;
		registerCenter.add(firstnameLabel,c);
		
		c.gridx = 1;
		c.gridy = 0;
		registerCenter.add(firstname,c);
		
		c.gridx = 0;
		c.gridy = 1;
		registerCenter.add(lastnameLabel,c);
		
		c.gridx = 1;
		c.gridy = 1;
		registerCenter.add(lastname,c);
		
		c.gridx = 0;
		c.gridy = 2;
		registerCenter.add(usernameLabel,c);
		
		c.gridx = 1;
		c.gridy = 2;
		registerCenter.add(username,c);
		
		c.gridx = 0;
		c.gridy = 3;
		registerCenter.add(dateofbirthLabel,c);
		
		c.gridx = 1;
		c.gridy = 3;
		registerCenter.add(dateofbirth,c);
		
		c.gridx = 0;
		c.gridy = 4;
		registerCenter.add(passwordLabel,c);
		
		c.gridx = 1;
		c.gridy = 4;
		registerCenter.add(password,c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridheight = 2;
		registerCenter.add(confirmpasswordLabel,c);
		
		c.gridx = 1;
		c.gridy = 5;
		registerCenter.add(confirmpassword,c);
		
		
		// button panel 
		JPanel btnPanel = new JPanel();
		btnPanel.setBackground(new Color(100, 100,100).brighter());
		btnPanel.setLayout(new GridLayout(1,3));
		btnPanel.add(registerBtn);
		btnPanel.add(cancelBtn);
		btnPanel.add(backBtn);
		
		
		// add to makeReservationPanel
		
		
		add(registerCenter, BorderLayout.CENTER);
		add(btnPanel, BorderLayout.SOUTH);
		setVisible(true);
		
		
		//TODO: Implements addActionListner for register, and Clear buttons
		
		
		// add action for back button
		backBtn.addActionListener(new
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				setVisible(false);
				loginCenter.setVisible(true);
				loginSouth.setVisible(true);
				//System.out.println(getParent().getParent().getParent().getParent().getParent().getParent());
			}
				
				
		});
		
		
	}
	
	
	
}
