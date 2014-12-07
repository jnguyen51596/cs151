import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ManagerLoginFrame extends JFrame

{
	private Model model;
	public ManagerLoginFrame(Model m, final JFrame welcomeframe)
	{
	
		model = m;
		setTitle("Manager");
		setSize(600,400);
		setFont(new Font("Tahoma",Font.BOLD,22));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		final JPanel loginCenter = new JPanel();
		loginCenter.setLayout(new GridBagLayout());
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
		loginBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginBtn.setPreferredSize(new Dimension(100,35));
		
		JButton  cancelBtn = new JButton("Cancel");
		cancelBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancelBtn.setPreferredSize(new Dimension(100,35));
		
		JButton  registerBtn = new JButton("Register");
		registerBtn.setPreferredSize(new Dimension(200,40));
		registerBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		registerBtn.setForeground(Color.black);
	
	
	// add components to panel
	GridBagConstraints c = new GridBagConstraints();
	
	c.fill = GridBagConstraints.HORIZONTAL;
	
	c.gridx = 0;
	c.gridy  =0;
	loginCenter.add(usernameLabel,c);
	
	c.gridx = 1;
	c.gridy  =0;
	loginCenter.add(username,c);
	
	c.gridx = 0;
	c.gridy  =1;
	loginCenter.add(passwordLabel,c);
	
	c.gridx = 1;
	c.gridy  =1;
	loginCenter.add(password,c);
	
	c.gridx = 1;
	c.gridy  =2;
	loginCenter.add(loginBtn,c);
	
	c.gridx = 2;
	c.gridy  = 2;
	loginCenter.add(cancelBtn,c);
	
	

	// add to makeReservationPanel
	add(loginCenter, BorderLayout.CENTER);
	setVisible(true);
	
	
	//TODO: Implements addActionListner for Login and Clear buttons
	 
	//  add action Listener to Login button
loginBtn.addActionListener(new
			 ActionListener ()
	 {
		 public void actionPerformed(ActionEvent event)
		 {
			 
			 welcomeframe.setVisible(false);
			 String name = username.getText();
			 //System.out.println("Manager login Name:"+name);
			 String pass  = new String(password.getPassword());
			 //System.out.println("Manager login Name:"+pass);
			  boolean verify = model.validateManagerLogin(name, pass);
			  if(verify)
			  {
				  ManagerView  managerview = new ManagerView(model);
                                  setVisible(false);
				  managerview.setVisible(true);
			  }
			  else
			  {
				  JOptionPane.showMessageDialog(null,"Invalid Username and Password"," "+"Error",JOptionPane.ERROR_MESSAGE);
			  }
		 }
	 });
	
	// add action to cancel button
		cancelBtn.addActionListener(new
				 ActionListener ()
		 {
			 public void actionPerformed(ActionEvent event)
			 {
				 
				 welcomeframe.setVisible(true);
				 setVisible(false);
			 }
		
		
		});
	
	}
	
	
}