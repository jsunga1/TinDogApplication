import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.*;

public class DogListFrame extends JFrame {

	private JPanel contentPane;
	private JLabel dogImageLabel;
	private JLabel dogNameLabel;
	private ActionListener mainMenubtnListener;
	private ActionListener filterbtnListener;
	private ActionListener viewInfobtnListener;
	private ActionListener xMarkListener;
	private URL dogPhoto;
	private Image photo;
	private Dog dog;
	private DogPile dp;
	private User user;
	private ActionListener checkListener;
	private JLabel lblDogImage;
  
	public DogListFrame(User u) throws IOException {
		user = u;
		dogImageLabel = new JLabel();
		dogNameLabel = new JLabel();
		class mainMenuListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameMainMenuFrame = new MainFrame(sendUserData());
				close();
				frameMainMenuFrame.setVisible(true);
				frameMainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		class filterListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameFilterFrame = new FilterFrame(user);
				close();
				frameFilterFrame.setVisible(true);
				frameFilterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		class viewInfoListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if (dp.getDogPileArray().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Dog Information is not available");
				}
				else
				{
					JFrame frameViewDogInMainFrameFrame = new ViewDoginMainFrame(user);
					close();
					frameViewDogInMainFrameFrame.setVisible(true);
					frameViewDogInMainFrameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
		}

		class createXMarkListener implements ActionListener{
			public void actionPerformed(ActionEvent e)
			{
				UniversalDogDB db = new UniversalDogDB();
				
				if (dp.getDogPileArray().isEmpty())
				{
					dog.setDogName("Sorry, No More Dogs are available");
					dog.setPhotoLink("https://mystjohns-my.sharepoint.com/personal/skrotzkn_stjohns_edu/_layouts/15/guestaccess.aspx?docid=10d25d7e04315415a8caca5f855b7403e&authkey=AVAO6rh74CPhzTMZY5WLaTQ");
					try {
						dogPhoto = new URL(dog.getPicture());
						photo = ImageIO.read(dogPhoto).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
						dogImageLabel.setIcon(new ImageIcon(photo));
						dogNameLabel.setText(dog.getName());
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else
				{
					dp.removeHeadDog();
					if (dp.getDogPileArray().isEmpty())
					{
						dog.setDogName("Sorry, No More Dogs are available");
						dog.setPhotoLink("https://mystjohns-my.sharepoint.com/personal/skrotzkn_stjohns_edu/_layouts/15/guestaccess.aspx?docid=10d25d7e04315415a8caca5f855b7403e&authkey=AVAO6rh74CPhzTMZY5WLaTQ");
						try {
							dogPhoto = new URL(dog.getPicture());
							photo = ImageIO.read(dogPhoto).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
							dogImageLabel.setIcon(new ImageIcon(photo));
							dogNameLabel.setText(dog.getName());
						} catch (MalformedURLException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					else
					{
						dp.getHeadDog();
						int d = dp.getCurrentPosition();
						
						dog.setDogID(d);
						dog.setDogInfo(d);
						
						try {
							dogPhoto = new URL(dog.getPicture());
							photo = ImageIO.read(dogPhoto).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
							dogImageLabel.setIcon(new ImageIcon(photo));
							dogNameLabel.setText(dog.getName()); //change this for next dog
						} catch (MalformedURLException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
				
			}
		}
		class createCheckListener implements ActionListener{
			public void actionPerformed(ActionEvent e)
			{
				UniversalDogDB db = new UniversalDogDB();
				
				if (dp.getDogPileArray().isEmpty())
				{
					dog.setDogName("Sorry, No More Dogs are available");
					dog.setPhotoLink("https://mystjohns-my.sharepoint.com/personal/skrotzkn_stjohns_edu/_layouts/15/guestaccess.aspx?docid=10d25d7e04315415a8caca5f855b7403e&authkey=AVAO6rh74CPhzTMZY5WLaTQ");
					try {
						dogPhoto = new URL(dog.getPicture());
						photo = ImageIO.read(dogPhoto).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
						dogImageLabel.setIcon(new ImageIcon(photo));
						dogNameLabel.setText(dog.getName());
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else
				{
					dog.addDogToDoggieBag(user.getEmail());
					
					dp.removeHeadDog();
					if (dp.getDogPileArray().isEmpty())
					{
						dog.setDogName("Sorry, No More Dogs are available");
						dog.setPhotoLink("https://mystjohns-my.sharepoint.com/personal/skrotzkn_stjohns_edu/_layouts/15/guestaccess.aspx?docid=10d25d7e04315415a8caca5f855b7403e&authkey=AVAO6rh74CPhzTMZY5WLaTQ");
						try {
							dogPhoto = new URL(dog.getPicture());
							photo = ImageIO.read(dogPhoto).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
							dogImageLabel.setIcon(new ImageIcon(photo));
							dogNameLabel.setText(dog.getName());
						} catch (MalformedURLException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					else
					{	
						dp.getHeadDog();
						int d = dp.getCurrentPosition();
						
						dog.setDogID(d);
						dog.setDogInfo(d);
						
						try {
							dogPhoto = new URL(dog.getPicture());
							photo = ImageIO.read(dogPhoto).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
							dogImageLabel.setIcon(new ImageIcon(photo));
							dogNameLabel.setText(dog.getName());
						} catch (MalformedURLException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		}
		
		dog = new Dog();
		dp = user.getDogPile();
		if (dp.getDogPileArray().isEmpty())
		{
			dog.setDogName("Sorry, No More Dogs are available");
			dog.setPhotoLink("https://mystjohns-my.sharepoint.com/personal/skrotzkn_stjohns_edu/_layouts/15/guestaccess.aspx?docid=10d25d7e04315415a8caca5f855b7403e&authkey=AVAO6rh74CPhzTMZY5WLaTQ");
			try {
				dogPhoto = new URL(dog.getPicture());
				photo = ImageIO.read(dogPhoto).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
				dogImageLabel.setIcon(new ImageIcon(photo));
				dogNameLabel.setText(dog.getName());
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else
		{
			int i = dp.getCurrentPosition();
			dog.setDogID(i);
			dog.setDogInfo(i);
		}

		xMarkListener = new createXMarkListener();
		checkListener = new createCheckListener();
		mainMenubtnListener = new mainMenuListener();
		filterbtnListener = new filterListener();
		viewInfobtnListener = new viewInfoListener();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel northPanelPanel1 = new JPanel();
		northPanel.add(northPanelPanel1);
		northPanelPanel1.setLayout(new BorderLayout(0, 0));
		
		JButton mainMenuButton = new JButton("Main Menu");
		northPanelPanel1.add(mainMenuButton, BorderLayout.WEST);
		mainMenuButton.addActionListener(mainMenubtnListener);
		
		JPanel northPanelPanel2 = new JPanel();
		northPanel.add(northPanelPanel2);
		northPanelPanel2.setLayout(new BorderLayout(0, 0));
		
		JButton FilterButton = new JButton("Filter");
		northPanelPanel2.add(FilterButton, BorderLayout.EAST);
		FilterButton.addActionListener(filterbtnListener);
		
		JPanel southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel southPanelPanel1 = new JPanel();
		southPanel.add(southPanelPanel1);
		
		JButton xButton = new JButton("✖");
		southPanelPanel1.add(xButton);
		xButton.addActionListener(xMarkListener);
		JPanel southPanelPanel2 = new JPanel();
		southPanel.add(southPanelPanel2);
		
		JLabel tinDogLogLabel = new JLabel(new ImageIcon("https://mystjohns-my.sharepoint.com/personal/skrotzkn_stjohns_edu/_layouts/15/guestaccess.aspx?docid=119b16a04c6ce43d084d5663bd04b7cb7&authkey=AbKFbF4aT252NwtJ6CCQ2ic"));//TinDog logo
		southPanelPanel2.add(tinDogLogLabel);
		
		JPanel southPanelPanel3 = new JPanel();
		southPanel.add(southPanelPanel3);
		
		JButton button_checkmark = new JButton("✔");
		JPanel panel_south_checkmark = new JPanel();
		panel_south_checkmark.add(button_checkmark);
		button_checkmark.addActionListener(checkListener);
		southPanel.add(panel_south_checkmark);
		
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel centerCenterPanel = new JPanel();
		centerPanel.add(centerCenterPanel, BorderLayout.CENTER);
		

		dogPhoto = new URL(dog.getPicture());

		photo = ImageIO.read(dogPhoto).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		centerCenterPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		centerCenterPanel.add(panel, BorderLayout.CENTER);
		dogImageLabel.setIcon(new ImageIcon(photo));
		panel.add(dogImageLabel);
		
		dogImageLabel.setIcon(new ImageIcon(photo));
		
		JPanel centerCenterSouthPanel = new JPanel();
		centerCenterPanel.add(centerCenterSouthPanel, BorderLayout.SOUTH);
		
		dogNameLabel.setText(dog.getName());
		centerCenterSouthPanel.add(dogNameLabel);
		
		JPanel centerSouthPanel = new JPanel();
		centerPanel.add(centerSouthPanel, BorderLayout.SOUTH);
		centerSouthPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel centerSouthPanelPanel1= new JPanel();
		centerSouthPanel.add(centerSouthPanelPanel1);
		
		JButton viewMoreInformationButton = new JButton("View More Information");
		centerSouthPanelPanel1.add(viewMoreInformationButton);
		viewMoreInformationButton.addActionListener(viewInfobtnListener);
	}
	public void close(){
		this.setVisible(false);
	}
	private User sendUserData(){
		return this.user;
	}
}
