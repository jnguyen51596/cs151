

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;


import javax.swing.*;
import javax.swing.border.TitledBorder;
/**
 * Guest<1>
 * This class must show after user selected guest option in WelcomeFrame
 * This class let the user login to the reservation system.
 * @author Soe Lin Tun
 *
 */
public class UserLoginFrame extends JFrame
{
	 private Model model;
	 private UserWelcomePanel userWelcome;
         private GuestList guestList;
                 
	public UserLoginFrame(Model m,final JFrame welcomeframe, GuestList gList)
	{
		model =m;
                guestList = gList;
                
	    setTitle("Guest");
		setSize(new Dimension(500,400));
		setBackground(new Color(79, 79, 82).brighter());
		setLayout(new BorderLayout());
		setFont(new Font("Tahoma",Font.BOLD, 22));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JFrame uloginframe = this;

		
		// create  Login Panel
		final JPanel loginCenter = new JPanel();
		final JPanel loginSouth = new JPanel();
		loginCenter.setLayout(new GridBagLayout());
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
		final JTextField username = new JTextField();
		username.setPreferredSize(new Dimension(300,30));
		final JPasswordField password = new JPasswordField();
		password.setPreferredSize(new Dimension(300,30));
		
		// create login and cancel buttons
		JButton  loginBtn = new JButton("Login");
		JButton  cancelBtn = new JButton("Cancel");
		loginBtn.setFont(new Font("Serif", Font.BOLD, 16));
		loginBtn.setPreferredSize(new Dimension(100,35));
		cancelBtn.setFont(new Font("Serif", Font.BOLD, 16));
		cancelBtn.setPreferredSize(new Dimension(100,35));
		JButton  registerBtn = new JButton("Register");
		registerBtn.setPreferredSize(new Dimension(200,40));
		registerBtn.setFont(new Font("Serif", Font.BOLD, 16));
		registerBtn.setForeground(Color.black);
		
		
		// add components to panel
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 1;
		c.gridy = 0;
		loginCenter.add(usernameLabel,c);
		
		c.gridx = 2;
		c.gridy =0;
		c.gridwidth =3;
		loginCenter.add(username,c);
		
		c.gridx = 1;
		c.gridy =1;
		c.gridwidth =1;
		loginCenter.add(passwordLabel,c);
		
		c.gridx = 2;
		c.gridy =1;
		c.gridwidth =3;
		loginCenter.add(password,c);
		
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth= 2;
		loginCenter.add(loginBtn,c);
		
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 2;
		loginCenter.add(cancelBtn,c);
		
		
		//loginSouth.add(registrationLabel);
		loginSouth.add(registerBtn);
		
		// add to makeReservationPanel
		add(loginCenter, BorderLayout.CENTER);
		add(loginSouth, BorderLayout.SOUTH);
		setVisible(true);
		
		
		//TODO: Implements addActionListner for Login and Clear buttons
		
		registerBtn.addActionListener(new
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				loginCenter.setVisible(false);
				loginSouth.setVisible(false);
				RegistrationPanel registerPanel = new RegistrationPanel(model,loginCenter,loginSouth, guestList);
				add(registerPanel, BorderLayout.CENTER);
				
			    
			}
		});
		
		loginBtn.addActionListener(new
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
                            int i = 0;
                            i = guestList.authenticate(username.getText(), password.getText());
                            
                            if( i == 1){
				userWelcome = new UserWelcomePanel(model, uloginframe);
				loginCenter.setVisible(false);
				loginSouth.setVisible(false);
				add(userWelcome, BorderLayout.CENTER);
                            }
                            else if(i == 0){
                                popupBox("Incorrect Password", "Error");
                            }
                            else
                                popupBox("User does not exists", "Error");
			    
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
        
        
        public static void popupBox(String infoMessage, String titleBar)
        {
            JOptionPane.showMessageDialog(null, infoMessage, " " + titleBar, JOptionPane.INFORMATION_MESSAGE);
        }

        
	
	
	}

