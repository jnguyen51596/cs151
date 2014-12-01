import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PrintReceiptFrame extends JFrame

{

	private Model model;
	
	public PrintReceiptFrame (Model m, final JFrame welcomeFrame)
	{
		setTitle("Receipt & Print");
		setSize(600,600);
		setLocation(400, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// create container for three Buttons and  One text Area
		JPanel mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setBackground(new Color(69,69,82).brighter());
		
		// Create simple receipt button
		JButton simpleBtn = new JButton("Simple");
		simpleBtn.setPreferredSize(new Dimension(150,40));
		simpleBtn.setFont(new Font ("Serif",Font.ITALIC, 22));
		simpleBtn.setForeground(Color.BLUE);
		//simpleBtn.setBorder(BorderFactory.createEmptyBorder());
		//simpleBtn.setBackground(Color.white);
		//simpleBtn.setOpaque(true);
		
		// Create comprehensie Button
		JButton comprehensiveBtn = new JButton("Conprehensive");
		comprehensiveBtn.setPreferredSize(new Dimension(200,40));
		comprehensiveBtn.setFont(new Font ("Serif",Font.ITALIC, 22));
		comprehensiveBtn.setForeground(Color.BLUE);
		//comprehensiveBtn.setBorder(BorderFactory.createEmptyBorder());
		//comprehensiveBtn.setBackground(Color.white);
		//comprehensiveBtn.setOpaque(true);
		
		// Create JTextArea to dispaly information
		JTextArea  amountTextArea = new JTextArea(15,25);
		amountTextArea.setEditable(false);
		JScrollPane  amountScrollPane = new JScrollPane(amountTextArea);
		
		
		// Create print button
		JButton printBtn = new JButton("Print");
		printBtn.setPreferredSize(new Dimension(150,40));
		printBtn.setFont(new Font ("Serif",Font.ITALIC, 24));
		printBtn.setForeground(Color.BLUE);
		//printBtn.setBorder(BorderFactory.createEmptyBorder());
		//printBtn.setBackground(Color.white);
		//printBtn.setOpaque(true);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		c.insets = new Insets(10,10,10,10);
		c.gridx =0;
		c.gridy =0;
		mainPanel.add(simpleBtn,c);
		
		c.gridx =1;
		c.gridy =0;
		mainPanel.add(comprehensiveBtn,c);
		
		c.gridx =1;
		c.gridy =2;
		mainPanel.add(printBtn,c);
		
		c.gridx =0;
		c.gridy =1;
		c.gridwidth = 2;
		mainPanel.add(amountTextArea,c);
		
		add(mainPanel);
		setVisible(true);
		
		
		
	}
	
	
}
