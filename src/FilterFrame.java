import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Component;

public class FilterFrame extends JFrame{

	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;
	private static final int FIELD_WIDTH = 10;
	private JButton Filter_Back;
	private JLabel Filter_FILTER;
	private JLabel Filter_Age;
	private JTextField yage;
	private JLabel Filter_To;
	private JTextField oage;
	private JLabel Filter_Breed;
	private JComboBox Breed;
	private JLabel Filter_Gender;
	private ButtonGroup Gender;
	private JRadioButton Male;
	private JRadioButton Female;
	private JLabel Filter_Shelters;
	private JComboBox Shelters;
	//Tindog Logo

	private ActionListener back_listener;
	private ActionListener enterbtnListener;

	private JPanel panel;
	private JPanel panel_north;
	private JPanel panel_center;
	private JPanel panel_south;

	private JPanel panel_F;
	private JPanel panel_age;
	private JPanel panel_breed;
	private JPanel panel_gender;
	private JPanel panel_shelters;
	private JButton btnFilter;
	private Component horizontalStrut;
	private JPanel panel_1;

	public FilterFrame(){
		class Back_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				listenerCode();
			}
		}
		class EnterListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				yage.getText(); //get min age
				oage.getText(); //get max age
				Breed.getSelectedItem(); //get breed
				if(Male.isSelected()){ //male
					
				}
				else if(Female.isSelected()){ //female
					
				}
				Shelters.getSelectedItem(); //get shelter
				listenerCode();
			}
		}
		back_listener = new Back_Listener();
		enterbtnListener = new EnterListener();
		createcosa();

		Filter_Back.addActionListener(back_listener);
		createpanel();
		btnFilter.addActionListener(enterbtnListener);
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	public void createcosa(){
		Filter_Age = new JLabel("Age:");
		Filter_To = new JLabel("to");
		Filter_Breed = new JLabel("Breed:");
		Breed = new JComboBox();
		// not sure what dog breeds to add.
		//whether it should be just dog breeds or if it uses another thing to show what dog breed are available
		Filter_Gender = new JLabel("Gender:");
		Gender = new ButtonGroup();
		Gender.add(Male);
		Gender.add(Female);
		Male = new JRadioButton("Male");
		Female = new JRadioButton("Female");
		Filter_Shelters = new JLabel("Shelter:");
		Shelters = new JComboBox();
		//make it use the shelters available 
		yage = new JTextField(FIELD_WIDTH);
		oage = new JTextField(FIELD_WIDTH);
		Filter_Back = new JButton("<--");
	}
	public void createpanel(){

		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel_center = new JPanel();
		panel_center.setLayout(new GridLayout(5,1));
		panel_north = new JPanel();
		panel_north.setLayout(new BorderLayout());
		panel_F = new JPanel();
		panel_age = new JPanel();
		panel_age.setLayout(new GridLayout(1,4));
		panel_age.add(Filter_Age);
		panel_age.add(yage);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		panel_age.add(horizontalStrut);
		panel_age.add(Filter_To);
		panel_age.add(oage);
		panel_breed = new JPanel();
		panel_breed.setLayout(new GridLayout(1,2));
		panel_breed.add(Filter_Breed);
		panel_breed.add(Breed);
		panel_gender = new JPanel();
		panel_gender.setLayout(new GridLayout(1,3));
		panel_gender.add(Filter_Gender);
		panel_gender.add(Male);
		panel_gender.add(Female);
		panel_shelters = new JPanel();
		panel_shelters.setLayout(new GridLayout(1,2));
		panel_shelters.add(Filter_Shelters);
		panel_shelters.add(Shelters);

		panel_north.add(Filter_Back, BorderLayout.WEST);
		
		panel_1 = new JPanel();
		panel_north.add(panel_1, BorderLayout.CENTER);
		
				Filter_FILTER = new JLabel("FILTER");
				panel_1.add(Filter_FILTER);
		panel_center.add(panel_F);
		panel_center.add(panel_age);
		panel_center.add(panel_breed);
		panel_center.add(panel_gender);
		panel_center.add(panel_shelters);

		panel_south = new JPanel();
		//add Tindog Logo

		panel.add(panel_north, BorderLayout.NORTH);
		panel.add(panel_center, BorderLayout.CENTER);
		panel.add(panel_south, BorderLayout.SOUTH);
		
		btnFilter = new JButton("Filter");
		panel_south.add(btnFilter);
		getContentPane().add(panel);

	}
	public void close(){
		this.setVisible(false);
	}
	public void listenerCode(){
		JFrame frameDogListFrame = new DogListFrame();
		close();
		frameDogListFrame.setVisible(true);
		frameDogListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
