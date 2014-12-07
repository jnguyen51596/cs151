import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * The repeat frame
 *
 * @author SJK
 * @version 1.0
 */
public class RepeatFrame extends JFrame {

    private Model model;
    private ReservationFrame reserve;
    private PrintReceiptFrame printFrame;

    /**
     * Construct the repeating frame to repeat reservation frame.
     *
     * @param m the model
     * @param welcomeframe the previous frame
     */
    public RepeatFrame(Model m, final JFrame welcomeframe) {
        model = m;
        setTitle("Reservation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocation(400, 100);
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(69, 69, 82).brighter());

        JLabel questionLabel1 = new JLabel(" Will You Continue With Adding Reservation?");
        JLabel questionLabel2 = new JLabel(" If yes click continue else click Transaction Done.");
        questionLabel1.setForeground(Color.black);
        questionLabel2.setForeground(Color.black);
        questionLabel1.setPreferredSize(new Dimension(500, 50));
        questionLabel2.setPreferredSize(new Dimension(500, 50));
        questionLabel1.setFont(new Font("Tahoma", Font.BOLD, 20));
        questionLabel2.setFont(new Font("Tahoma", Font.BOLD, 20));

        JButton contBtn = new JButton("Continue");
        contBtn.setPreferredSize(new Dimension(150, 40));
        contBtn.setFont(new Font("Serif", Font.ITALIC, 22));
        contBtn.setForeground(Color.BLUE);

        JButton endBtn = new JButton("Transaction Done");
        endBtn.setPreferredSize(new Dimension(200, 40));
        endBtn.setFont(new Font("Serif", Font.ITALIC, 22));
        endBtn.setForeground(Color.BLUE);

        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(questionLabel1, c);

        c.gridx = 0;
        c.gridy = 1;
        mainPanel.add(questionLabel2, c);

        c.gridx = 0;
        c.gridy = 3;
        mainPanel.add(contBtn, c);

        c.gridx = 0;
        c.gridy = 4;
        mainPanel.add(endBtn, c);

        add(mainPanel);
        setVisible(true);

        //Add actionlistener to the Continue Button
        //Constructs a ReservationFrame and shows it. Reset the model CheckIn and CheckOut dates.
        contBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                reserve = new ReservationFrame(model, welcomeframe);
                model.addCheckIn("");
                model.addCheckOut("");
                setVisible(false);
                reserve.setVisible(true);

            }
        });

        //Add actionlistener to the Transaction Done (End) button
        //Constructs printReceiptFrame and shows the frame
        endBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                printFrame = new PrintReceiptFrame(model, welcomeframe);
                printFrame.setVisible(true);
                setVisible(false);

            }

        });

    }

}
