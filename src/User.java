import java.sql.*;
import java.sql.ResultSet;
import java.util.*;

public class User
{
	private DoggieBag db;
	private String name;
	private String email;
	private String phone;
	private String password;
	private int id;
	private UniversalDogDB udb;
	
	public User()
	{
		db = new DoggieBag();
		name = "User";
		email = "User";
		phone = "User";
		password = "User";
		
	}
	
	public void setDogInfo(String UserName)
	{
		try{
			udb = new UniversalDogDB();
			String q = "select * from USER where USER_Email = " + UserName;
			udb.retrieveData(q);
			ResultSet rs = udb.getResultSet();
			
			if (rs.next())
			{
				email = UserName;
				name = rs.getString("USER_Name");
				phone = rs.getString("USER_Phone");
				password = rs.getString("USER_Password");
				id = rs.getInt("USER_ID");
				//db = rs.getString("DOG_Description");
				//dogPic = rs.getString("DOG_Picture");
			}
			
		}catch(Exception dogFail)
		{
			System.out.println(dogFail);
		}
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
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
	
	public void addDog(Dog d)
	{
		db.addDog(d);
	}
}
