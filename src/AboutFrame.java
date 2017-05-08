import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Font;

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
	private JTextArea aboutInfoTextBox;
	
	
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
		createpanel();
		backButton.addActionListener(backlistener);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
	}
	public void createcosa(){
		aboutTitleLabel = new JLabel("About");
	}
	public void createpanel(){
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		centerPanel = new JPanel();
		northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		northCenterPanel = new JPanel();
		northCenterPanel.add(aboutTitleLabel);
		backButton = new JButton("<--");
		northPanel.add(backButton, BorderLayout.WEST);
		northPanel.add(northCenterPanel, BorderLayout.CENTER);
		panel.add(northPanel, BorderLayout.NORTH);
		panel.add(centerPanel, BorderLayout.CENTER);
		
		aboutInfoTextBox = new JTextArea();
		aboutInfoTextBox.setFont(new Font("Monospaced", Font.PLAIN, 10));
		aboutInfoTextBox.setEditable(false);
		aboutInfoTextBox.setColumns(1);
		aboutInfoTextBox.setText("Tindog is the app that brings dog-lovers\nand their soon-to-be dogs together.\nTindog provides a service that allows\nits users to search for dogs located\nat shelters and adoption agencies in nearby areas.\nTindog is operated in a style similar to that of the\nwell-known and popular dating app, Tinder.\nUsers are able to flip through a full gallery of\neveryone's favorite furry friends to find the perfect match.\nUsers can find their dream dog without the exhausting\neffort of searching and traveling for hours on end,\nas required when people werefinding dogs in the days of old.");
		centerPanel.add(aboutInfoTextBox);
		aboutInfoLabel = new JLabel("Tindog Version 0.1");
		centerPanel.add(aboutInfoLabel);
		getContentPane().add(panel);
		
	}
	public void close(){
		this.setVisible(false);
	}
	private User sendUserData(){
		return this.user;
	}
}
