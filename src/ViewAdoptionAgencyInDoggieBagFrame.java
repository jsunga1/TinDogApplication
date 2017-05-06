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

public class ViewAdoptionAgencyInDoggieBagFrame extends JFrame {

	private JPanel contentPane;
	private User user;
	private ActionListener backlistner;
	
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAdoptionAgencyInDoggieBagFrame frame = new ViewAdoptionAgencyInDoggieBagFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public ViewAdoptionAgencyInDoggieBagFrame() {
		class Back_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameMainFrame = new ViewDogInDoggieBagFrame(sendUserData());
				close();
				frameMainFrame.setVisible(true);
				frameMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
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
		
		Panel panel_Center = new Panel();
		contentPane.add(panel_Center, BorderLayout.CENTER);
		panel_Center.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblAgencyName = new JLabel("Agency Name:");
		lblAgencyName.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_Center.add(lblAgencyName);
		
		JLabel AgencyName = new JLabel("");
		panel_Center.add(AgencyName);
		
		JLabel lblAgencyLocation = new JLabel("Agency Location:");
		lblAgencyLocation.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_Center.add(lblAgencyLocation);
		
		JLabel AgencyLocation = new JLabel("");
		panel_Center.add(AgencyLocation);
		
		JLabel lblAgencyWebsite = new JLabel("Agency Website:");
		lblAgencyWebsite.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_Center.add(lblAgencyWebsite);
		
		JLabel AgencyWebsite = new JLabel("");
		panel_Center.add(AgencyWebsite);
		
		JLabel lblAgencyPhoneNumber = new JLabel("Agency Phone Number:");
		lblAgencyPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_Center.add(lblAgencyPhoneNumber);
		
		JLabel Agencyphonenumber = new JLabel("");
		panel_Center.add(Agencyphonenumber);
		
		JLabel lblAgencyEmail = new JLabel("Agency Email:");
		lblAgencyEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_Center.add(lblAgencyEmail);
		
		JLabel AgencyEmail = new JLabel("");
		panel_Center.add(AgencyEmail);
	}
	public void close(){
		this.setVisible(false);
	}
	public User sendUserData(){
		return this.user;
	}

}
