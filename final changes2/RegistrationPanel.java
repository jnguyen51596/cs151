import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.*;

/**
 * Guest<2.2>
 * This Panel show up when user clicked on Registration button
 *
 * @author SJK
 * @version 1.0
 */
public class RegistrationPanel extends JPanel {

    private Model model;
    private final int MAXYEAR = 2000;
    private final int MINYEAR = 1800;
    private GuestList guestList;

    /**
     * Construct the registration panel.
     *
     * @param m the model
     * @param loginCenter the login panel
     * @param loginSouth the login panel
     * @param gList the guestlist
     * @param database the database
     */
    public RegistrationPanel(Model m, final JPanel loginCenter, final JPanel loginSouth, GuestList gList, Database database) {
        model = m;
        guestList = gList;

        setBackground(new Color(100, 100, 100).brighter());
        JPanel registerCenter = new JPanel();
        // panel customization
        registerCenter.setLayout(new GridBagLayout());
        registerCenter.setPreferredSize(new Dimension(450, 280));
        registerCenter.setBackground(new Color(100, 100, 100).brighter());
        registerCenter.setBorder(BorderFactory.createTitledBorder(null, "Registration", 0, 0,
                new Font("Tahoma", Font.ITALIC, 18), Color.blue));

        // create labels for user name and password
        JLabel firstnameLabel = new JLabel("Frist Name:");
        JLabel lastnameLabel = new JLabel("Last Name:");
        JLabel dateofbirthLabel = new JLabel("Date of Birth:");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel confirmpasswordLabel = new JLabel("Confirm Password:");
        // customize labels
        firstnameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lastnameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        dateofbirthLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        confirmpasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        firstnameLabel.setPreferredSize(new Dimension(100, 30));
        lastnameLabel.setPreferredSize(new Dimension(100, 30));
        usernameLabel.setPreferredSize(new Dimension(100, 30));
        dateofbirthLabel.setPreferredSize(new Dimension(100, 30));
        passwordLabel.setPreferredSize(new Dimension(100, 30));
        confirmpasswordLabel.setPreferredSize(new Dimension(120, 30));

        // create textfield for password and username
        //textfield
        final JTextField firstname = new JTextField();
        firstname.setPreferredSize(new Dimension(250, 30));
        final JTextField lastname = new JTextField();
        lastname.setPreferredSize(new Dimension(250, 30));
        final JTextField username = new JTextField();
        username.setPreferredSize(new Dimension(250, 30));
        final JTextField dateofbirth = new JTextField();
        dateofbirth.setText("mm/dd/yyyy");
        dateofbirth.setPreferredSize(new Dimension(250, 30));

        final JPasswordField password = new JPasswordField();
        password.setPreferredSize(new Dimension(250, 30));
        final JPasswordField confirmpassword = new JPasswordField();
        confirmpassword.setPreferredSize(new Dimension(230, 30));

        // create register and cancel buttons
        JButton registerBtn = new JButton("Register");
        JButton cancelBtn = new JButton("Clear");
        JButton backBtn = new JButton("Back");
        registerBtn.setFont(new Font("Serif", Font.BOLD, 15));
        registerBtn.setPreferredSize(new Dimension(100, 35));
        cancelBtn.setFont(new Font("Serif", Font.BOLD, 15));
        cancelBtn.setPreferredSize(new Dimension(100, 35));
        backBtn.setFont(new Font("Serif", Font.BOLD, 15));

        // add components to panel
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        registerCenter.add(firstnameLabel, c);

        c.gridx = 1;
        c.gridy = 0;
        registerCenter.add(firstname, c);

        c.gridx = 0;
        c.gridy = 1;
        registerCenter.add(lastnameLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        registerCenter.add(lastname, c);

        c.gridx = 0;
        c.gridy = 2;
        registerCenter.add(usernameLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        registerCenter.add(username, c);

        c.gridx = 0;
        c.gridy = 3;
        registerCenter.add(dateofbirthLabel, c);

        c.gridx = 1;
        c.gridy = 3;
        registerCenter.add(dateofbirth, c);

        c.gridx = 0;
        c.gridy = 4;
        registerCenter.add(passwordLabel, c);

        c.gridx = 1;
        c.gridy = 4;
        registerCenter.add(password, c);

        c.gridx = 0;
        c.gridy = 5;
        c.gridheight = 2;
        registerCenter.add(confirmpasswordLabel, c);

        c.gridx = 1;
        c.gridy = 5;
        registerCenter.add(confirmpassword, c);

        // button panel 
        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(new Color(100, 100, 100).brighter());
        btnPanel.setLayout(new GridLayout(1, 3));
        btnPanel.add(registerBtn);
        btnPanel.add(cancelBtn);
        btnPanel.add(backBtn);

        // add to makeReservationPanel
        add(registerCenter, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
        setVisible(true);

        //TODO: Implements addActionListner for register, and Clear buttons
        //REGISTER BUTTON
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String tempFN = firstname.getText();
                String tempLN = lastname.getText();
                String tempUN = username.getText();
                String tempDB = dateofbirth.getText();
                String tempPW = password.getText();
                String tempCPW = confirmpassword.getText();

                //If user pass the registerUser validation can be added to the guestList
                //and go to the UserLoginFrame
                if (registerUser(tempFN, tempLN, tempUN, tempDB, tempPW, tempCPW)) {
                    try {
                        guestList.addGuest(tempFN, tempLN, tempUN, tempDB, tempPW, model);
                    } catch (FileNotFoundException e) {

                    }

                    popupBox("Registration Completed", "Welcome " + tempUN);
                    setVisible(false);
                    loginCenter.setVisible(true);
                    loginSouth.setVisible(true);
                } else {
                    password.setText("");
                    confirmpassword.setText("");
                }
            }
        });

        // CANCEL BUTTON ACTION
        // clear all the fields
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
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
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
                loginCenter.setVisible(true);
                loginSouth.setVisible(true);
                //System.out.println(getParent().getParent().getParent().getParent().getParent().getParent());
            }

        });

    }

    /**
     * Register the user and get the validation.
     *
     * @param firstName the firstname
     * @param LastName the lastname
     * @param username the username
     * @param date the birth date
     * @param password the password
     * @param password2 the second password
     * @return true if the user is registered else false
     */
    public boolean registerUser(String firstName, String LastName, String username, String date, String password, String password2) {

        if (!isAlpha(firstName)) {
            popupBox("Invalid first name. It should contain only letters", "Error");
            return false;
        }

        if (!isAlpha(LastName)) {
            popupBox("Invalid last name. It should contain only letters", "Error");
            return false;
        }

        String delims = "/";
        String[] bdate = date.split(delims);
        if (bdate.length == 3) {
            if (!checkDate(bdate[0], bdate[1], bdate[2])) {
                return false;
            }
        } else {
            return false;
        }

        if (!password.equals(password2)) {
            popupBox("Password mismatch", "Error");
            return false;
        }

        return true;
    }

    /**
     * Check the name of the registration.
     *
     * @param name the name
     * @return true if the name is check else false
     */
    public boolean isAlpha(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Check the date of the registration.
     *
     * @param month the month
     * @param day the day
     * @param year the year
     * @return true if the date is checked else false
     */
    public boolean checkDate(String month, String day, String year) {
        int vday;
        int vmonth;
        int vyear;

        if (day.matches("[0-9]+") && day.length() <= 2) {
            vday = Integer.parseInt(day);
            if (vday <= 0 || vday > 31) {
                popupBox("Date exceeds the range", "Error");
                return false;
            }
        } else {
            popupBox("Invalid Date", "Error");
            return false;
        }

        if (month.matches("[0-9]+") && month.length() <= 2) {
            vmonth = Integer.parseInt(month);
            if (vmonth <= 0 || vmonth > 12) {
                popupBox("Month exceeds the range", "Error");
                return false;
            }
        } else {
            popupBox("Invalid Month", "Error");
            return false;
        }

        if (year.matches("[0-9]+") && year.length() == 4) {
            vyear = Integer.parseInt(year);
            if (vyear <= MINYEAR || vyear >= MAXYEAR) {
                popupBox("Year exceeds the range", "Error");
                return false;
            }

        } else {
            popupBox("Invalid Year", "Error");
            return false;
        }

        return true;
    }

    /**
     * The popupbox for errors.
     *
     * @param infoMessage the message
     * @param titleBar the title
     */
    public static void popupBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, " " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
