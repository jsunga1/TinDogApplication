import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;

public class LoginFrame extends JFrame{
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;
	private static final int FIELD_WIDTH = 10;
	private JButton cancelButton;
	private JButton submitButton;
	
	private ActionListener cancelButtonListener;
	private ActionListener submitButtonListener;
	
	private JPanel panel;
	private JPanel southPanel;
	private JPanel northPanel;
	private JPanel panel_2;
	private Component glue;
	private JLabel lblEditAccount;
	private JButton btnNewButton;
	private JPanel centerPanel;
	private JLabel lblNewLabel;
	private JTextField nameField;
	private JLabel lblPassword;
	private JTextField passwordField;
	private JLabel lblRetypePassword;
	private JTextField passwordconfirmField;
	private JLabel lblPhoneNumber;
	private JTextField phoneField;
	
	public LoginFrame(){
		class cancelListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				
			}
		}
		class submitListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				UniversalDogDB userlogin = new UniversalDogDB();
				try{
					//dogdb.sendData("INSERT INTO USER (USER_First_Name,USER_Last_Name,USER_Email,USER_Password)" + "VALUES('Jack', 'Fogarty','Jack69@gmail.com','itworksyay')");
					userlogin.retrieveData("select DOG_Name from DOG_2");
					ResultSet test = userlogin.getResultSet();
				 while(test.next()) // Retrieve data from ResultSet
		         {
		             System.out.println("Name: "+test.getString(1)); //1st column of Table from database

		         }
				}catch (Exception d){
					System.out.println(d);
				}
				
				
			}
		}
		createComponents();
		cancelButtonListener = new cancelListener();
		cancelButton.addActionListener(cancelButtonListener);
		submitButtonListener = new submitListener();
		submitButton.addActionListener(submitButtonListener);
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	public void createComponents(){
		cancelButton = new JButton("Cancel");
		submitButton = new JButton("Submit");
	}
	public void createPanel(){
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		southPanel = new JPanel();
		southPanel.add(cancelButton);
		southPanel.add(submitButton);
		panel.add(southPanel, BorderLayout.SOUTH);
		getContentPane().add(panel);
		
		northPanel = new JPanel();
		panel.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		northPanel.add(panel_2, BorderLayout.CENTER);
		
		glue = Box.createGlue();
		panel_2.add(glue);
		
		lblEditAccount = new JLabel("Edit Account");
		panel_2.add(lblEditAccount);
		
		btnNewButton = new JButton("<--");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		northPanel.add(btnNewButton, BorderLayout.WEST);
		
		centerPanel = new JPanel();
		panel.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(8, 1, 0, 0));
		
		lblNewLabel = new JLabel("Name: ");
		centerPanel.add(lblNewLabel);
		
		nameField = new JTextField();
		centerPanel.add(nameField);
		nameField.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		centerPanel.add(lblPassword);
		
		passwordField = new JTextField();
		centerPanel.add(passwordField);
		passwordField.setColumns(10);
		
		lblRetypePassword = new JLabel("Re-type Password:");
		centerPanel.add(lblRetypePassword);
		
		passwordconfirmField = new JTextField();
		centerPanel.add(passwordconfirmField);
		passwordconfirmField.setColumns(10);
		
		lblPhoneNumber = new JLabel("Phone Number");
		centerPanel.add(lblPhoneNumber);
		
		phoneField = new JTextField();
		centerPanel.add(phoneField);
		phoneField.setColumns(10);
	}
}