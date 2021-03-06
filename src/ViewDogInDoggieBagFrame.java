import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class ViewDogInDoggieBagFrame extends JFrame
{
	private JPanel contentPane;
	private User user;
	private Dog dog;
	private ActionListener backListener;
	private ActionListener adoptionListener;
	private ActionListener deleteListener;
	private URL dogPhoto;
	private Image photo;
	private URL tinDogPhoto;
	private Image photo2;
	
	
	public ViewDogInDoggieBagFrame(User u, Dog d)
	{
		user = u;
		dog = d;
		System.out.println(dog.getDogID() + dog.getName());
		class createBackListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFrame frameDoggieBagFrame = new DoggieBagFrame(sendUserData());
				close();
				frameDoggieBagFrame.setVisible(true);
			}
		}
		class createAdoptionListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				JFrame frameVAAIDBF = new ViewAdoptionAgencyInDoggieBagFrame(dog, sendUserData());
				close();
				frameVAAIDBF.setVisible(true);
			}
		}
		class createDeleteListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e) 
			{
				user.getDoggieBag().deleteDog(user, dog.getDogID());
				JFrame frameDoggieBagFrame = new DoggieBagFrame(sendUserData());
				close();
				frameDoggieBagFrame.setVisible(true);
			}
		}
		adoptionListener = new createAdoptionListener();
		backListener = new createBackListener();
		deleteListener = new createDeleteListener();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel centerNorthPanel = new JPanel();
		centerPanel.add(centerNorthPanel, BorderLayout.NORTH);
		centerNorthPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		try
		{
			dogPhoto = new URL(dog.getPicture());
			photo = ImageIO.read(dogPhoto).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			JLabel iamgeLabel = new JLabel(new ImageIcon(photo)); /*Image file here*/
			centerNorthPanel.add(iamgeLabel);
		}
		catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JLabel nameLabel = new JLabel("Name:" + dog.getName());
		centerNorthPanel.add(nameLabel);
		
		JLabel breedLabel = new JLabel("Breed:" + dog.getBreed());
		centerNorthPanel.add(breedLabel);
		
		/*JLabel locationLabel = new JLabel(dog.getDescription());
		centerNorthPanel.add(locationLabel);*/
		
		JLabel ageLabel = new JLabel("Age:" + dog.getAge()); 
		centerNorthPanel.add(ageLabel);
		
		JPanel centerCenterPanel = new JPanel();
		centerPanel.add(centerCenterPanel);
		
		JTextArea textArea = new JTextArea(50,50);
		textArea.setText(dog.getDescription());
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		JScrollPane scroller = new JScrollPane(textArea);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		centerCenterPanel.add(scroller);
		
		JPanel southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel southPanelPanel1 = new JPanel();
		southPanel.add(southPanelPanel1);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(deleteListener);
		southPanelPanel1.add(deleteButton);
		
		
		JPanel southPanelPanel3 = new JPanel();
		southPanel.add(southPanelPanel3);
		
		JButton viewAdoptionInformationButton = new JButton("View Adoption Information");
		southPanelPanel3.add(viewAdoptionInformationButton);
		viewAdoptionInformationButton.addActionListener(adoptionListener);
		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel northPanelPanel1 = new JPanel();
		FlowLayout fl_northPanelPanel1 = (FlowLayout) northPanelPanel1.getLayout();
		fl_northPanelPanel1.setAlignment(FlowLayout.LEFT);
		northPanel.add(northPanelPanel1);
		
		JButton backButton = new JButton("<--");
		northPanelPanel1.add(backButton);
		backButton.addActionListener(backListener);
	}
	public void close() {
		this.setVisible(false);
	}
	private User sendUserData(){
		return this.user;
	}

}
