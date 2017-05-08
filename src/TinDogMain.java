

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.sql.*;

public class TinDogMain
{
	private static ActionListener nuca_listener;
	private ActionListener login_listener;
	public static void main(String[] args)
	{

		JFrame frameStartFrame = new StartFrame();
		frameStartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameStartFrame.setVisible(true);
		
	}
}
