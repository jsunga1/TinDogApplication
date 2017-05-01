import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;

public class NewUserFrame extends JFrame{
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;
	private static final int FIELD_WIDTH = 10;
	/*private JLabel emailLabel;
	private JTextField emailField;
	private JLabel passwordLabel;
	private JTextField passwordField;
	private JLabel passwordConfirmLabel;
	private JTextField passwordConfirmField;
	private JLabel phoneLabel;
	private JTextField phoneField;
	private JButton cancelButton;
	private JButton submitButton;*/
	
	private JPanel contentPane;
	private JTextField textFieldFirstName;
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;
	private JTextField textFieldPasswordConfirmation;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldLastName;
	
	private ActionListener cancelButtonListener;
	private ActionListener submitButtonListener;
	
	private JPanel panel;
	private JPanel westPanel;
	private JPanel southPanel;
	
	public NewUserFrame(){
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblFirstName = new JLabel("First Name:");
		panelCenter.add(lblFirstName);
		
		textFieldFirstName = new JTextField();
		panelCenter.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		panelCenter.add(lblLastName);
		
		textFieldLastName = new JTextField();
		panelCenter.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		panelCenter.add(lblEmail);
		
		textFieldEmail = new JTextField();
		panelCenter.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		panelCenter.add(lblPassword);
		
		textFieldPassword = new JTextField();
		panelCenter.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JLabel lblPasswordConfirmation = new JLabel("Password Confirmation:");
		panelCenter.add(lblPasswordConfirmation);
		
		textFieldPasswordConfirmation = new JTextField();
		panelCenter.add(textFieldPasswordConfirmation);
		textFieldPasswordConfirmation.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		panelCenter.add(lblPhoneNumber);
		
		textFieldPhoneNumber = new JTextField();
		panelCenter.add(textFieldPhoneNumber);
		textFieldPhoneNumber.setColumns(10);
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblCreateNewUser = new JLabel("Create New User");
		panelNorth.add(lblCreateNewUser);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnCancel = new JButton("Cancel");
		panelSouth.add(btnCancel);
		
		JButton btnSubmit = new JButton("Submit");
		panelSouth.add(btnSubmit);
		
		class cancelListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameStartFrame = new StartFrame();
				close();
				frameStartFrame.setVisible(true);
				frameStartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		class submitListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				/*try{
					UniversalDogDB db = new UniversalDogDB();
					String query = "select * from USER where USER_Email = \"" + emailField.getText();
					
					db.sendData(query);
				}catch (Exception newUserFailed)
				{
					System.out.println(newUserFailed);
				}*/
				textFieldEmail.setText("This works");
			}
		}
		cancelButtonListener = new cancelListener();
		btnCancel.addActionListener(cancelButtonListener);
		submitButtonListener = new submitListener();
		btnSubmit.addActionListener(submitButtonListener);
	
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	/*public void createComponents(){
		
		emailLabel = new JLabel("Email:");
		emailField = new JTextField(FIELD_WIDTH);
		passwordLabel = new JLabel("Password:");
		passwordField = new JTextField(FIELD_WIDTH);
		passwordConfirmLabel = new JLabel("Password Confirmation:");
		passwordConfirmField = new JTextField(FIELD_WIDTH);
		phoneLabel = new JLabel("Phone Number:");
		phoneField = new JTextField(FIELD_WIDTH);
		cancelButton = new JButton("Cancel");
		submitButton = new JButton("Submit");
	}
	public void createPanel(){
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(10,1));
		southPanel = new JPanel();
		westPanel.add(emailLabel);
		westPanel.add(emailField);
		westPanel.add(passwordLabel);
		westPanel.add(passwordField);
		westPanel.add(passwordConfirmLabel);
		westPanel.add(passwordConfirmField);
		westPanel.add(phoneLabel);
		westPanel.add(phoneField);
		panel.add(westPanel, BorderLayout.CENTER);
		southPanel.add(cancelButton);
		southPanel.add(submitButton);
		panel.add(southPanel, BorderLayout.SOUTH);
		add(panel);
	}*/
	public void close(){
		this.setVisible(false);
	}
}