import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class ViewDoginDoggieBag extends JFrame
{
	private User user;
	private Dog dog;
	private JPanel contentPane;
	
	public ViewDoginDoggieBag(User u, Dog d)
	{
		user = u;
		dog = d;
		
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
		
		JLabel lblNewLabel = new JLabel("");
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name: " + dog.getName());
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Breed: " + dog.getBreed());
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_7.add(panel_1);
		
		JTextArea textArea = new JTextArea(dog.getDescription());
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
		
		JLabel lblTindogLogo = new JLabel(new ImageIcon("https://mystjohns-my.sharepoint.com/personal/skrotzkn_stjohns_edu/_layouts/15/guestaccess.aspx?docid=119b16a04c6ce43d084d5663bd04b7cb7&authkey=AbKFbF4aT252NwtJ6CCQ2ic"));
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
		
		JButton button = new JButton("<--");
		panel_8.add(button);
	}

}
