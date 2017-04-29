import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.util.ArrayList;

public class DoggieBagFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	/**
	 * Create the frame.
	 */
	public DoggieBagFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		northPanel.add(panel_1, BorderLayout.WEST);
		
		JButton button = new JButton("<--");
		panel_1.add(button);
		
		JPanel panel_2 = new JPanel();
		northPanel.add(panel_2, BorderLayout.CENTER);
		
		JLabel lblDoggieBag = new JLabel("Doggie Bag");
		panel_2.add(lblDoggieBag);
		
		JPanel panel_3 = new JPanel();
		northPanel.add(panel_3, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_3.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		northPanel.add(panel_4, BorderLayout.SOUTH);
		
		JButton btnFilter = new JButton("Filter");
		panel_4.add(btnFilter);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
	}
	public void createDogImages(){
		ArrayList <Dog> dogTemp = new ArrayList<Dog>();
		for(Dog i: dogTemp){
			JPanel dogPanel = new JPanel();
			dogPanel.setLayout(new GridLayout(0,0,2,0));
			JLabel dogImage = new JLabel();//dog image
			JLabel dogName = new JLabel();//dog name
			dogPanel.add(dogImage);
			dogPanel.add(dogName);
		}
	}
}
