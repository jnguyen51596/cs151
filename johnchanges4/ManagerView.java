import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ManagerView extends JFrame implements ChangeListener {

    private Model model;
    private String[] months;
    private int currentMonth;
    private int currentYear;
    private JButton[][] calendarBtn;
    private String[] days;
    private ArrayList<String> dates;
    private int spaceCounter;

    public ManagerView(Model m) throws FileNotFoundException {
        model = m;
        months = m.getMonths();
        currentMonth = m.getCurrentMonth();
        currentYear = m.getCurrentYear();
        days = m.getDaysName();
        dates = m.getDate();
        spaceCounter = m.getSpaceCounter();
        calendarBtn = new JButton[6][7];
        
        // Set size, title and close option for Frame
        setSize(850, 600);
        setTitle("Manager Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set Panels date and room info
        JPanel mainManagerViewPanel = new JPanel(new GridBagLayout());
        mainManagerViewPanel.setBackground(new Color(79, 79, 82).brighter());
        JPanel dateViewPanel = new JPanel(new BorderLayout(10, 10));
        dateViewPanel.setBackground(new Color(100, 100, 182));
        JPanel roomViewPanel = new JPanel(new BorderLayout());

        // create Text Area with scroll and JLabel for roomViewPanel
        JLabel roominfoLabel = new JLabel("     Rooms Information");
        roominfoLabel.setFont(new Font("Tahoma", Font.ITALIC, 24));
        roominfoLabel.setForeground(Color.white);
        JTextArea roominfoTextArea = new JTextArea(15, 25);
        JScrollPane roominfoTextAreaPane = new JScrollPane(roominfoTextArea);
        roominfoTextArea.setEditable(false);

        // create two Buttons for roomViewPanel
        JButton saveBtn = new JButton("Save and Quit");    
        saveBtn.setPreferredSize(new Dimension(100, 40));
        saveBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
        saveBtn.setForeground(Color.black);  

        // create panel for save and quit buttons
        JPanel viewBtnPanel = new JPanel(new GridLayout(1, 2));
        viewBtnPanel.setBackground(new Color(100, 100, 182));
        viewBtnPanel.add(saveBtn);


        // add roominfoScrollPane into the roomViewPanel
        roomViewPanel.setBackground(new Color(100, 100, 182));
        roomViewPanel.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        roomViewPanel.add(roominfoTextAreaPane, BorderLayout.CENTER);
        roomViewPanel.add(roominfoLabel, BorderLayout.NORTH);
        roomViewPanel.add(viewBtnPanel, BorderLayout.SOUTH);

        // create JSpinner for months in  dateViewPanel
        JComboBox monthSpinner = new JComboBox();
        for (int j = 0; j < model.getMonthList().size(); j++) {
            monthSpinner.addItem(model.getMonthList().get(j));
        }
        monthSpinner.setSelectedIndex(model.getMonth());
        monthSpinner.setFont(new Font("Tahoma", Font.BOLD, 14));
        monthSpinner.setPreferredSize(new Dimension(150, 30));
        monthSpinner.setBorder(BorderFactory.createBevelBorder(1, Color.black, Color.white));

        // create JSpinner for  years in dateViewPanel
        JSpinner yearSpinner = new JSpinner(new SpinnerNumberModel(currentYear, currentYear - 100, currentYear + 100, 1));
        NumberEditor yeareditor = new JSpinner.NumberEditor(yearSpinner, "####");
        yearSpinner.setEditor(yeareditor);
        yearSpinner.setFont(new Font("Tahoma", Font.BOLD, 14));
        yearSpinner.setPreferredSize(new Dimension(150, 30));
        yearSpinner.setBorder(BorderFactory.createBevelBorder(1, Color.black, Color.white));

        // create monthYearPanel and add month and year spinner
        JPanel monthYearPanel = new JPanel(new GridLayout(1, 2));
        //monthYearPanel.add(monthComboBox);
        monthYearPanel.add(monthSpinner);
        monthYearPanel.add(yearSpinner);

        JTextArea calendarArea = new JTextArea(12, 4);
        JScrollPane calendarAreaPane = new JScrollPane(calendarArea);
        calendarArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calendarArea.setEditable(false);
        calendarArea.setText(model.printCalenar());

        calendarArea.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                try {
                    if (calendarArea.getSelectedText() != null) { //see if they selected something 
                        String text = "";
                        String s = calendarArea.getSelectedText();                  
                        ArrayList<ReservationModel> temp = model.getDatabase().getReservationListFromDatabase();
                        for (int i = 0; i < temp.size(); i++) {
                            SimpleDateFormat sdf;
                            Date startDate = null;
                            Date endDate = null;
                            Date calDate = null;
                            

                            String textSDate = temp.get(i).getStartMonth() + "/" + temp.get(i).getStartDay() + "/" + temp.get(i).getStartYear();
                            String textEDate = temp.get(i).getEndMonth() + "/" + temp.get(i).getEndDay() + "/" + temp.get(i).getEndYear();
                            String caleDate = model.getMonth() + 1 + "/" + s + "/" + model.getYear();
                            try {
                                sdf = new SimpleDateFormat("MM/dd/yyyy");
                                startDate = sdf.parse(textSDate);
                                endDate = sdf.parse(textEDate);
                                calDate = sdf.parse(caleDate);
                            } catch (ParseException p) {

                            }

                            if (startDate.after(calDate)) {
                                roominfoTextArea.setText("");
                            } else if (startDate.before(calDate) && endDate.after(calDate)) {
                                text = text + "Guest ID: " + temp.get(i).getGuestId() + "\n";
                                text = text + "Room Number: " + temp.get(i).getRoomNumber() + "\n";
                                text = text + "Room Type: " + temp.get(i).getRoomType() + "\n";
                                text = text + "Start Date: " + temp.get(i).getStartMonth() + "/" + temp.get(i).getStartDay() + "/" + temp.get(i).getStartYear() + "\n";
                                text = text + "End Date: " + temp.get(i).getEndMonth() + "/" + temp.get(i).getEndDay() + "/" + temp.get(i).getEndYear() + "\n";
                                text = text + " " + "\n";
                               // roominfoTextArea.setText(text);

                            } else if (startDate.equals(calDate) || endDate.equals(calDate)) {

                                text = text + "Guest ID: " + temp.get(i).getGuestId() + "\n";
                                text = text + "Room Number: " + temp.get(i).getRoomNumber() + "\n";
                                text = text + "Room Type: " + temp.get(i).getRoomType() + "\n";
                                text = text + "Start Date: " + temp.get(i).getStartMonth() + "/" + temp.get(i).getStartDay() + "/" + temp.get(i).getStartYear() + "\n";
                                text = text + "End Date: " + temp.get(i).getEndMonth() + "/" + temp.get(i).getEndDay() + "/" + temp.get(i).getEndYear() + "\n";
                                text = text + " " + "\n";
                                
                            } else {
                                roominfoTextArea.setText("");
                            }         
                        }
                        roominfoTextArea.setText(text);
                    }                
                } catch (NullPointerException n) {

                }
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

        });

        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    model.getDatabase().writeToReservationFile();
                     System.exit(0);
                    
                } catch (FileNotFoundException ex) {
                   
                }
            }

        });

        // create for  calendar
        JPanel calendarPanel = new JPanel(new BorderLayout(5, 5));

        JPanel calendarDayPanel = new JPanel();
        calendarDayPanel.setLayout(new GridLayout(6, 7, 0, 0));
        calendarDayPanel.setBackground(Color.white.brighter());
        ListIterator<String> itr = dates.listIterator();

        ChangeListener listener = new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                model.setYear((int) yearSpinner.getValue());
                calendarArea.setText(model.printCalenar());
            }

        };

        yearSpinner.addChangeListener(listener);

        monthSpinner.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < model.getMonthList().size(); i++) {
                    if (model.getMonthList().get(i).equals(monthSpinner.getSelectedItem())) {
                        model.setMonth(i);
                        calendarArea.setText(model.printCalenar());

                    }
                }
            }
        });

        // add components to panels
        calendarPanel.add(calendarAreaPane, BorderLayout.CENTER);
        dateViewPanel.add(monthYearPanel, BorderLayout.NORTH);
        dateViewPanel.add(calendarPanel, BorderLayout.CENTER);

        // add two panels to mainManagerViewPanel
        GridBagConstraints c = new GridBagConstraints();

        // set position for dateViewPanel
        // c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);

        mainManagerViewPanel.add(dateViewPanel, c);

        // set position for roomViewPanel
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 1;
        c.gridy = 0;
        mainManagerViewPanel.add(roomViewPanel, c);

        this.add(mainManagerViewPanel);
        setVisible(true);

    }

    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub

    }

}
