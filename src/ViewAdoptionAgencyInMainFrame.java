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

import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.Font;
import java.sql.ResultSet;

public class ViewAdoptionAgencyInMainFrame extends JFrame {

	private JPanel contentPane;
	private User user;
	private ActionListener backListener;
	private Dog dog;
	public ViewAdoptionAgencyInMainFrame(Dog d) {
		class createBackListener implements ActionListener{

			public void actionPerformed(ActionEvent e){
				JFrame frameMainFrame = new ViewDoginMainFrame(sendUserData());
				close();
				frameMainFrame.setVisible(true);
				frameMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}

		backListener = new createBackListener();
		dog = d;
		UniversalDogDB db = new UniversalDogDB();
		String q = "Select AGENCY_NAME from ADOPTION_AGENCY where ID = " + Integer.parseInt(dog.getShelter());
		db.retrieveData(q);
		ResultSet rs = db.getResultSet();
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		Panel northPanel_West = new Panel();
		northPanel.add(northPanel_West, BorderLayout.WEST);
		
		JButton button = new JButton("<--");
		northPanel_West.add(button);
		
		Panel northPanel_Center = new Panel();
		northPanel.add(northPanel_Center, BorderLayout.CENTER);
		
		JLabel lblAdoptionAgencyInfo = new JLabel("Adoption Agency Information:");
		lblAdoptionAgencyInfo.setHorizontalAlignment(SwingConstants.CENTER);
		northPanel_Center.add(lblAdoptionAgencyInfo);
		
		Panel centerPanel = new Panel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel agencyNameLabel = new JLabel("Agency Name:");
		agencyNameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		centerPanel.add(agencyNameLabel);
		
		JLabel agencyName = new JLabel("");
		centerPanel.add(agencyName);
		
		JLabel agencyLocationLabel = new JLabel("Agency Location:");
		agencyLocationLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		centerPanel.add(agencyLocationLabel);
		
		JLabel agencyLocation = new JLabel("");
		centerPanel.add(agencyLocation);
		
		JLabel agencyWebsiteLabel = new JLabel("Agency Website:");
		agencyWebsiteLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		centerPanel.add(agencyWebsiteLabel);
		
		JLabel agencyWebsite = new JLabel("");
		centerPanel.add(agencyWebsite);
		
		JLabel agencyPhoneNumberLabel = new JLabel("Agency Phone Number:");
		agencyPhoneNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		centerPanel.add(agencyPhoneNumberLabel);
		
		JLabel agencyphonenumber = new JLabel("");
		centerPanel.add(agencyphonenumber);
		
		JLabel agencyEmailLabel = new JLabel("Agency Email:");
		agencyEmailLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		centerPanel.add(agencyEmailLabel);
		
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
