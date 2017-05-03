import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class FilterFrame1 extends JFrame {

	private JPanel contentPane;
	private JTextField bAgeField;
	private JTextField tAgeField;
	private JComboBox breedComboBox;
	private JComboBox shelterComboBox;
	private JRadioButton maleButton;
	private JRadioButton femaleButton;
	private User user;
	public FilterFrame1() {
		class createBackListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				try {
					JFrame frameDogListFrame = new DogListFrame(sendUserData());
					close();
					frameDogListFrame.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		class createSubmitListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				bAgeField.getText();//bottom age
				tAgeField.getText();//top age 
				breedComboBox.getSelectedItem();//get breed
				shelterComboBox.getSelectedItem();//get shelter
				if(maleButton.isSelected()){//male is selected

				}
				else if(femaleButton.isSelected()){//female is selected

				}
				else if(maleButton.isSelected() && femaleButton.isSelected()){//both are selected

				}
				try {
					JFrame frameDogListFrame = new DogListFrame(sendUserData());
					close();
					frameDogListFrame.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));

		JButton backButton = new JButton("<--");
		northPanel.add(backButton, BorderLayout.WEST);

		JPanel northCenterPanel = new JPanel();
		northPanel.add(northCenterPanel, BorderLayout.CENTER);

		JLabel filterTitleLabel = new JLabel("Filter");
		northCenterPanel.add(filterTitleLabel);

		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));

		JPanel centerWestPanel = new JPanel();
		centerPanel.add(centerWestPanel, BorderLayout.WEST);
		centerWestPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel centerWestPanel1 = new JPanel();
		FlowLayout fl_centerWestPanel1 = (FlowLayout) centerWestPanel1.getLayout();
		centerWestPanel.add(centerWestPanel1);

		JLabel ageLabel = new JLabel("Age:");
		centerWestPanel1.add(ageLabel);

		JPanel centerWestPanel2 = new JPanel();
		centerWestPanel.add(centerWestPanel2);

		JLabel breedLabel = new JLabel("Breed:");
		centerWestPanel2.add(breedLabel);

		JPanel centerWestPanel3 = new JPanel();
		centerWestPanel.add(centerWestPanel3);

		JLabel genderLabel = new JLabel("Gender:");
		centerWestPanel3.add(genderLabel);

		JPanel centerWestPanel4 = new JPanel();
		centerWestPanel.add(centerWestPanel4);

		JLabel shelterLabel = new JLabel("Shelter:");
		centerWestPanel4.add(shelterLabel);

		JPanel centerCenterPanel = new JPanel();
		centerPanel.add(centerCenterPanel);
		centerCenterPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel centerCenterPanel1 = new JPanel();
		centerCenterPanel.add(centerCenterPanel1);
		centerCenterPanel1.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel centerCenterPanel1panel1 = new JPanel();
		centerCenterPanel1.add(centerCenterPanel1panel1);

		bAgeField = new JTextField();
		centerCenterPanel1panel1.add(bAgeField);
		bAgeField.setColumns(10);

		JPanel centerCenterPanel1panel2 = new JPanel();
		centerCenterPanel1.add(centerCenterPanel1panel2);

		JLabel toLabel = new JLabel("to");
		centerCenterPanel1panel2.add(toLabel);

		JPanel centerCenterPanel1panel3 = new JPanel();
		centerCenterPanel1.add(centerCenterPanel1panel3);

		tAgeField = new JTextField();
		centerCenterPanel1panel3.add(tAgeField);
		tAgeField.setColumns(10);

		JPanel centerCenterPanel2 = new JPanel();
		centerCenterPanel.add(centerCenterPanel2);

		JPanel centerCenterPanel2panel1 = new JPanel();
		centerCenterPanel2.add(centerCenterPanel2panel1);

		breedComboBox = new JComboBox();
		centerCenterPanel2panel1.add(breedComboBox);

		JPanel centerCenterPanel3 = new JPanel();
		centerCenterPanel.add(centerCenterPanel3);
		centerCenterPanel3.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel centerCenterPanel3panel1 = new JPanel();
		centerCenterPanel3.add(centerCenterPanel3panel1);

		maleButton = new JRadioButton("Male");
		centerCenterPanel3panel1.add(maleButton);

		JPanel panel_1 = new JPanel();
		centerCenterPanel3.add(panel_1);

		femaleButton = new JRadioButton("Female");
		panel_1.add(femaleButton);

		JPanel centerCenterPanel4 = new JPanel();
		centerCenterPanel.add(centerCenterPanel4);

		JPanel centerCenterPanel4panel1 = new JPanel();
		centerCenterPanel4.add(centerCenterPanel4panel1);

		shelterComboBox = new JComboBox();
		centerCenterPanel4panel1.add(shelterComboBox);

		JPanel southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);

		JButton submitButton = new JButton("Submit");
		southPanel.add(submitButton);
	}
	public void close() {
		this.setVisible(false);
	}
	private User sendUserData(){
		return this.user;
	}
}
