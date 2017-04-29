import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Component;

public class MainFrame extends JFrame{

	
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;
	
	//Doggie Bag Icon
	private JButton Main_Back;
	private JButton Main_SeeDoggieBag;
	private JButton Main_Settings;
	private JButton Main_Help;
	//Tindog Logo
	
	private ActionListener seedoggiebag_listener;
	private ActionListener settings_listener;
	private ActionListener help_listener;
	private ActionListener back_listener;
	
	private JPanel panel;
	private JPanel panel_north;
	private JPanel panel_center;
	private JPanel panel_south;
	private JPanel panel_1;
	private Component glue;
	private JLabel lblMainMenu;
	
	public MainFrame(){
		
		class SeeDoggieBag_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				
			}
		}
		class Settings_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				
			}
		}
		class Help_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				
			}
		}
		class Back_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameDogListFrame = new DogListFrame();
				close();
				frameDogListFrame .setVisible(true);
				frameDogListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		
		seedoggiebag_listener = new SeeDoggieBag_Listener();
		settings_listener = new Settings_Listener();
		help_listener = new Help_Listener();
		back_listener = new Back_Listener();
		
		createcosa();
		Main_SeeDoggieBag.addActionListener(seedoggiebag_listener);
		Main_Settings.addActionListener(settings_listener);
		Main_Help.addActionListener(help_listener);
		
		
		
		createpanel();
		Main_Back.addActionListener(back_listener);
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	public void createcosa(){
		Main_SeeDoggieBag = new JButton("See Doggie Bag");
		Main_Settings = new JButton("Settings");
		Main_Help = new JButton("Help");
		//Tindog Logo
	}
	public void createpanel(){
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel_north = new JPanel();
		panel_north.setLayout(new BorderLayout(0, 0));
		panel_center = new JPanel();
		//Doggie Bag Icon
		panel_center.add(Main_SeeDoggieBag);
		panel_center.add(Main_Settings);
		panel_center.add(Main_Help);
		panel_center.setLayout(new GridLayout(3,1));
		panel_south = new JPanel();
		//panel_south.add(Tindog Logo);
		panel.add(panel_north, BorderLayout.NORTH);
		
		//Doggie Bag Icon
		Main_Back = new JButton("<--");
		panel_north.add(Main_Back, BorderLayout.WEST);
		
		panel_1 = new JPanel();
		panel_north.add(panel_1, BorderLayout.CENTER);
		
		glue = Box.createGlue();
		panel_1.add(glue);
		
		lblMainMenu = new JLabel("Main Menu");
		panel_1.add(lblMainMenu);
		panel.add(panel_center, BorderLayout.CENTER);
		panel.add(panel_south, BorderLayout.SOUTH);
		getContentPane().add(panel);
	}
	public void close(){
		this.setVisible(false);
	}
}
