
import java.awt.*;
import java.awt.geom.Rectangle2D;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderWidths;

import javax.swing.*;
import javax.swing.border.TitledBorder;
/**
 * This class let the user login to the reservation system.
 * @author Soe Lin Tun
 *
 */
public class MakeReservationPanel extends JPanel
{
	private JPanel loginPanel;

	public MakeReservationPanel()
	{
	
		setPreferredSize(new Dimension(400,280));
		setBackground(new Color(79, 79, 82).brighter());
		setLayout(new BorderLayout());
		
		
		
		// create  Login Panel
		JPanel loginCenter = new JPanel();
		JPanel loginSouth = new JPanel();
		loginCenter.setLayout(new FlowLayout());
		loginCenter.setPreferredSize(new Dimension(300,350));
		loginSouth.setLayout(new FlowLayout());
		loginSouth.setPreferredSize(new Dimension(300,200));
		loginCenter.setBackground(new Color(100, 100,100).brighter());
		loginSouth.setBackground(new Color(100, 100,100).brighter());
		loginSouth.setBorder( BorderFactory.createTitledBorder(null, "If you are a firstime user, please register here",0,0,
				new Font ("Tahoma", Font.ITALIC, 16),Color.blue));
		loginCenter.setBorder( BorderFactory.createTitledBorder(null, "Login",0,0,
				new Font ("Tahoma", Font.ITALIC, 16),Color.blue));
		
		
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
		loginBtn.setFont(new Font("Tahoma", Font.ITALIC, 14));
		loginBtn.setPreferredSize(new Dimension(100,35));
		cancelBtn.setFont(new Font("Tahoma", Font.ITALIC, 14));
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
		loginSouth.add(registerBtn);
		
		// add to makeReservationPanel
		add(loginCenter, BorderLayout.CENTER);
		add(loginSouth, BorderLayout.SOUTH);
		setVisible(true);
		
		
		//TODO: Implements addActionListner for Login and Clear buttons
		
		
		
		
	
	}

	
	
	
	}

