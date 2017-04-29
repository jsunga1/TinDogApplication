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

public class DogListFrame extends JFrame {

	private JPanel contentPane;
	private ActionListener mainMenubtnListener;
	private ActionListener filterbtnListener;
	private ActionListener viewInfobtnListener;
	
	public DogListFrame() throws IOException {
		
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
				JFrame frameViewDogInMainFrameFrame = new ViewDogInMainFrame();
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
		
		JPanel panel_north = new JPanel();
		contentPane.add(panel_north, BorderLayout.NORTH);
		panel_north.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_north_buttonMainMenu = new JPanel();
		panel_north.add(panel_north_buttonMainMenu);
		panel_north_buttonMainMenu.setLayout(new BorderLayout(0, 0));
		
		JButton btnMainMenu = new JButton("Main Menu");
		panel_north_buttonMainMenu.add(btnMainMenu, BorderLayout.WEST);
		btnMainMenu.addActionListener(mainMenubtnListener);
		
		JPanel panel_north_buttonFilter = new JPanel();
		panel_north.add(panel_north_buttonFilter);
		panel_north_buttonFilter.setLayout(new BorderLayout(0, 0));
		
		JButton btnFilter = new JButton("Filter");
		panel_north_buttonFilter.add(btnFilter, BorderLayout.EAST);
		btnFilter.addActionListener(filterbtnListener);
		
		JPanel panel_south = new JPanel();
		contentPane.add(panel_south, BorderLayout.SOUTH);
		panel_south.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_south_Xmark = new JPanel();
		panel_south.add(panel_south_Xmark);
		
		JButton button_Xmark = new JButton("✖");
		panel_south_Xmark.add(button_Xmark);
		
		JPanel panel_south_image = new JPanel();
		panel_south.add(panel_south_image);
		
		JLabel LabelImageTINDOGLogo = new JLabel(new ImageIcon("C:\\Users\\jde674\\Documents\\GitHub\\Tindog\\TinDog Logo.png"));//TinDog logo
		panel_south_image.add(LabelImageTINDOGLogo);
		
		JPanel panel_south_checkmark = new JPanel();
		panel_south.add(panel_south_checkmark);
		
		JButton button_checkmark = new JButton("✔");
		panel_south_checkmark.add(button_checkmark);
		
		JPanel panel_center = new JPanel();
		contentPane.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_center_Image = new JPanel();
		panel_center.add(panel_center_Image, BorderLayout.CENTER);
		
		
		URL dogPhoto = new URL("https://barkpost-assets.s3.amazonaws.com/wp-content/uploads/2013/11/grumpy-dog-11.jpg");
		Image photo = ImageIO.read(dogPhoto).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		panel_center_Image.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(photo));
		panel_center_Image.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel_center_Image.add(panel, BorderLayout.SOUTH);
		
		JLabel lblName = new JLabel("Buddy");
		panel.add(lblName);
		
		JPanel panel_center_tbd = new JPanel();
		panel_center.add(panel_center_tbd, BorderLayout.SOUTH);
		panel_center_tbd.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_center_tbd_buttonViewMoreInfo= new JPanel();
		panel_center_tbd.add(panel_center_tbd_buttonViewMoreInfo);
		
		JButton btnViewMoreInformation = new JButton("View More Information");
		panel_center_tbd_buttonViewMoreInfo.add(btnViewMoreInformation);
		btnViewMoreInformation.addActionListener(viewInfobtnListener);
	}
	public void close(){
		this.setVisible(false);
	}
}
