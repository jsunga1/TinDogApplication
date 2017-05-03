import java.sql.*;
import java.sql.ResultSet;
import java.util.*;

public class User
{
	private DoggieBag DogBag;
	private String fname;
	private String lname;
	private String email;
	private String phone;
	private String password;
	private int id;
	private UniversalDogDB db;
	
	public User()
	{
		DogBag = new DoggieBag();
		fname = "User";
		lname = "User";
		email = "User";
		phone = "User";
		password = "User";
		
	}
	
	public void setDogInfo(String UserName)
	{
		try{
			db = new UniversalDogDB();
			String q = "select * from USER where USER_Email = \"" + UserName + "\"";
			db.retrieveData(q);
			ResultSet rs = db.getResultSet();
			
			if (rs.next())
			{
				email = UserName;
				fname = rs.getString("USER_First_Name");
				lname = rs.getString("USER_Last_Name");
				phone = rs.getString("USER_Phone");
				password = rs.getString("USER_Password");
	
			}
			
		}catch(Exception dogFail)
		{
			System.out.println(dogFail);
		}
	}
	
	public void setName(String name)
	{
		this.fname = name;
	}
	public String getName()
	{
		return fname;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return email;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getPhone()
	{
		return phone;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return password;
	}
	public void setID(int id)
	{
		this.id = id;
	}
	public int getID()
	{
		return id;
	}
	

}
