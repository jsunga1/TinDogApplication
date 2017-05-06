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
	private ActionListener dogImageListener;
	private JPanel dogPanel;
	private User user;
	private DoggieBag dogBagTemp;
	private ArrayList <Integer> dogTemp;
	
	public DoggieBagFrame(User u) {
		user = u;
		class Back_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameMainFrame = new MainFrame(sendUserData());
				close();
				frameMainFrame.setVisible(true);
				frameMainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}

		backlistener = new Back_Listener();
		
		for(Integer i: dogTemp){
			
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
				JButton button_Back = new JButton("<--");
				northPanel.add(button_Back, BorderLayout.WEST);
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
		panel_center.setLayout(new GridLayout(0, 3, 0, 0));
		createDogImages();
		class createDogImageListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				/*for(Integer i: dogTemp){
					if(i.toString().equals(e.getActionCommand())){
						JFrame frameViewDogInDoggieBagFrame = new ViewDogInDoggieBagFrame();
					}
				}*/
				//rs.get(e.getActionCommand())
				//JFrame frameViewDogInDoggieBagFrame = new ViewDogInDoggieBagFrame();
				//^^ send the integer to view dog in doggie frame
				//then open doggie frame
				
			}
		}
		dogImageListener = new createDogImageListener();
		contentPane.add(panel_center, BorderLayout.CENTER);
	}
	public void createDogImages(){
		dogBagTemp = new DoggieBag(user.getEmail());
		dogTemp = dogBagTemp.getDoggieBag();
		dogPanel = new JPanel();
		for(Integer i: dogTemp){
			dogPanel.setLayout(new GridLayout(0,0,2,0));
			JButton dogImage = new JButton();//dog image
			dogImage.setActionCommand(i.toString());
			JLabel dogName = new JLabel();//dog name
			dogPanel.add(dogImage);
			dogPanel.add(dogName);
			panel_center.add(dogPanel);
		}
	}


	public void close(){
		this.setVisible(false);
	}
	public User sendUserData(){
		return this.user;
	}
}
