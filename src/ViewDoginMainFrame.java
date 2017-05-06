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
					close();
					frameDogListFrame.setVisible(true);
					frameDogListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		}
		
		class createXMarkListener implements ActionListener{
			public void actionPerformed(ActionEvent e)
			{
				dp.removeHeadDog();
				JFrame frameDogListFrame;
				try {
					frameDogListFrame = new DogListFrame(sendUserData());
					close();
					frameDogListFrame.setVisible(true);
					frameDogListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		
		class createCheckListener implements ActionListener{
			public void actionPerformed(ActionEvent e)
			{
				dog.addDogToDoggieBag(user.getEmail());
				dp.removeHeadDog();
				
				JFrame frameDogListFrame;
				try {
					frameDogListFrame = new DogListFrame(sendUserData());
					close();
					frameDogListFrame.setVisible(true);
					frameDogListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		}
		
		int dogid = user.getDogPile().getHeadDog();
		dog.setDogInfo(dogid);
		
		dp = user.getDogPile();
		
		xMarkListener = new createXMarkListener();
		checkListener = new createCheckListener();
		
		backbtnListener = new backListener();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		FlowLayout flowLayout_2 = (FlowLayout) panel_7.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		
		JButton button = new JButton("<--");
		panel_7.add(button);
		button.addActionListener(backbtnListener);
		
		JPanel panel_10 = new JPanel();
		contentPane.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_10.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		panel_8.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name: " +  dog.getName());
		panel_8.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Breed: " +  dog.getBreed());
		panel_8.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Age: " + dog.getAge());
		panel_8.add(lblNewLabel_4);

		String sex = new String();
		if(dog.getGender() == 0)
			sex = "Female";
		else
			sex = "Male";
		JLabel lblNewLabel_5 = new JLabel("Gender: " + sex);
		panel_8.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("Location: " + dog.getShelter());
		panel_8.add(lblNewLabel_2);
		
		
		JPanel panel_1 = new JPanel();
		panel_10.add(panel_1);
		
		JTextArea textArea = new JTextArea();
		panel_1.add(textArea);
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_9.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		Component glue_1 = Box.createGlue();
		panel_4.add(glue_1);
		
		JButton btnViewAdoptionInformation = new JButton("View Adoption Information");
		panel_4.add(btnViewAdoptionInformation);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_6.add(panel_3);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		Component glue = Box.createGlue();
		panel_3.add(glue);
		
		JButton btnNewButton = new JButton("✖");
		panel_3.add(btnNewButton);
		btnNewButton.addActionListener(xMarkListener);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_6.add(panel_5);
		
		Component glue_2 = Box.createGlue();
		panel_5.add(glue_2);
		
		JButton btnNewButton_1 = new JButton("✔");
		panel_5.add(btnNewButton_1);
		btnNewButton_1.addActionListener(checkListener);
	}
	public void close(){
		this.setVisible(false);
	}
	private User sendUserData(){
		return this.user;
	}
}
