import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class ViewCancelFrame extends JFrame
{
	private Model model;
	
	public ViewCancelFrame(Model m, final JFrame previousframe)
	{
		model = m;
		// setup the frame
		setTitle("View/Cancel Researvation");
		setSize(650,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,0,10,10));
		setBackground(new Color(69,69,86).brighter());
		//create panel for view 
		JPanel viewReservationPanel =  new JPanel(new GridBagLayout());
		
		
		
		
		// create Panel for TextAera
		JPanel viewPanel = new JPanel(new BorderLayout());
		viewPanel.setBackground(new Color(79,29,82).darker());
		viewPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 2));
		
		// create Text Area with Scroll bar to display the information
		JTextArea displayReservationTextArea = new JTextArea( 15,20);
		JScrollPane displayReservationPane = new JScrollPane(displayReservationTextArea);
		displayReservationTextArea.setEditable(false);
		viewPanel.add(displayReservationPane, BorderLayout.CENTER);
		
		// create label for title
		  JLabel titleLabel = new JLabel("   Reservations Information");
		 titleLabel.setForeground(Color.white);
		 titleLabel.setPreferredSize(new Dimension(230,30));
		 titleLabel.setFont(new Font("Tahoma", Font.ITALIC,18));
		 viewPanel.add(titleLabel, BorderLayout.NORTH);
			
		
		// create  a cancellation Button
		JButton  cancelReservationBtn = new JButton("Cancel a Reservation");
		cancelReservationBtn.setFont(new Font("Serif", Font.BOLD, 16));
		cancelReservationBtn.setPreferredSize(new Dimension(200,40));
		cancelReservationBtn.setForeground(Color.white);
		cancelReservationBtn.setBackground(Color.GRAY);
		cancelReservationBtn.setOpaque(true);
		cancelReservationBtn.setBorder(BorderFactory.createEmptyBorder());
		
		
		// create a quit button
		JButton  quitBtn = new JButton(" Main Menu ");
		quitBtn.setFont(new Font("Serif", Font.BOLD, 16));
		quitBtn.setPreferredSize(new Dimension(200,40));
		quitBtn.setForeground(Color.white);
		quitBtn.setBackground(Color.GRAY);
		quitBtn.setOpaque(true);
		quitBtn.setBorder(BorderFactory.createEmptyBorder());
		
		
		
		
		
		// create cancel textfield and buttons for cancellation 
		JTextField cancelTextField = new JTextField();
		cancelTextField.setPreferredSize(new Dimension(80,30));
		
		// confirm btn in cancel a reservation panel
		JButton  cancelConfirmBtn = new JButton("Confirmed");
		 cancelConfirmBtn.setFont(new Font("Serif", Font.BOLD, 14));
		 cancelConfirmBtn.setPreferredSize(new Dimension(150,40));
		 cancelConfirmBtn.setForeground(Color.black);
		
		 
		 // cancel btn in cancel  a reservation panel
		JButton  cancelClearBtn = new JButton("Cancel");
		cancelClearBtn.setFont(new Font("Serif", Font.BOLD, 14));
		cancelClearBtn.setPreferredSize(new Dimension(150,40));
		cancelClearBtn.setForeground(Color.black);
		
		//create a panel for cancel buttons
		JPanel cancelBtnPanel = new JPanel( new GridLayout(1,2,10,10));
		cancelBtnPanel.add(cancelConfirmBtn);
		cancelBtnPanel.add(cancelClearBtn);
		
		// create  a panel for cancellation
		final JPanel cancelPanel = new JPanel(new GridBagLayout());
		cancelPanel.setBorder(BorderFactory.createTitledBorder(null, " Enter Reservation # to Cancel ", TitledBorder.CENTER,
				TitledBorder.TOP, new Font("Tahoma",Font.ITALIC,18), Color.red));
		
		GridBagConstraints d = new GridBagConstraints();
		d.fill = GridBagConstraints.HORIZONTAL;
		
		d.gridx = 0;
		d.gridy = 1;
		cancelPanel.add(cancelTextField,d);
		
		d.gridy = 2;
		cancelPanel.add(cancelBtnPanel,d);
		
		
		// add to main
		GridBagConstraints c = new GridBagConstraints();
		// add reservation panel
		
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets (10,10,10,10);
		c.gridx =1;
		c.gridy = 0;
		viewReservationPanel.add(cancelReservationBtn, c);
		
		c.gridx =0;
		c.gridy = 0;
		viewReservationPanel.add(quitBtn, c);
		
		//c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		viewReservationPanel.add(viewPanel, c);
		
		c.gridx =0;
		c.gridy = 2;
		viewReservationPanel.add(cancelPanel, c);
		cancelPanel.setVisible(false); //  hide the panel  when frame load
		
		
		// add action to cancel a reservation button
		cancelReservationBtn.addActionListener(new
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				cancelPanel.setVisible(true);
				
				//System.out.println(getParent().getParent().getParent().getParent().getParent().getParent());
			}
				
				
		});
		
		// add action to cancelClear button in the cancellation panel
		cancelClearBtn.addActionListener(new
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				cancelPanel.setVisible(false);
				
				//System.out.println(getParent().getParent().getParent().getParent().getParent().getParent());
			}
				
				
		});
		
		
		
		// add action to quit button
		quitBtn.addActionListener(new
				ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				setVisible(false);
				previousframe.setVisible(true);
				
				
			}
				
				
		});
		
		
		add(viewReservationPanel);
		setVisible(true);
	}
	
	

}
