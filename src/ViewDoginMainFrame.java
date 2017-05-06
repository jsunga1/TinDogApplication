import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class ViewDoginMainFrame extends JFrame {

	private JPanel contentPane;
	private ActionListener backbtnListener;
	private User user;
	private ActionListener xMarkListener;
	private ActionListener checkListener;
	private Dog dog;
	private DogPile dp;
	
	/**
	 * Create the frame.
	 */
	public ViewDoginMainFrame(User u) {
		class backListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameDogListFrame;
				try {
					frameDogListFrame = new DogListFrame(sendUserData());
					frameDogListFrame.setVisible(true);
					frameDogListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				close();
				
			}
		}
		
		class createXMarkListener implements ActionListener{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		}
		
		class createCheckListener implements ActionListener{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		}
		
		int dogid = user.getDogPile().getHeadDog();
		dog.setDogInfo(dogid);
		
		xMarkListener = new createXMarkListener();
		checkListener = new createCheckListener();
		
		backbtnListener = new backListener();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel northPanelPanel1 = new JPanel();
		northPanel.add(northPanelPanel1);
		FlowLayout fl_northPanelPanel1 = (FlowLayout) northPanelPanel1.getLayout();
		fl_northPanelPanel1.setAlignment(FlowLayout.LEFT);
		
		JButton backButton = new JButton("<--");
		northPanelPanel1.add(backButton);
		backButton.addActionListener(backbtnListener);
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel centerNorthPanel = new JPanel();
		centerPanel.add(centerNorthPanel, BorderLayout.NORTH);
		centerNorthPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel imageLabel = new JLabel("");
		centerNorthPanel.add(imageLabel);
		
		JLabel nameLabel = new JLabel("Name: " +  dog.getName());
		centerNorthPanel.add(nameLabel);
		
		JLabel breedLabel = new JLabel("Breed: " +  dog.getBreed());
		centerNorthPanel.add(breedLabel);
		
		JLabel locationLabel = new JLabel("Location: " + dog.getShelter());
		centerNorthPanel.add(locationLabel);
		
		JLabel ageLabel = new JLabel("Age: " + dog.getAge());
		centerNorthPanel.add(ageLabel);
		
		JPanel centerCenterPanel = new JPanel();
		centerPanel.add(centerCenterPanel);
		
		JTextArea textArea = new JTextArea();
		centerCenterPanel.add(textArea);
		
		JPanel southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel southPanelPanel1 = new JPanel();
		southPanel.add(southPanelPanel1);
		
		JButton viewAdoptionInformationButton = new JButton("View Adoption Information");
		southPanelPanel1.add(viewAdoptionInformationButton);
		
		JPanel southPanelPanel2 = new JPanel();
		southPanel.add(southPanelPanel2);
		southPanelPanel2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel southPanelPanel2Panel1 = new JPanel();
		southPanelPanel2.add(southPanelPanel2Panel1);
		FlowLayout fl_southPanelPanel2Panel1 = (FlowLayout) southPanelPanel2Panel1.getLayout();
		fl_southPanelPanel2Panel1.setAlignment(FlowLayout.LEFT);
		
		JButton XButton = new JButton("✖");
		southPanelPanel2Panel1.add(XButton);
		XButton.addActionListener(xMarkListener);
		
		JPanel SouthPanelPanel2Panel2 = new JPanel();
		FlowLayout fl_SouthPanelPanel2Panel2 = (FlowLayout) SouthPanelPanel2Panel2.getLayout();
		fl_SouthPanelPanel2Panel2.setAlignment(FlowLayout.RIGHT);
		southPanelPanel2.add(SouthPanelPanel2Panel2);
		
		JButton checkButton = new JButton("✔");
		SouthPanelPanel2Panel2.add(checkButton);
		checkButton.addActionListener(checkListener);
	}
	public void close(){
		this.setVisible(false);
	}
	private User sendUserData(){
		return this.user;
	}
}
