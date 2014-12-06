import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class is View of the MVC and show the room informations
 *
 * @author Soe Lin Tun
 *
 */
public class RoomInfoPanel extends JPanel implements ChangeListener {

    private Model model;
    private PrintReceiptFrame printFrame;

    public RoomInfoPanel(Model m, final JFrame reservationframe, final JFrame welcomeframe) {
        model = m;

        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(79, 79, 82).brighter());
        this.setBorder(BorderFactory.createLineBorder(Color.white, 2));

        // create test area with scroll bar for room info
        JTextArea roominfoTextArea = new JTextArea(12, 23);
        JScrollPane roominfoScrollPane = new JScrollPane(roominfoTextArea);

        // create  label for panel
        JLabel titleLabel = new JLabel("     Available Rooms");
        titleLabel.setForeground(Color.blue);
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        titleLabel.setPreferredSize(new Dimension(230, 50));
        titleLabel.setFont(new Font("Tahoma", Font.ITALIC, 24));

        // create buttons for confirm and cancel
        JButton confirmBtn = new JButton("Confirmed");
        JButton transactionDoneBtn = new JButton("Transaction Done");
        confirmBtn.setPreferredSize(new Dimension(85, 40));
        confirmBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        transactionDoneBtn.setPreferredSize(new Dimension(150, 40));
        transactionDoneBtn.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel checkinLabel = new JLabel("  Check-in:");
        JLabel checkoutLabel = new JLabel("  Check-out:");
        checkinLabel.setForeground(Color.black);
        checkoutLabel.setForeground(Color.black);
        checkinLabel.setPreferredSize(new Dimension(90, 30));
        checkoutLabel.setPreferredSize(new Dimension(90, 30));
        checkinLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        checkoutLabel.setFont(new Font("Tahoma", Font.BOLD, 13));

        // create  text field for check-in/out
        JTextField checkinTextField = new JTextField();
        JTextField checkoutTextField = new JTextField();
        checkinTextField.setPreferredSize(new Dimension(90, 30));
        checkoutTextField.setPreferredSize(new Dimension(90, 30));

        // create buttons for room type & label
        JLabel buttonTypeLabel = new JLabel("  Room Type:");
        buttonTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        JButton twoHundredBtn = new JButton("$200");
        JButton oneHundredBtn = new JButton("$100");
        twoHundredBtn.setPreferredSize(new Dimension(90, 40));
        twoHundredBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        oneHundredBtn.setPreferredSize(new Dimension(90, 40));
        oneHundredBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        // add component to this panel
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 1;
        c.gridy = 0;
        c.gridx = 0;
        this.add(titleLabel, c);

        c.weighty = 1;
        c.gridy = 1;
        c.gridx = 0;
        c.insets = new Insets(0, 2, 0, 0);

        this.add(roominfoScrollPane, c);

        c.anchor = GridBagConstraints.BELOW_BASELINE_TRAILING;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 5;
        c.gridx = 1;
        this.add(confirmBtn, c);

        c.gridy = 5;
        c.gridx = 2;
        this.add(transactionDoneBtn, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.8;
        c.gridx = 0;
        c.gridy = 0;
        this.add(checkinLabel, c);
        c.gridx = 1;
        c.gridy = 0;
        this.add(checkoutLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        this.add(checkinTextField, c);
        c.gridx = 1;
        c.gridy = 1;
        this.add(checkoutTextField, c);

        // add components to checkInBtnPanel
        this.add(buttonTypeLabel);
        this.add(twoHundredBtn);
        this.add(oneHundredBtn);

        //TODO add ActionListener to Buttons
        // confrimBtn
        try {
            System.out.println("hi"+model.getCheckIn());
            System.out.println("hi2"+model.getCheckOut());
            if (!model.getCheckIn().equals("") && !model.getCheckOut().equals("")) {
                roominfoTextArea.setText(model.setToString(WelcomeFrame.pubRoomList.checkRoom(model.getCheckIn(), model.getCheckOut(), 100)));
            }
        } catch (NullPointerException e) {
            System.out.print("Error");
        }

        //transactionDoneBtn
        transactionDoneBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                printFrame = new PrintReceiptFrame(model, welcomeframe);
                printFrame.setVisible(true);
                reservationframe.setVisible(false);

            }

        });
        
        

       

//        if (!checkinTextField.equals(null)) {
//            checkinTextField.getDocument().addDocumentListener(new DocumentListener() {
//                public void changedUpdate(DocumentEvent e) {
//                    update();
//                }
//
//                public void removeUpdate(DocumentEvent e) {
//                    update();
//                }
//
//                public void insertUpdate(DocumentEvent e) {
//
//                }
//
//                public void update() {
//                    m.addCheckIn(checkinTextField.getText());
//                }
//            }
//            );
//            checkoutTextField.getDocument().addDocumentListener(new DocumentListener() {
//                public void changedUpdate(DocumentEvent e) {
//                    update();
//                }
//
//                public void removeUpdate(DocumentEvent e) {
//                    update();
//                }
//
//                public void insertUpdate(DocumentEvent e) {
//
//                }
//
//                public void update() {
//                    m.addCheckIn(checkoutTextField.getText());
//                }
//            }
//            );
//        }
        twoHundredBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                m.addCheckIn(checkinTextField.getText());
                System.out.println(checkinTextField.getText());
                m.addCheckOut(checkoutTextField.getText());
                System.out.println(checkoutTextField.getText());
                System.out.println(m.getCheckIn());
                System.out.println(m.getCheckOut());
                ReservationFrame temp=new ReservationFrame(m,reservationframe);
                reservationframe.setVisible(false);
                temp.setVisible(true);
                
            }

        });
        
        

    }


    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub

    }

}
