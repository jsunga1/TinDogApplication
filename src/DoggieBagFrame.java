import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.util.Scanner;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DoggieBagFrame extends JFrame
{
	private JPanel contentPane;
	private JPanel panel_center;
	private JPanel dogPanel;
	private ActionListener backlistener;
	private ActionListener dogImageListener;

	private ActionListener dogListener;


	private User user;
	private Dog dog;
	private DoggieBag dogBagTemp;
	private ArrayList <Integer> dogTemp;
	private JComboBox box;



	
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
				String boxInfo, boxInfoTemp0;
				boxInfo = (String)box.getSelectedItem();//needs to find which do it is from dog name
				Scanner input = new Scanner(boxInfo);
				input.next();
				dog.setDogID(input.nextInt()); 
				JFrame frameVDIDBF = new ViewDogInDoggieBagFrame(sendUserData(), dog);
				close();
				frameVDIDBF.setVisible(true);
				frameVDIDBF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}

		backlistener = new Back_Listener();
		dogListener = new createDogListener();
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


		
		panel_center = new JPanel();//add combobox here
		panel_center.setLayout(new BorderLayout());
		panel_center.add(createBox(), BorderLayout.CENTER);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(dogListener);
		panel_center.add(submitButton, BorderLayout.SOUTH);
		

		contentPane.add(panel_center, BorderLayout.CENTER);
	}
	


	public JComboBox createBox()
	{
		box = new JComboBox();
		dogBagTemp = new DoggieBag(user.getEmail());
		dogTemp = dogBagTemp.getDoggieBag();
		
		for(Integer i: dogTemp)
		{
			dog.setDogInfo(dogTemp.get(i));
			box.addItem("ID: " + dog.getDogID() + " Name: " +  dog.getName());
		}
		return box;
	}
	
	public void close(){
		this.setVisible(false);
	}
	public User sendUserData(){
		return this.user;
	}

}
