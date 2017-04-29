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

public class EditUserFrame extends JFrame{
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
	private JPanel northPanel_center;
	private Component glue;
	private JLabel lblEditAccount;
	private JButton button_back;
	private JPanel centerPanel;
<<<<<<< HEAD
	private JLabel label_name;
	private JTextField nameField;
	private JLabel lblPassword;
	private JTextField passwordField;
	private JLabel lblRetypePassword;
	private JTextField passwordconfField;
	private JLabel lblPhoneNumber;
	private JTextField phoneField;
=======
	private JLabel lblFirstName;
	private JTextField textFieldFirstName;
	private JLabel lblPassword;
	private JTextField textFieldPassword;
	private JLabel lblRetypePassword;
	private JTextField textFieldReTypePassword;
	private JLabel lblPhoneNumber;
	private JTextField textFieldPhoneNumber;
	private JLabel lblLastName;
	private JTextField textFieldLastName;
>>>>>>> refs/remotes/origin/master
	
	public EditUserFrame(){
		class cancelListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameSettingsFrame = new settingsFrame();
				frameSettingsFrame.setVisible(true);
			}
		}
		class submitListener implements ActionListener{ //needs to take data
			public void actionPerformed(ActionEvent e){
				
				UniversalDogDB userlogin = new UniversalDogDB();
				String name = nameField.getText();
				String password = passwordField.getText();
				String passconf = passwordconfField.getText();
				String phone = phoneField.getText();
				String email = User.getEmail();
				
				if(password.equals(passconf)){
					//Jack, update query here if the passwords match
					String query = " ";
					userlogin.sendData(query);
				}
				
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
				
				JFrame frameSettingsFrame = new settingsFrame();
				frameSettingsFrame.setVisible(true);
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
		
		northPanel_center = new JPanel();
		northPanel.add(northPanel_center, BorderLayout.CENTER);
		
		glue = Box.createGlue();
		northPanel_center.add(glue);
		
		lblEditAccount = new JLabel("Edit Account");
		northPanel_center.add(lblEditAccount);
		
		button_back = new JButton("<--");
		button_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		northPanel.add(button_back, BorderLayout.WEST);
		
		centerPanel = new JPanel();
		panel.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblFirstName = new JLabel("Name: ");
		centerPanel.add(lblFirstName);
		
<<<<<<< HEAD
		nameField = new JTextField();
		centerPanel.add(nameField);
		nameField.setColumns(10);
=======
		textFieldFirstName = new JTextField();
		centerPanel.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		lblLastName = new JLabel("Last Name:");
		centerPanel.add(lblLastName);
		
		textFieldLastName = new JTextField();
		centerPanel.add(textFieldLastName);
		textFieldLastName.setColumns(10);
>>>>>>> refs/remotes/origin/master
		
		lblPassword = new JLabel("Password:");
		centerPanel.add(lblPassword);
		
<<<<<<< HEAD
		passwordField = new JTextField();
		centerPanel.add(passwordField);
		passwordField.setColumns(10);
=======
		textFieldPassword = new JTextField();
		centerPanel.add(textFieldPassword);
		textFieldPassword.setColumns(10);
>>>>>>> refs/remotes/origin/master
		
		lblRetypePassword = new JLabel("Re-type Password:");
		centerPanel.add(lblRetypePassword);
		
<<<<<<< HEAD
		passwordconfField = new JTextField();
		centerPanel.add(passwordconfField);
		passwordconfField.setColumns(10);
=======
		textFieldReTypePassword = new JTextField();
		centerPanel.add(textFieldReTypePassword);
		textFieldReTypePassword.setColumns(10);
>>>>>>> refs/remotes/origin/master
		
		lblPhoneNumber = new JLabel("Phone Number");
		centerPanel.add(lblPhoneNumber);
		
<<<<<<< HEAD
		phoneField = new JTextField();
		centerPanel.add(phoneField);
		phoneField.setColumns(10);
=======
		textFieldPhoneNumber = new JTextField();
		centerPanel.add(textFieldPhoneNumber);
		textFieldPhoneNumber.setColumns(10);
>>>>>>> refs/remotes/origin/master
	}
	public void close(){
		this.setVisible(false);
	}
}