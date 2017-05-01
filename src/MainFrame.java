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

public class MainFrame extends JFrame {

	private JPanel contentPane;

	
	public MainFrame() {
		class createBackListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
				try{
				JFrame frameDogListFrame = new DogListFrame();
				close();
				frameDogListFrame.setVisible(true);
				frameDogListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}catch(Exception dogListFrame){
					System.out.println(dogListFrame);
				}
			}
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout(0, 0));
		
		JButton btnBack = new JButton("<--");
		panelNorth.add(btnBack, BorderLayout.WEST);
		
		JPanel panelNorthCenter = new JPanel();
		panelNorth.add(panelNorthCenter, BorderLayout.CENTER);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		panelNorthCenter.add(lblMainMenu);
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnViewDoggieBag = new JButton("View Doggie Bag");
		panelCenter.add(btnViewDoggieBag);
		
		JButton btnSettings = new JButton("Settings");
		panelCenter.add(btnSettings);
		
		JButton btnHelp = new JButton("Help");
		panelCenter.add(btnHelp);
	}
	public void close(){
		this.setVisible(false);
	}
}
