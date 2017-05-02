import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class HelpFrame extends JFrame {

	private JPanel contentPane;
	public HelpFrame() {
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
		
		JPanel panel = new JPanel();
		northPanel.add(panel, BorderLayout.CENTER);
		
		JLabel helpTitleLabel = new JLabel("Help");
		panel.add(helpTitleLabel);
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		JLabel helpTextLabel = new JLabel("New label");
		centerPanel.add(helpTextLabel);
	}

}
