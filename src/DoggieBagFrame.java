import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.Scanner;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;



public class DoggieBagFrame extends JFrame
{
	private JPanel contentPane;
	private JPanel centerPanel;
	private JPanel dogPanel;
	private JLabel dogImageLabel;
	private ActionListener backlistener;
	private ActionListener dogListener;
	private ActionListener boxListener;

	private User user;
	private Dog dog;
	private Dog dog1;
	private DoggieBag dogBagTemp;
	private ArrayList <Integer> dogTemp;
	private JComboBox box;
	private URL dogPhoto;
	public Image photo;
	
	public DoggieBagFrame(User u)
	{
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
		
		class createDogListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				if (dogBagTemp.getDoggieBag().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Sorry, there are no dogs to view!");

				}
				else
				{
					String boxInfo;
					boxInfo = (String)box.getSelectedItem();//needs to find which do it is from dog name
					Scanner input = new Scanner(boxInfo);
					input.next();
					int temp = input.nextInt();
					System.out.println(temp);
					dog.setDogID(temp); 
					dog.setDogInfo(temp);
					JFrame frameVDIDBF = new ViewDogInDoggieBagFrame(sendUserData(), dog);
					close();
					frameVDIDBF.setVisible(true);
					frameVDIDBF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
		}
		class createBoxListener implements ActionListener{
			

			public void actionPerformed(ActionEvent e){
				if (dogBagTemp.getDoggieBag().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Sorry, there are no dogs to view!");
				}
				else
				{
					String boxInfo;
					boxInfo = (String)box.getSelectedItem();//needs to find which do it is from dog name
					Scanner input = new Scanner(boxInfo);
					input.next();
					int temp = input.nextInt();
					System.out.println(temp);
					dog1.setDogID(temp); 
					dog1.setDogInfo(temp);
					try{
						dogPhoto = new URL(dog1.getPicture());
						photo = ImageIO.read(dogPhoto).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
						dogImageLabel.setIcon(new ImageIcon(photo));
						
					}catch (MalformedURLException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		backlistener = new Back_Listener();
		dogListener = new createDogListener();
		boxListener = new createBoxListener();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
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

		JPanel northPanel_south = new JPanel();
		northPanel.add(northPanel_south, BorderLayout.SOUTH);

		
		centerPanel = new JPanel();//add combobox here
		centerPanel.setLayout(new BorderLayout());
		
		JPanel selectionPanel = new JPanel();
		selectionPanel.setLayout(new GridLayout(0,1));
		createBox();
		selectionPanel.add(box);
		box.addActionListener(boxListener);
		dog1 = new Dog();
		if (dogBagTemp.getDoggieBag().isEmpty())
			dog1 = dog;
		else
			dog1.setDogInfo(dogBagTemp.getDoggieBag().get(0));
		
		try {
			dogPhoto = new URL(dog1.getPicture());
			photo = ImageIO.read(dogPhoto).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			dogImageLabel = new JLabel(new ImageIcon(photo));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		selectionPanel.add(dogImageLabel);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(dogListener);
		centerPanel.add(submitButton, BorderLayout.SOUTH);
		centerPanel.add(selectionPanel, BorderLayout.CENTER);

		contentPane.add(centerPanel, BorderLayout.CENTER);
	}
	


	public void createBox()
	{
		dogBagTemp = new DoggieBag();
		dogBagTemp.generateDoggieBag(user.getEmail());
		dogTemp = dogBagTemp.getDoggieBag();
		box = new JComboBox();
		if (dogTemp.isEmpty())
		{	
			dog.setDogName("There are no dogs in your DoggieBag!");
			dog.setPhotoLink("https://mystjohns-my.sharepoint.com/personal/skrotzkn_stjohns_edu/_layouts/15/guestaccess.aspx?docid=10d25d7e04315415a8caca5f855b7403e&authkey=AVAO6rh74CPhzTMZY5WLaTQ");
			box.addItem(dog.getName());
		}
		else
		{
			
			for(int i = 0; i < dogTemp.size();i++)
			{
				dog.setDogInfo(dogTemp.get(i));
				box.addItem("ID: " + dog.getDogID() + " Name: " +  dog.getName());
			}
		}
		
	}
	
	public void close(){
		this.setVisible(false);
	}
	public User sendUserData(){
		return this.user;
	}

}
