import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
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
	private JScrollPane scroller;
	private ArrayList <JButton> dogB;
	private User user;
	private DoggieBag dogBagTemp;
	private ArrayList <Integer> dogTemp;
	private Dog dog;
	
	public DoggieBagFrame(User u) {
		user = u;
		dog = new Dog();
		class Back_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameMainFrame = new MainFrame(sendUserData());
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
				
					for (int i = 0; i < dogB.size();i++)
					{
						if (e.getSource() == dogB.get(i))
						{
							dog.setDogID(dogTemp.get(i));
							dog.setDogInfo(dog.getDogID());	
							System.out.println("Action Listener is activiated");
							JFrame frameViewDogInDoggieBagFrame = new ViewDogInDoggieBagFrame(sendUserData(), dog);
							close();
							frameViewDogInDoggieBagFrame.setVisible(true);
						}
					}
					
					}
				
				//rs.get(e.getActionCommand())
				//JFrame frameViewDogInDoggieBagFrame = new ViewDogInDoggieBagFrame();
				//^^ send the integer to view dog in doggie frame
				//then open doggie frame
				
			
		}
		dogImageListener = new createDogImageListener();
		contentPane.add(panel_center, BorderLayout.CENTER);
	}
	public void createDogImages(){
		dogBagTemp = new DoggieBag(user.getEmail());
		dogTemp = dogBagTemp.getDoggieBag();
		dogPanel = new JPanel();
		dogB = new ArrayList <JButton> ();
		dogPanel.setLayout(new GridLayout(0,3));
		scroller = new JScrollPane(dogPanel);
		//scroller.setLayout(new BorderLayout());
		for(int i = 0; i < dogTemp.size(); i++){
			dog.setDogID(dogTemp.get(i));
			dog.setDogInfo(dogTemp.get(i));
			System.out.println(dog.getName());
			JButton dogImage = new JButton(dog.getName());//dog image
			//dogImage.setActionCommand(dogTemp.get(i).toString());
			dogImage.addActionListener(dogImageListener);
			System.out.println(dogTemp.get(i).toString());
			dogB.add(dogImage);
		}
		for(int j = 0; j < dogB.size(); j++)
		{
			dogPanel.add(dogB.get(j));
		}
		panel_center.add(scroller, BorderLayout.CENTER);

	}


	public void close(){
		this.setVisible(false);
	}
	public User sendUserData(){
		return this.user;
	}
}
