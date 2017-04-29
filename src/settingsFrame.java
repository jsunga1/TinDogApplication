import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Component;

public class SettingsFrame extends JFrame{
	
	
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;
	
	private JButton Settings_About;
	private JButton Settings_EditAccount;
	private JButton Settings_Logout;
	private JButton Settings_DeleteAccount;
	
	private ActionListener about_listener;
	private ActionListener edit_listener;
	private ActionListener logout_listener;
	private ActionListener deleteaccount_listener;
	private ActionListener back_listener;
	
	private JPanel panel;
	private JPanel panel_north;
	private JPanel panel_center;
	private JButton button;
	private JPanel panel_1;
	private Component glue;
	private JLabel lblSettings;
	
	public SettingsFrame(){
		class About_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				
			}
		}
		class Edit_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				
			}
		}
		class Logout_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				
			}
		}
		class DeleteAccount_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				
			}
		}
		class Back_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				
			}
		}
		
		
		about_listener = new About_Listener();
		edit_listener = new Edit_Listener();
		logout_listener = new Logout_Listener();
		deleteaccount_listener = new DeleteAccount_Listener();
		back_listener = new Back_Listener();
		createcosa();
		Settings_About.addActionListener(about_listener);
		Settings_EditAccount.addActionListener(edit_listener);
		Settings_Logout.addActionListener(logout_listener);
		Settings_DeleteAccount.addActionListener(deleteaccount_listener);
		
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public void createcosa(){
		
		Settings_About = new JButton("About");
		Settings_EditAccount = new JButton("Edit Account");
		Settings_Logout = new JButton("Logout");
		Settings_DeleteAccount = new JButton("Delete Account");
		
		
		
	}
	public void createPanel(){
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel_center = new JPanel();
		panel_center.setLayout(new GridLayout(4,1));
		panel_center.add(Settings_About);
		panel_center.add(Settings_EditAccount);
		panel_center.add(Settings_Logout);
		panel_center.add(Settings_DeleteAccount);
		panel_north = new JPanel();
		panel_north.setLayout(new BorderLayout());
		panel.add(panel_center, BorderLayout.CENTER);
		panel.add(panel_north, BorderLayout.NORTH);
		
		button = new JButton("←");
		panel_north.add(button, BorderLayout.WEST);
		
		panel_1 = new JPanel();
		panel_north.add(panel_1, BorderLayout.CENTER);
		
		glue = Box.createGlue();
		panel_1.add(glue);
		
		lblSettings = new JLabel("Settings");
		panel_1.add(lblSettings);
		getContentPane().add(panel);
	}
}
