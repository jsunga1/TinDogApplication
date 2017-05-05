import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.*;


public class StartFrame extends JFrame{

	
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;
	private static final int FIELD_WIDTH = 10;
	private JTextField Start_Username;
	private JTextField Start_Password;
	private JButton Start_NUCA;
	private JButton Start_Login;
	
	private ActionListener nuca_listener;
	private ActionListener login_listener;
		
	private JPanel panel;
	private JPanel panel_center;
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JPanel panel_1;
	private JLabel lblWelcomeToTindog;
	private User user;
	

	
	public StartFrame(){
		class CreateAccount_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameNewUserFrame = new NewUserFrame();
				close();
				frameNewUserFrame.setVisible(true);
				frameNewUserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		}
		class Login_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				
				if (Start_Username.getText().equals("") || Start_Password.getText().equals(""))
				{
					if(Start_Username.getText().equals("") && Start_Password.getText().equals(""))
					{
						lblUserName.setText("You need to enter a Username first!");
						lblPassword.setText("You need to enter a Password first!");
					}
					else if(!Start_Username.getText().equals("") && Start_Password.getText().equals(""))
					{
						lblUserName.setText("Username: ");
						lblPassword.setText("You need to enter a Password first!");
					}
					else if(Start_Username.getText().equals("") && !Start_Password.getText().equals(""))
					{
						lblUserName.setText("You need to enter a Username first: ");
						lblPassword.setText("Password: ");
					}
						
				}
				else 
				{	
					try
					{
						UniversalDogDB connection = new UniversalDogDB();
						String query = "Select * from USER where USER_Email = \"" + Start_Username.getText() +"\";";
						connection.retrieveData(query);
						ResultSet rs = connection.getResultSet();
					
						if (!rs.isBeforeFirst())
						{
							lblUserName.setText("Username does not exist.");
							lblPassword.setText("Password: ");
						
						}
						else
						{
						
								
							if(rs.next() && rs.getString("USER_Password").equals(Start_Password.getText()))
							{

								
								user = new User();
								user.setUserInfo(Start_Username.getText());
								JFrame frameDogListFrame = new DogListFrame(sendUserData());
								close();
								frameDogListFrame.setVisible(true);
								frameDogListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							}
							else
							{
								lblUserName.setText("Username: ");
								lblPassword.setText("Incorrect Password. Please try again!");
							}
							
						}
					}
					catch (Exception userFailed)
					{
						System.out.println(userFailed);
					}
				}
			}
		}
		
		
		nuca_listener = new CreateAccount_Listener();
		login_listener = new Login_Listener();
		
		createcosa();
		
		Start_NUCA.addActionListener(nuca_listener);
		Start_Login.addActionListener(login_listener);
		
		createpanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	public void createcosa(){
		Start_Username = new JTextField(FIELD_WIDTH);
		Start_Password = new JTextField(FIELD_WIDTH);
		Start_NUCA = new JButton("New User? Create Account");
		Start_Login = new JButton("Login");
	}
	public void createpanel(){
	
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel_center = new JPanel();
		panel_center.setLayout(new GridLayout(6,1));
		
		lblUserName = new JLabel("Username:");
		panel_center.add(lblUserName);
		panel_center.add(Start_Username);
		
		lblPassword = new JLabel("Password:");
		panel_center.add(lblPassword);
		panel_center.add(Start_Password);
		panel_center.add(Start_NUCA);
		panel_center.add(Start_Login);
		panel.add(panel_center, BorderLayout.CENTER);
		getContentPane().add(panel);
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		lblWelcomeToTindog = new JLabel("Welcome to TinDog");
		panel_1.add(lblWelcomeToTindog);
	}
	public void close() {
		this.setVisible(false);
	}
	private User sendUserData(){
		return this.user;
	}
}
