import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private User user;
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
	private JLabel lblFirstName;
	private JTextField firstNameField;
	private JLabel lblPassword;
	private JTextField passwordField;
	private JLabel lblRetypePassword;
	private JTextField passwordConfField;
	private JLabel lblPhoneNumber;
	private JTextField phoneField;
	private JLabel lblLastName;
	private JTextField lastNameField;
	
	public EditUserFrame(User u){
		
		class cancelListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameSettingsFrame = new SettingsFrame(sendUserData());
				frameSettingsFrame.setVisible(true);
			}
		}
		class submitListener implements ActionListener{ //needs to take data
			public void actionPerformed(ActionEvent e){
				
				UniversalDogDB userlogin = new UniversalDogDB();
				String fname = firstNameField.getText();
				String lname = lastNameField.getText();
				String password = passwordField.getText();
				String passconf = passwordConfField.getText();
				String phone = phoneField.getText();
				String email = user.getEmail();
				
				if(password.equals(passconf)){
					//Jack, update query here if the passwords match
					String query = " ";
					userlogin.sendData(query);
				}
				else if(!password.equals(passconf)){
					lblPassword.setText("Your passwords did not match! Please try again!");
					lblRetypePassword.setText("Your passwords did not match! Please try again!");
				}
				
				JFrame frameSettingsFrame = new SettingsFrame(sendUserData());
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
		
		lblFirstName = new JLabel("First Name: ");
		centerPanel.add(lblFirstName);
		
		firstNameField = new JTextField();
		centerPanel.add(firstNameField);
		firstNameField.setColumns(10);
		
		lblLastName = new JLabel("Last Name:");
		centerPanel.add(lblLastName);
		
		lastNameField = new JTextField();
		centerPanel.add(lastNameField);
		lastNameField.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		centerPanel.add(lblPassword);
		
		passwordField = new JTextField();
		centerPanel.add(passwordField);
		passwordField.setColumns(10);
		
		lblRetypePassword = new JLabel("Re-type Password:");
		centerPanel.add(lblRetypePassword);
		
		passwordConfField = new JTextField();
		centerPanel.add(passwordConfField);
		passwordConfField.setColumns(10);
		
		lblPhoneNumber = new JLabel("Phone Number");
		centerPanel.add(lblPhoneNumber);
		
		phoneField = new JTextField();
		centerPanel.add(phoneField);
		phoneField.setColumns(10);
	}
	public void close(){
		this.setVisible(false);
	}
	public User sendUserData(){
		return this.user;
	}
}