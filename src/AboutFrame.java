import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class AboutFrame extends JFrame{

	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;
	
	private JLabel About;
	private JLabel AM;
	private JButton Back;
	
	private ActionListener backlistener;
	
	private JPanel panel;
	private JPanel panel_center;
	private JPanel panel_north;
	private JPanel panel_north_west;
	private JPanel panel_north_center;
	
	
	
	
	public AboutFrame(){
		
		class Back_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameSettingsFrame = new SettingsFrame();
				close();
				frameSettingsFrame.setVisible(true);
				frameSettingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			}
		}

		backlistener = new Back_Listener();

		
		createcosa();
		Back.addActionListener(backlistener);
		
		createpanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
	}
	public void createcosa(){
		About = new JLabel("ABOUT");
		AM = new JLabel("YOu want dog, we give them to you\n"
				+ "we got all kinds of dogs\n"
				+ "dog places give us dogs to sell\n"
				+ "you but them\n"
				+ "doggie doggie doggie");
		Back = new JButton("<--");
	}
	public void createpanel(){
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel_center = new JPanel();
		panel_center.add(AM);
		panel_north = new JPanel();
		panel_north.setLayout(new BorderLayout());
		panel_north_west = new JPanel();
		panel_north_west.add(Back);
		panel_north_center = new JPanel();
		panel_north_center.add(About);
		panel_north.add(panel_north_west, BorderLayout.WEST);
		panel_north.add(panel_north_center, BorderLayout.CENTER);
		panel.add(panel_north, BorderLayout.NORTH);
		panel.add(panel_center, BorderLayout.CENTER);
		add(panel);
		
	}
	public void close(){
		this.setVisible(false);
	}
		
}
