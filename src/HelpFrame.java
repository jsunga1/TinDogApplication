import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class HelpFrame extends JFrame {

	private JPanel contentPane;
	private User user;
	private ActionListener backListener;
	public HelpFrame(User u) {
		user = u;
		class createBackListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JFrame frameMainFrame = new MainFrame(sendUserData());
				close();
				frameMainFrame.setVisible(true);
			}
		}
		backListener = new createBackListener();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		JButton backButton = new JButton("<--");
		northPanel.add(backButton, BorderLayout.WEST);
		backButton.addActionListener(backListener);
		JPanel panel = new JPanel();
		northPanel.add(panel, BorderLayout.CENTER);
		
		JLabel helpTitleLabel = new JLabel("Help");
		panel.add(helpTitleLabel);
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		JTextArea helpTextBox = new JTextArea("To use Tindog simply select\ncheck-mark or X-mark to choose a dog you would want to adopt.\nYou can view the dog in your doggie bag by\ngoing to the main menu and selecting doggiebag\nIf you want more information about a dog\nyou can click view more information in the search menu\nor the doggiebag.\n\nYou can filter dogs in the search menu or\ndoggie bag by clicking the filter button.\n\nIf you want to change your personal information\nor delete your account you can do that in\nthe settings frame located in the main menu");
		helpTextBox.setFont(new Font("Monospaced", Font.PLAIN, 10));
		centerPanel.add(helpTextBox);
	}
	public void close() {
		this.setVisible(false);
	}
	private User sendUserData(){
		return this.user;
	}
}
