import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ListIterator;

import javax.swing.*;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ManagerView extends JFrame implements ChangeListener
{
	private Model model;
	private String [] months;
	private int currentMonth;
	private int currentYear;
	private JButton [] [] calendarBtn;
	private String [] days;
	private ArrayList<String> dates;
	private int spaceCounter;
	
	
	
	public ManagerView(Model m)
	{
		months = m.getMonths();
		currentMonth = m.getCurrentMonth();
		currentYear = m.getCurrentYear();
		days = m.getDaysName();
		dates = m.getDate();
		spaceCounter = m.getSpaceCounter();
		 calendarBtn = new JButton[6] [7];
		 
		// Set size, title and close option for Frame 
		setSize(850,400);
		setTitle("Manager Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Set Panels date and room info
		 JPanel mainManagerViewPanel = new JPanel(new GridBagLayout());
		mainManagerViewPanel.setBackground(new Color(79, 79, 82).brighter());
		 JPanel dateViewPanel = new JPanel(new BorderLayout(10,10));
		 dateViewPanel.setBackground(new Color(100, 100, 182));
		 JPanel roomViewPanel = new JPanel(new BorderLayout());
		
		
		 // create Text Area with scroll and JLabel for roomViewPanel
		 JLabel roominfoLabel = new JLabel("     Rooms Information");
		 roominfoLabel.setFont(new Font("Tahoma",Font.ITALIC,24));
		 roominfoLabel.setForeground(Color.white);
		 final JTextArea  roominfoTextArea = new JTextArea(15,25);
		 JScrollPane  roominfoScrollPane = new JScrollPane(roominfoTextArea);
		 roominfoTextArea.setEditable(false);
		 
		 // create two Buttons for roomViewPanel
		  JButton saveBtn = new JButton("Save");
		  JButton quitBtn  = new JButton("Quit");
		  saveBtn.setPreferredSize(new Dimension(100,40));
		  saveBtn.setFont(new Font("Tahoma",Font.BOLD,16));
		  saveBtn.setForeground(Color.black);
		  quitBtn.setPreferredSize(new Dimension(100,40));
		  quitBtn.setFont(new Font("Tahoma",Font.BOLD,16));
		  quitBtn.setForeground(Color.black);
		 
		  // create panel for save and quit buttons
		  JPanel viewBtnPanel =  new JPanel(new GridLayout(1,2));
		  viewBtnPanel.setBackground(new Color(100, 100, 182));
		  viewBtnPanel.add(saveBtn);
		  viewBtnPanel.add(quitBtn);
		 
		 // add roominfoScrollPane into the roomViewPanel
		 roomViewPanel.setBackground(new Color(100, 100, 182));
		 roomViewPanel.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		 roomViewPanel.add(roominfoScrollPane,BorderLayout.CENTER);
		 roomViewPanel.add(roominfoLabel, BorderLayout.NORTH);
		 roomViewPanel.add(viewBtnPanel, BorderLayout.SOUTH);
		
		
		 // create JSpinner for months in  dateViewPanel
		 	SpinnerListModel listModel = new SpinnerListModel(Arrays.asList(months).subList(0, 12));
		    JSpinner monthSpinner = new JSpinner(listModel);
		    monthSpinner.setValue(months[currentMonth]);
		    monthSpinner.setFont(new Font("Tahoma",Font.BOLD,14));
		    monthSpinner.setPreferredSize(new Dimension(150,30));
		    monthSpinner.setBorder(BorderFactory.createBevelBorder(1, Color.black, Color.white));
		
		    // create JSpinner for  years in dateViewPanel
		JSpinner yearSpinner = new JSpinner(new SpinnerNumberModel(currentYear, currentYear-100,currentYear+100,1));
		NumberEditor yeareditor = new JSpinner.NumberEditor(yearSpinner,"####") ;
	    yearSpinner.setEditor(yeareditor);
	    yearSpinner.setFont(new Font("Tahoma",Font.BOLD,14));
	    yearSpinner.setPreferredSize(new Dimension(150,30));
	    yearSpinner.setBorder(BorderFactory.createBevelBorder(1, Color.black, Color.white));
	    
	
		
	    // create monthYearPanel and add month and year spinner
	    JPanel monthYearPanel = new JPanel (new GridLayout(1,2));
	    //monthYearPanel.add(monthComboBox);
	    monthYearPanel.add(monthSpinner);
	    monthYearPanel.add(yearSpinner);
	   
		 // create for  calendar 
	     JPanel calendarPanel = new JPanel(new BorderLayout(5,5));
	     // create header of the calendar with day such as Mon, Tue, so on
	     JPanel calendarTitlePanel = new JPanel(new GridLayout(1,7,5,5));
	     calendarTitlePanel.setBackground(new Color(100, 100, 182));
	     {
	    	 	for (int i =0; i <7; i++)
	    	 	{
	    	 		JButton temp= new JButton(days[i+1]);
	    	 		temp.setFont(new Font("Tahoma",Font.ITALIC,20));
	    	 		temp.setBorder(BorderFactory.createBevelBorder(-1, Color.white, Color.white));
	    	 		temp.setPreferredSize(new Dimension(50,50));
	    	 		temp.setForeground(Color.white);
	    	 		calendarTitlePanel.add(temp);
	    	 	}
	     }
	     
	     // create panel for days such as 1,2, 3, so on
		 JPanel calendarDayPanel = new JPanel();
		 calendarDayPanel.setLayout(new GridLayout(6,7,0,0));
		 calendarDayPanel.setBackground(Color.white.brighter());
		 ListIterator<String>itr = dates.listIterator();
		
		 for (int row = 0; row<6; row++)
		 {
			 for(int col = 0; col< 7; col++)
		
			 {
				  if (row==0 && col<spaceCounter)
				  {
					  	calendarBtn[row][col]  =new JButton(" ");
					  	calendarBtn[row][col].setPreferredSize(new Dimension(40,40));
					  	calendarBtn[row][col].setFont(new Font("Tahoma",Font.BOLD,14));
					  	calendarBtn[row][col].setForeground(Color.black);
					  	calendarBtn[row][col].addMouseListener (new
						 MouseAdapter ()
						 {
					 		public void mouseClicked(MouseEvent event)
					 		{
					 		  JButton tempBtn =(JButton) event.getSource();
					 		  tempBtn.setForeground(Color.blue);
					 		  roominfoTextArea.setText(tempBtn.getText());
					 		}
					 
						 });
				 calendarDayPanel.add(calendarBtn[row][col]);
				  }
				  else
				  {
					     
					     calendarBtn[row][col]  =new JButton(itr.next());
						 calendarBtn[row][col].setPreferredSize(new Dimension(40,40));
						 calendarBtn[row][col].setFont(new Font("Tahoma",Font.BOLD,12));
						 calendarBtn[row][col].setForeground(Color.black);
						 calendarBtn[row][col].addMouseListener (new
								 MouseAdapter ()
								 {
							 		public void mouseClicked(MouseEvent event)
							 		{
							 		  JButton tempBtn =(JButton) event.getSource();
							 		  tempBtn.setForeground(Color.blue);
							 		  roominfoTextArea.setText(tempBtn.getText());
							 		}
							 
								 });
						 calendarDayPanel.add(calendarBtn[row][col]);
				  }
			 }
		 }
		 for (int row = 0; row<6; row++)
		 {
			 for(int col = 0; col< 7; col++)
			 {
				if( calendarBtn[row][col].getText().equalsIgnoreCase(" "))
				{
					calendarBtn[row][col].setEnabled(false);
				}
			 }
		 }
		 // add changeListener to the two Jspinner
		  ChangeListener listener= new ChangeListener(){
		 
			
			public void stateChanged(ChangeEvent e) 
			{
				JSpinner tempSpinner =	(JSpinner) e.getSource();
				//System.out.println( "Month Spinner -->"+tempSpinner.getValue());
				
			}
			
			 
		 };
		 
		 monthSpinner.addChangeListener(listener);
		 yearSpinner.addChangeListener(listener);
		 
		 
		 
		 // add components to panels
		 calendarPanel.add(calendarTitlePanel, BorderLayout.NORTH );
		 calendarPanel.add(calendarDayPanel, BorderLayout.CENTER);
		 dateViewPanel.add(monthYearPanel, BorderLayout.NORTH);
		 dateViewPanel.add(calendarPanel, BorderLayout.CENTER);
		 
		 
		 
		 
		 // add two panels to mainManagerViewPanel
		 GridBagConstraints c = new GridBagConstraints();
		 
		 // set position for dateViewPanel
		// c.fill = GridBagConstraints.BOTH;
		 
		 c.gridx = 0;
		 c.gridy = 0;
		 c.insets = new Insets(10,10,10,10);
		 
		 mainManagerViewPanel.add(dateViewPanel,c);
		 
		 // set position for roomViewPanel
		 c.fill = GridBagConstraints.BOTH;
		 c.insets = new Insets(10,10,10,10);
		 c.gridx = 1;
		 c.gridy  =0;
		 mainManagerViewPanel.add(roomViewPanel,c);
		 
		 this.add(mainManagerViewPanel);
		 setVisible(true);
		
	}

	
	
	public void stateChanged(ChangeEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

}
