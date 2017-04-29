import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;

public class DogListFrame extends JFrame {

	private JPanel contentPane;
	private ActionListener mainMenubtnListener;
	private ActionListener filterbtnListener;
	private ActionListener viewInfobtnListener;
	public DogListFrame() {
		
		class mainMenuListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameMainMenuFrame = new MainFrame();
				close();
				frameMainMenuFrame.setVisible(true);
				frameMainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		class filterListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameFilterFrame = new FilterFrame();
				close();
				frameFilterFrame.setVisible(true);
				frameFilterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		class viewInfoListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameViewDogInMainFrameFrame = new ViewDoginMainFrame();
				close();
				frameViewDogInMainFrameFrame.setVisible(true);
				frameViewDogInMainFrameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		mainMenubtnListener = new mainMenuListener();
		filterbtnListener = new filterListener();
		viewInfobtnListener = new viewInfoListener();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JButton btnMainMenu = new JButton("Main Menu");
		panel_3.add(btnMainMenu);
		btnMainMenu.addActionListener(mainMenubtnListener);
		Component horizontalStrut = Box.createHorizontalStrut(110);
		panel_3.add(horizontalStrut);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(120);
		panel_4.add(horizontalStrut_1);
		
		JButton btnFilter = new JButton("Filter");
		panel_4.add(btnFilter);
		btnFilter.addActionListener(filterbtnListener);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		JButton btnNewButton = new JButton("✖");
		panel_5.add(btnNewButton);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		
		JLabel lblNewLabel = new JLabel("New label");//TinDog logo
		panel_6.add(lblNewLabel);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);
		
		JButton btnNewButton_1 = new JButton("✔");
		panel_7.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_8.add(lblNewLabel_1);
		
		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));
		
		Component verticalStrut = Box.createVerticalStrut(30);
		panel_9.add(verticalStrut);
		
		JPanel panel_10 = new JPanel();
		panel_9.add(panel_10);
		
		JButton btnViewMoreInformation = new JButton("View More Information");
		panel_10.add(btnViewMoreInformation);
		btnViewMoreInformation.addActionListener(viewInfobtnListener);
	}
	public void close(){
		this.setVisible(false);
	}
}
