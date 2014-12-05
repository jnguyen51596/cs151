

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
        private final int MAXYEAR = 2000;
        private final int MINYEAR = 1800;
        private GuestList guestList;
        
        /**
         * Constructs the RegistrationPanel, which is the GUI for the Guest user registration
         * @param m The model object
         * @param loginCenter a Jpanel, one of the Login panels
         * @param loginSouth a JPanel, one of the Login panels
         * @param gList a GuestList object, the list of guestlists
         * @param database a Database object, the list of guests from the filed
         */
	public RegistrationPanel(Model m,final JPanel loginCenter, final JPanel loginSouth, GuestList gList, Database database)
	{
		model = m ;
                guestList = gList;
                
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
		final JTextField firstname= new JTextField();
		firstname.setPreferredSize(new Dimension(250,30));
		final JTextField lastname= new JTextField();
		lastname.setPreferredSize(new Dimension(250,30));
		final JTextField username = new JTextField();
		username.setPreferredSize(new Dimension(250,30));
		final JTextField  dateofbirth = new JTextField();
		dateofbirth.setText("mm/dd/yyyy");
		dateofbirth.setPreferredSize(new Dimension(250,30));
		
		final JPasswordField password = new JPasswordField();
		password.setPreferredSize(new Dimension(250,30));
		final JPasswordField confirmpassword = new JPasswordField();
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
                //REGISTER BUTTON
                registerBtn.addActionListener(new
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
                            String tempFN = firstname.getText();
                            String tempLN = lastname.getText();
                            String tempUN = username.getText();
                            String tempDB = dateofbirth.getText();
                            String tempPW = password.getText();
                            String tempCPW = confirmpassword.getText();
                            
                            //If user pass the registerUser validation can be added to the guestList
                            //and go to the UserLoginFrame
                            if(registerUser(tempFN, tempLN, tempUN, tempDB, tempPW, tempCPW)){
                                guestList.addGuest(tempFN, tempLN, tempUN, tempDB, tempPW );
                                popupBox("Registration Completed","Welcome " + tempUN);
                                setVisible(false);
				loginCenter.setVisible(true);
				loginSouth.setVisible(true);
                            }
                            // if there is an error, password and confirm password fields are erased
                            else{
                                password.setText("");
                                confirmpassword.setText("");
                            }
			}				
		});

                // CANCEL BUTTON ACTION
                // clear all the fields
                cancelBtn.addActionListener(new
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
                            firstname.setText("");
                            lastname.setText("");
                            username.setText("");
                            dateofbirth.setText("mm/dd/yyyy");
                            password.setText("");
                            confirmpassword.setText("");
                        }
				
				
		});
                
		// add action for back button
                // Go to the UserLogin frame
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
        
        /**
         * Check if the user is going to be able to register. This method validates 
         * of the information provided by the guest
         * @param firstName a String, with the guest's first name
         * @param LastName a String, with the guest's last name
         * @param username a String, with the guest's username
         * @param date a String, with the guest's birthdate
         * @param password a String, with the guest's password
         * @param password2 a String, with the password confirmation
         * @return true if the user passes all validations,
         *         false if there is an error in the user's information
         */
        public boolean registerUser(String firstName, String LastName, String username, String date, String password, String password2)
        {
            //Check if the firstname only contains letters
            if(!isAlpha(firstName)){
                popupBox("Invalid first name. It should contain only letters", "Error");
                return false;
            }
            
            //Check if the last name only contains letters
            if(!isAlpha(LastName)){
                popupBox("Invalid last name. It should contain only letters", "Error");
                return false;
            }
            
            // Split the birthdate format and check if the birthdate provided is valid
            String delims = "/";
            String[] bdate = date.split(delims);
            if(bdate.length == 3){
                if(!checkDate(bdate[0], bdate[1], bdate[2]))
                    return false;
            }
            else
                return false;
  
            // Check if the password matches the password provided in the confirm password field
            if(!password.equals(password2)){
                popupBox("Password mismatch", "Error");
                return false;
            }
            
            return true;
        }
        
        /**
         * Checks if the string provided contains only letters
         * @param name the string to be checked
         * @return false if the string contains a non-character
         *         true if the string only has letters
         */
        public boolean isAlpha(String name) {
            char[] chars = name.toCharArray();

            for (char c : chars) {
                if(!Character.isLetter(c)) {
                    return false;
                }
            }

            return true;
        }
        
        /**
         * Checks if the month, day and year are valid 
         * @param month an int with the month number
         * @param day an int with the day number
         * @param year an int with the year 
         * @return false if one of the mentioned does not meet the requirements
         *         true if all three numbers are valid
         */
        public boolean checkDate(String month, String day, String year){
            int vday;
            int vmonth;
            int vyear;
            
            //Check day
            if (day.matches("[0-9]+") && day.length() <= 2) {
                vday = Integer.parseInt(day);
                if(vday <= 0 || vday > 31 ){
                    popupBox("Date exceeds the range", "Error");
                    return false;
                }
            }
            else{
                popupBox("Invalid Date","Error");
                return false;
            }
            
            //Check month
            if (month.matches("[0-9]+") && month.length() <= 2) {
                vmonth = Integer.parseInt(month);
                if(vmonth <= 0 || vmonth > 12){
                    popupBox("Month exceeds the range", "Error");
                    return false;
                }
            }
            else{
                popupBox("Invalid Month", "Error");
                return false;
            }
            
            //Check year
            if (year.matches("[0-9]+") && year.length() == 4) {
                vyear = Integer.parseInt(year);
                if(vyear <= MINYEAR || vyear >= MAXYEAR){
                    popupBox("Year exceeds the range", "Error");
                    return false;
                }
                    
            }
            else{
                popupBox("Invalid Year", "Error");
                return false;
            }
            
            return true;   
        }
        
        /**
         * Displays a pop up box with a customized message
         * @param infoMessage a String, the message to be displayed
         * @param titleBar a String, the title that is in the Bar
         */
        public static void popupBox(String infoMessage, String titleBar)
        {
            JOptionPane.showMessageDialog(null, infoMessage, " " + titleBar, JOptionPane.INFORMATION_MESSAGE);
        }
}
	

