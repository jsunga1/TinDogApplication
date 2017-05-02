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

public class SettingsFrame extends JFrame {

	private JPanel contentPane; 
	private ActionListener backListener;
	private ActionListener doggieBagListener;
	public SettingsFrame() {
		class createBackListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameMainFrame = new MainFrame();
				close();
				frameMainFrame.setVisible(true);
				frameMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		
		backListener = new createBackListener();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout(0, 0));
		
		JButton btnBack = new JButton("<--");
		panelNorth.add(btnBack, BorderLayout.WEST);
		btnBack.addActionListener(backListener);
		JPanel panel = new JPanel();
		panelNorth.add(panel, BorderLayout.CENTER);
		
		JLabel lblSettings = new JLabel("Settings");
		panel.add(lblSettings);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnAbout = new JButton("About");
		panel_1.add(btnAbout);
		
		JButton btnEditAccount = new JButton("Edit Account");
		panel_1.add(btnEditAccount);
		
		JButton btnLogOut = new JButton("Logout");
		panel_1.add(btnLogOut);
		
		JButton btnDeleteAcount = new JButton("Delete Account");
		panel_1.add(btnDeleteAcount);
	}
	public void close() {
		this.setVisible(false);
	} 
}
