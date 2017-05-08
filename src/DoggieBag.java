import java.util.*;
import java.sql.*;

public class DoggieBag
{
	public ArrayList<Integer> DogBag;
	private int age1;
	private int age2;
	private String breed;
	private int gender;
	private String shelter;
	private String userID;
	
	public DoggieBag()
	{
		DogBag = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> generateDoggieBag(String user)
	{
		
		UniversalDogDB db = new UniversalDogDB();
		userID = user;
		String q = "Select DOG_Id from DOGGIE_BAG where USER_Email = \"" + user + "\";";
		System.out.println(q);
		db.retrieveData(q);
		ResultSet rs = db.getResultSet();
		DogBag = new ArrayList <Integer>();
		
		try {
			while(rs.next())
			{
				DogBag.add(rs.getInt("DOG_Id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return DogBag;
	}

	
	public ArrayList<Integer> getDoggieBag()
	{
		return DogBag;
	}

	public void deleteDog(User u, int i)
	{
		UniversalDogDB db = new UniversalDogDB();
		String q = "DELETE from DOGGIE_BAG where DOG_Id = " + i + " AND USER_Email = \"" + u.getEmail() + "\";";
		db.sendData(q);
	}

	public void setAge1(int a)
	{
		age1 = a;
	}
	public void setAge2(int a)
	{
		age2 = a;
	}
	public void setBreed(String b)
	{
		breed = b;
	}
	public void setGender(int g)
	{
		gender = g;
	}
	public void setShelter(String s)
	{
		shelter = s;
	}
}
