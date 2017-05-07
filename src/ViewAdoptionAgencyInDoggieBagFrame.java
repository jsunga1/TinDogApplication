import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;

public class ViewAdoptionAgencyInDoggieBagFrame extends JFrame {

	private JPanel contentPane;
	private User user;
	private Dog dog;
	private Shelter shelter;
	private ActionListener backListener;

	public ViewAdoptionAgencyInDoggieBagFrame(Dog d, User u) {
		user = u;
		class createBackListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameMainFrame = new ViewDogInDoggieBagFrame(sendUserData(), dog);
				close();
				frameMainFrame.setVisible(true);
				frameMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}

		dog = d;
		shelter = new Shelter();
		shelter.setShelterInfo(Long.parseLong(dog.getShelter()));
		
		UniversalDogDB db = new UniversalDogDB();
		String q = "";
		db.retrieveData(q);
		

		backListener = new createBackListener();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		JButton backButton = new JButton("<--");
		northPanel.add(backButton, BorderLayout.WEST);
		backButton.addActionListener(backListener);
		Panel northCenterPanel = new Panel();
		northPanel.add(northCenterPanel, BorderLayout.CENTER);
		
		JLabel adoptionAgencyInformationTitleLabel = new JLabel("Adoption Agency Information:");
		adoptionAgencyInformationTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		northCenterPanel.add(adoptionAgencyInformationTitleLabel);
		
		Panel centerPanel = new Panel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(0, 1, 0, 0));
		 
		JLabel agencyNameLabel = new JLabel("Agency Name: " + shelter.getName());
		agencyNameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		centerPanel.add(agencyNameLabel);
		
		JLabel agencyName = new JLabel("");
		centerPanel.add(agencyName);
		
		JLabel agencyLocationLabel = new JLabel("Agency Location: " + shelter.getAddress());
		agencyLocationLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		centerPanel.add(agencyLocationLabel);
		
		JLabel agencyLocation = new JLabel("");
		centerPanel.add(agencyLocation);
		
		JLabel agencyWebsiteLabel = new JLabel("Agency Website: " + shelter.getLink());
		agencyWebsiteLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		centerPanel.add(agencyWebsiteLabel);
		
		JLabel agencyWebsite = new JLabel("");
		centerPanel.add(agencyWebsite);
		
		JLabel agencyPhoneNumberLabel = new JLabel("Agency Phone Number: " + shelter.getPhone());
		agencyPhoneNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		centerPanel.add(agencyPhoneNumberLabel);
		
		JLabel agencyphonenumber = new JLabel("");
		centerPanel.add(agencyphonenumber);
		
		JLabel agencyEmailLabel = new JLabel("Agency Email: " + shelter.getEmail());
		agencyEmailLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		centerPanel.add(agencyEmailLabel);
		

		
		
		Panel southPanel = new Panel();
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		JLabel tinDogLogLabel = new JLabel(new ImageIcon("https://mystjohns-my.sharepoint.com/personal/skrotzkn_stjohns_edu/_layouts/15/guestaccess.aspx?docid=119b16a04c6ce43d084d5663bd04b7cb7&authkey=AbKFbF4aT252NwtJ6CCQ2ic"));//TinDog logo
		southPanel.add(tinDogLogLabel);

		JLabel agencyEmail = new JLabel("");
		centerPanel.add(agencyEmail);

	}
	public void close(){
		this.setVisible(false);
	}
	public User sendUserData(){
		return this.user;
	}

}
