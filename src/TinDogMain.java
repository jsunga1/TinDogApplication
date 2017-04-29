

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

		//ArrayList<Dog> DogQueue = new ArrayList<Dog>();

		//Does this work?

	/*	JFrame frame1 = new FilterFrame();
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);*/
		
		JFrame frameStartFrame = new StartFrame();
		frameStartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameStartFrame.setVisible(true);

		/*JFrame frame2 = new loginFrame();
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);*/
/*		
		try{
			UniversalDogDB db = new UniversalDogDB();
			String q = "select * from USER";
			db.retrieveData(q);
			ResultSet rs = db.getResultSet();
			if (rs.next())
			{
				System.out.println(rs.getString("USER_Email"));
			}
			else
			{
				System.out.println("Nothing was retrieved");
			}
		}catch (Exception e)
		{
			System.out.println(e);
		}*/
		
		
	}
}
