import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout.*;
import java.awt.GridLayout.*;
import java.awt.event.*;


public class ErrorFrame1 extends JFrame{

	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;
	
	private JLabel BadDog;
	private JButton Back;
	
	private ActionListener backlistener;
	
	private JPanel panel;
	private JPanel panel_center;
	
	
	
	
	public ErrorFrame1(){
		class Back_Listener implements ActionListener{
			public void actionPerformed(ActionEvent e){

			}
		}

		backlistener = new Back_Listener();

		
		createcosa();
		Back.addActionListener(backlistener);
		
		createpanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	public void createcosa(){
		BadDog = new JLabel("ERROR");
		Back = new JButton("BACK");
	}
	public void createpanel(){
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel_center = new JPanel();
		panel_center.setLayout(new GridLayout(2,1));
		
		panel_center.add(BadDog);
		panel_center.add(Back);
				
		panel.add(panel_center, BorderLayout.CENTER);
		add(panel);
	}
	public void close(){
		this.setVisible(false);
	}
}
