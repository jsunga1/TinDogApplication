import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class AboutFrame extends JFrame{

	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;
	
	private JLabel aboutTitleLabel;
	private JLabel aboutInfoLabel;
	private JButton backButton;
	
	private ActionListener backlistener;
	
	private JPanel panel;
	private JPanel centerPanel;
	private JPanel northPanel;
	private JPanel northCenterPanel;
	private User user;
	
	
	
	public AboutFrame(User u){
		user = u;
		class Back_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameSettingsFrame = new SettingsFrame(sendUserData());
				close();
				frameSettingsFrame.setVisible(true);
				frameSettingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			}
		}

		backlistener = new Back_Listener();

		
		createcosa();
		backButton.addActionListener(backlistener);
		
		createpanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
	}
	public void createcosa(){
		aboutTitleLabel = new JLabel("About");
		aboutInfoLabel = new JLabel("");
	}
	public void createpanel(){
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		centerPanel = new JPanel();
		centerPanel.add(aboutInfoLabel);
		northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		northCenterPanel = new JPanel();
		northCenterPanel.add(aboutTitleLabel);
		backButton = new JButton("<--");
		northPanel.add(backButton, BorderLayout.WEST);
		northPanel.add(northCenterPanel, BorderLayout.CENTER);
		panel.add(northPanel, BorderLayout.NORTH);
		panel.add(centerPanel, BorderLayout.CENTER);
		getContentPane().add(panel);
		
	}
	public void close(){
		this.setVisible(false);
	}
	private User sendUserData(){
		return this.user;
	}
}
