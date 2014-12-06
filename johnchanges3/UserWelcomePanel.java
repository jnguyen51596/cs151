import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Guest<2>
 * This class has to show after user successfully log in the system
 *
 * @author Soe Lin Tun
 *
 */

public class UserWelcomePanel extends JPanel {

    private Model model;
    private ReservationFrame guestMainMenu;
    private ViewCancelFrame viewcancel;

    public UserWelcomePanel(Model m, final JFrame previousframe) {

        model = m;
        // Create JButton for make a reservation
        JButton makeReservation = new JButton("Make a Reservation");
        makeReservation.setBorderPainted(true);
        makeReservation.setBackground(Color.WHITE.darker());
        makeReservation.setForeground(Color.blue.brighter());
        makeReservation.setFont(new Font("serif", Font.ITALIC, 20));
        makeReservation.setPreferredSize(new Dimension(200, 60));

        // Create JButton for view/cancel a reservation
        JButton viewOrCancel = new JButton("View/Cancel a Reservation");
        viewOrCancel.setBorderPainted(true);
        viewOrCancel.setBackground(new Color(59, 89, 182));
        viewOrCancel.setForeground(Color.blue.brighter());
        viewOrCancel.setFont(new Font("Serif", Font.ITALIC, 20));
        viewOrCancel.setPreferredSize(new Dimension(250, 60));

				//Create  JPanel
        setLayout(new GridBagLayout());
        setBackground(new Color(79, 79, 82).brighter());
        setBorder(BorderFactory.createTitledBorder(null, "Main Menu", TitledBorder.CENTER, TitledBorder.TOP, new Font("Tahoma", Font.ITALIC, 24), Color.white));

        // create gridbag constraints
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        add(makeReservation, c);

        c.gridx = 1;
        c.gridwidth = 2;
        add(viewOrCancel, c);

        setVisible(true);

				//TODO:Need To Add addActionListner  on both JButtons
				//TODO Implement addActinLister  for make a reservation button
        makeReservation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                previousframe.setVisible(false);
                guestMainMenu = new ReservationFrame(model, previousframe);
                guestMainMenu.setVisible(true);
                //System.out.println(getParent().getParent().getParent().getParent().getParent().getParent());
            }

        });

        //TODO Implement addActionListern for view/cancel a reservation 
        viewOrCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                previousframe.setVisible(false);
                viewcancel = new ViewCancelFrame(model, previousframe);
                viewcancel.setVisible(true);

            }
        });

    }

}
