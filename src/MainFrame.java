import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private ActionListener backListener;
	private ActionListener settingsListener;
	private ActionListener doggieBagListener;
	private ActionListener helpListener;
	private User user;
	
	public MainFrame(User u)
	{
		user = u;
		class createBackListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JFrame frameDogListFrame;
				try {
					frameDogListFrame = new DogListFrame(sendUserData());
					close();
					frameDogListFrame.setVisible(true);
					frameDogListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		class createSettingsListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameSettingsFrame = new SettingsFrame(sendUserData());
				close();
				frameSettingsFrame.setVisible(true);
				frameSettingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		class createDoggieBagListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameDoggieBagFrame = new DoggieBagFrame(sendUserData());
				close();
				frameDoggieBagFrame.setVisible(true);
			}
		}
		class createHelpListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameHelpFrame = new HelpFrame(sendUserData());
				close();
				frameHelpFrame.setVisible(true);
			}
		}
		backListener = new createBackListener();
		settingsListener = new createSettingsListener();
		doggieBagListener = new createDoggieBagListener();
		helpListener = new createHelpListener();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout(0, 0));
		
		JButton btnBack = new JButton("<--");
		panelNorth.add(btnBack, BorderLayout.WEST);
		btnBack.addActionListener(backListener);
		JPanel panelNorthCenter = new JPanel();
		panelNorth.add(panelNorthCenter, BorderLayout.CENTER);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		panelNorthCenter.add(lblMainMenu);
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnViewDoggieBag = new JButton("View Doggie Bag");
		panelCenter.add(btnViewDoggieBag);
		btnViewDoggieBag.addActionListener(doggieBagListener);
		JButton btnSettings = new JButton("Settings");
		panelCenter.add(btnSettings);
		btnSettings.addActionListener(settingsListener);
		JButton btnHelp = new JButton("Help");
		panelCenter.add(btnHelp);
		btnHelp.addActionListener(helpListener);
	}
	public void close(){
		this.setVisible(false);
	}
	public User sendUserData(){
		return this.user;
	}
}
