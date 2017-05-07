


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class ViewDogInDoggieBagFrame extends JFrame {

	private JPanel contentPane;
	private User user;
	private ActionListener backListener;
	private Dog dog;
	
	public ViewDogInDoggieBagFrame(User u, Dog d) {
		user = u;
		dog = d;
		class createBackListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JFrame frameDoggieBagFrame = new DoggieBagFrame(sendUserData());
				close();
				frameDoggieBagFrame.setVisible(true);
			}
		}
		backListener = new createBackListener();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel centerNorthPanel = new JPanel();
		centerPanel.add(centerNorthPanel, BorderLayout.NORTH);
		centerNorthPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel iamgeLabel = new JLabel(d.getPicture()); /*Image file here*/
		centerNorthPanel.add(iamgeLabel);
		
		JLabel nameLabel = new JLabel("Name:" + dog.getName());/*Name of Dog here*/
		centerNorthPanel.add(nameLabel);
		
		JLabel breedLabel = new JLabel("Breed:" + dog.getBreed());/*Breed of Dog here*/
		centerNorthPanel.add(breedLabel);
		
		JLabel locationLabel = new JLabel("Location:");/*Location of Dog here*/
		centerNorthPanel.add(locationLabel);
		
		JLabel ageLabel = new JLabel("Age:" + dog.getAge()); /*Age of the dog goes here*/
		centerNorthPanel.add(ageLabel);
		
		JPanel centerCenterPanel = new JPanel();
		centerPanel.add(centerCenterPanel);
		
		JTextArea textArea = new JTextArea(dog.getDescription());/*Info of Dog here*/
		centerCenterPanel.add(textArea);
		
		JPanel southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel southPanelPanel1 = new JPanel();
		southPanel.add(southPanelPanel1);
		
		JButton deleteButton = new JButton("Delete");
		southPanelPanel1.add(deleteButton);
		

		JLabel lblTindogLogo = new JLabel(new ImageIcon("https://mystjohns-my.sharepoint.com/personal/skrotzkn_stjohns_edu/_layouts/15/guestaccess.aspx?docid=119b16a04c6ce43d084d5663bd04b7cb7&authkey=AbKFbF4aT252NwtJ6CCQ2ic"));
		JPanel southPanelPanel2 = new JPanel();
		southPanelPanel2.add(lblTindogLogo);//FIX THIS JOE
		southPanel.add(southPanelPanel2);

		
		JLabel tindogImageLabel = new JLabel(new ImageIcon("C:\\Users\\jde674\\Documents\\GitHub\\Tindog\\TinDog Logo.png"));
		southPanelPanel2.add(tindogImageLabel);
		
		JPanel southPanelPanel3 = new JPanel();
		southPanel.add(southPanelPanel3);
		
		JButton viewAdoptionInformationButton = new JButton("View Adoption Information");
		southPanelPanel3.add(viewAdoptionInformationButton);
		
		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel northPanelPanel1 = new JPanel();
		FlowLayout fl_northPanelPanel1 = (FlowLayout) northPanelPanel1.getLayout();
		fl_northPanelPanel1.setAlignment(FlowLayout.LEFT);
		northPanel.add(northPanelPanel1);
		
		JButton backButton = new JButton("<--");
		northPanelPanel1.add(backButton);
		backButton.addActionListener(backListener);
	}
	public void close() {
		this.setVisible(false);
	}
	private User sendUserData(){
		return this.user;
	}

}
