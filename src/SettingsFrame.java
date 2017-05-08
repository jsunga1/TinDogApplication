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
import javax.swing.JOptionPane;

public class SettingsFrame extends JFrame {

	private JPanel contentPane; 
	private ActionListener backListener;
	private ActionListener aboutListener;
	private ActionListener editAccountListener;
	private ActionListener logoutListener;
	private ActionListener deleteListener;
	private User user;

	public SettingsFrame(User u) {
		user = u;
		class createBackListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameMainFrame = new MainFrame(sendUserData());
				close();
				frameMainFrame.setVisible(true);
				frameMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		class createAboutListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JFrame frameAboutFrame = new AboutFrame(sendUserData());
				close();
				frameAboutFrame.setVisible(true);
				frameAboutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		class createEditAccountListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JFrame frameEditUserFrame = new EditUserFrame(sendUserData());
				close();
				frameEditUserFrame.setVisible(true);
				frameEditUserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}

		}
		class createLogoutListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameStartFrame = new StartFrame();
				close();
				frameStartFrame.setVisible(true);
				frameStartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		class createDeleteListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				
				String response = JOptionPane.showInputDialog("Are you sure you want to delete your account?\nEnter Yes or No");
				if (response.equalsIgnoreCase("yes"))
				{
					user.deleteUser();
					JFrame frameStartFrame = new StartFrame();
					close();
					frameStartFrame.setVisible(true);
					frameStartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				
			}
		}
		backListener = new createBackListener();
		aboutListener = new createAboutListener();
		editAccountListener = new createEditAccountListener();
		logoutListener = new createLogoutListener();
		deleteListener = new createDeleteListener();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));

		JButton backButton = new JButton("<--");
		northPanel.add(backButton, BorderLayout.WEST);
		backButton.addActionListener(backListener);
		JPanel northCenterPanel = new JPanel();
		northPanel.add(northCenterPanel, BorderLayout.CENTER);

		JLabel settingsTitleLabel = new JLabel("Settings");
		northCenterPanel.add(settingsTitleLabel);

		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JButton aboutButton = new JButton("About");
		centerPanel.add(aboutButton);
		aboutButton.addActionListener(aboutListener);
		JButton editAccountButton = new JButton("Edit Account");
		centerPanel.add(editAccountButton);
		editAccountButton.addActionListener(editAccountListener);
		JButton logOutButton = new JButton("Logout");
		centerPanel.add(logOutButton);
		logOutButton.addActionListener(logoutListener);
		JButton deleteAccountButton = new JButton("Delete Account");
		centerPanel.add(deleteAccountButton);
		deleteAccountButton.addActionListener(deleteListener);
	}
	public void close() {
		this.setVisible(false);
	} 
	public User sendUserData(){
		return this.user;
	}
}
