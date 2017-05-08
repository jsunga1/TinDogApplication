import java.sql.*;
import java.sql.ResultSet;
import java.util.*;

public class User
{
	private DoggieBag db;
	private String firstName;
	private String lastName;

	private String email;
	private String phone;
	private String password;
	private UniversalDogDB udb;
	private DogPile dp;
	
	public User()
	{
		db = new DoggieBag();
		
		firstName = "User";
		lastName = "User";
		email = "User";
		phone = "User";
		password = "User";
		dp = new DogPile();
			
	}
	
	public void setUserInfo(String UserName)
	{
		try{
			udb = new UniversalDogDB();
			String q = "select * from USER where USER_Email = \"" + UserName + "\";";

			udb.retrieveData(q);
			ResultSet rs = udb.getResultSet();
			
			if (rs.next())
			{
				email = UserName;

				firstName = rs.getString("USER_First_Name");
				lastName = rs.getString("USER_Last_Name");
				phone = rs.getString("USER_Phone_Number");
				password = rs.getString("USER_Password");

				dp.generateDogPile(email);
			}
			
		}catch(Exception userFail)
		{
			System.out.println(userFail);
		}
	}
	
	public void deleteUser()
	{
		String query = "DELETE FROM USER where User_Email = \"" + email + "\";";
		String query2 = "DELETE FROM DOGGIE_BAG where User_Email = \"" + email + "\";";
		try
		{
			udb.sendData(query);
			udb.sendData(query2);
		}
		catch (Exception deleteFail)
		{
			deleteFail.printStackTrace();
		}
	}
	public String getFirstName()
	{
		return firstName;

	}
	public String getLastName()
	{
		return lastName;
	}
	public String getEmail()
	{
		return email;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public String getPassword()
	{
		return password;
	}
	public DogPile getDogPile()
	{
		return dp;
	}
	public DoggieBag getDoggieBag()
	{
		return db;
	}

}
