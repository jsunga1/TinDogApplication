import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;

public class EditUserFrame extends JFrame{
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;
	private static final int FIELD_WIDTH = 10;
	private JButton cancelButton;
	private JButton submitButton;
	
	private ActionListener cancelButtonListener;
	private ActionListener submitButtonListener;
	
	private JPanel panel;
	private JPanel southPanel;
	private JPanel northPanel;
	private JPanel northPanel_center;
	private Component glue;
	private JLabel lblEditAccount;
	private JButton button_back;
	private JPanel centerPanel;
	private JLabel label_name;
	private JTextField textField;
	private JLabel lblPassword;
	private JTextField textField_1;
	private JLabel lblRetypePassword;
	private JTextField textField_2;
	private JLabel lblPhoneNumber;
	private JTextField textField_3;
	
	public EditUserFrame(){
		class cancelListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
				JFrame frameSettingsFrame = new SettingsFrame();
				frameSettingsFrame.setVisible(true);
			}
		}
		class submitListener implements ActionListener{ //needs to take data
			public void actionPerformed(ActionEvent e){
				JFrame frameSettingsFrame = new SettingsFrame();
				frameSettingsFrame.setVisible(true);
			}
		}
		createComponents();
		cancelButtonListener = new cancelListener();
		cancelButton.addActionListener(cancelButtonListener);
		submitButtonListener = new submitListener();
		submitButton.addActionListener(submitButtonListener);
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	public void createComponents(){
		cancelButton = new JButton("Cancel");
		submitButton = new JButton("Submit");
	}
	public void createPanel(){
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		southPanel = new JPanel();
		southPanel.add(cancelButton);
		southPanel.add(submitButton);
		panel.add(southPanel, BorderLayout.SOUTH);
		getContentPane().add(panel);
		
		northPanel = new JPanel();
		panel.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		northPanel_center = new JPanel();
		northPanel.add(northPanel_center, BorderLayout.CENTER);
		
		glue = Box.createGlue();
		northPanel_center.add(glue);
		
		lblEditAccount = new JLabel("Edit Account");
		northPanel_center.add(lblEditAccount);
		
		button_back = new JButton("<--");
		button_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		northPanel.add(button_back, BorderLayout.WEST);
		
		centerPanel = new JPanel();
		panel.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(8, 1, 0, 0));
		
		label_name = new JLabel("Name: ");
		centerPanel.add(label_name);
		
		textField = new JTextField();
		centerPanel.add(textField);
		textField.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		centerPanel.add(lblPassword);
		
		textField_1 = new JTextField();
		centerPanel.add(textField_1);
		textField_1.setColumns(10);
		
		lblRetypePassword = new JLabel("Re-type Password:");
		centerPanel.add(lblRetypePassword);
		
		textField_2 = new JTextField();
		centerPanel.add(textField_2);
		textField_2.setColumns(10);
		
		lblPhoneNumber = new JLabel("Phone Number");
		centerPanel.add(lblPhoneNumber);
		
		textField_3 = new JTextField();
		centerPanel.add(textField_3);
		textField_3.setColumns(10);
	}
	public void close(){
		this.setVisible(false);
	}
}