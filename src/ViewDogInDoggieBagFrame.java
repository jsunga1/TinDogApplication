


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class ViewDogInDoggieBagFrame extends JFrame {

	private JPanel contentPane;
	private User user;
	private ActionListener backListener;
	public ViewDogInDoggieBagFrame(User u) {
		user = u;
		class createBackListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JFrame frameDoggieBagFrame = new DoggieBagFrame(sendUserData());
				close();
				frameDoggieBagFrame.setVisible(true);
			}
		}
		backListener = new createBackListener();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_7.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel(""); /*Image file here*/
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name" + "");/*Name of Dog here*/
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Breed" + "");/*Breed of Dog here*/
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Location" + "");/*Location of Dog here*/
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_7.add(panel_1);
		
		JTextArea textArea = new JTextArea();/*Info of Dog here*/
		panel_1.add(textArea);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		Component glue = Box.createGlue();
		panel_3.add(glue);
		
		JButton btnNewButton = new JButton("Delete");
		panel_3.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		Component glue_1 = Box.createGlue();
		panel_4.add(glue_1);
		
		JLabel lblTindogLogo = new JLabel(new ImageIcon("C:\\Users\\jde674\\Documents\\GitHub\\Tindog\\TinDog Logo.png"));
		panel_4.add(lblTindogLogo);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		
		Component glue_2 = Box.createGlue();
		panel_5.add(glue_2);
		
		JButton btnNewButton_1 = new JButton("View Adoption Information");
		panel_5.add(btnNewButton_1);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_8.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_6.add(panel_8);
		
		JButton backButton = new JButton("<--");
		panel_8.add(backButton);
		backButton.addActionListener(backListener);
	}
	public void close() {
		this.setVisible(false);
	}
	private User sendUserData(){
		return this.user;
	}

}
