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
import java.util.ArrayList;

public class DoggieBagFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel_center;


	private ActionListener backlistener;
	private JPanel dogPanel;

	public DoggieBagFrame() {


		class Back_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameMainFrame = new MainFrame();
				close();
				frameMainFrame.setVisible(true);
				frameMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			}
		}


		backlistener = new Back_Listener();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));

		JPanel northPanel_west = new JPanel();
		northPanel.add(northPanel_west, BorderLayout.WEST);

		JButton button_Back = new JButton("<--");
		northPanel_west.add(button_Back);
		button_Back.addActionListener(backlistener);

		JPanel northPanel_center = new JPanel();
		northPanel.add(northPanel_center, BorderLayout.CENTER);

		JLabel lblDoggieBag = new JLabel("Doggie Bag");
		northPanel_center.add(lblDoggieBag);

		JPanel northPanel_east = new JPanel();
		northPanel.add(northPanel_east, BorderLayout.EAST);

		JLabel lblNewLabel = new JLabel("New label");
		northPanel_east.add(lblNewLabel);

		JPanel northPanel_south = new JPanel();
		northPanel.add(northPanel_south, BorderLayout.SOUTH);

		JButton btnFilter = new JButton("Filter");
		northPanel_south.add(btnFilter);

		panel_center = new JPanel();
		createDogImages();
		panel_center.add(dogPanel);
		contentPane.add(panel_center, BorderLayout.CENTER);
	}
	public void createDogImages(){
		ArrayList <Dog> dogTemp = new ArrayList<Dog>();
		for(Dog i: dogTemp){
			dogPanel = new JPanel();
			dogPanel.setLayout(new GridLayout(0,0,2,0));
			JLabel dogImage = new JLabel();//dog image
			JLabel dogName = new JLabel();//dog name
			dogPanel.add(dogImage);
			dogPanel.add(dogName);
		}
	}


	public void close(){
		this.setVisible(false);
	}

}
