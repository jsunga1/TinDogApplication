import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class HelpFrame extends JFrame{

	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;
	
	private JLabel Help;
	private JLabel HM;
	private JButton Back;
	
	private ActionListener backlistener;
	
	private JPanel panel;
	private JPanel panel_center;
	private JPanel panel_north;
	private JPanel panel_north_west;
	private JPanel panel_north_center;
	
	
	
	
	public HelpFrame(){
		
		class Back_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				//JFrame frameMainFrame = new MainFrame();
				//close();
				//frameMainFrame.setVisible(true);
				//frameMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		}

		backlistener = new Back_Listener();

		
		createcosa();
		Back.addActionListener(backlistener);
		
		createpanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
	}
	public void createcosa(){
		Help = new JLabel("HELP");
		HM = new JLabel("You want help\n"
				+ "you came to the right place\n"
				+ "if you see a word on a button, that's what the button is for\n"
				+ "if you see a word next to a box, the box is for that word, you need to put infomation in th box.\n"
				+ "you dont want that dog click the red X\n"
				+ "you want that dog click the check\n"
				+ "you wanna adopt dog go to viewadoption information, they will tell you\n");
		Back = new JButton("<--");
	}
	public void createpanel(){
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel_center = new JPanel();
		panel_center.add(HM);
		panel_north = new JPanel();
		panel_north.setLayout(new BorderLayout());
		panel_north_west = new JPanel();
		panel_north_west.add(Back);
		panel_north_center = new JPanel();
		panel_north_center.add(Help);
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
