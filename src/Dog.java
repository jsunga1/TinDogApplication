import java.awt.Image;
import java.sql.*;
public class Dog
{
	private int dogID;
	private String dogName;
	private int dogAge;
	private String dogBreed;
	private int gender;
	private String dogShelter;
	private boolean dogStatus;
	private String dogDescription;
	private String dogPic;
	private UniversalDogDB db;
	
	public Dog()
	{
		dogID = 0;
		dogName = "dog";
		dogAge = 0;
		dogBreed = "dog";
		gender = 0;
		dogShelter = "dog";
		dogStatus = true;
		dogDescription = "dog";
		dogPic = "" ;
	}
	public void setDogID(int id)
	{
		dogID = id;
	}
	public void setDogName(String n)
	{
		dogName = n;
	}
	public void setPhotoLink(String p)
	{
		dogPic = p;
	}
	public void setDogInfo(int id)
	{
		try{
			db = new UniversalDogDB();
			String q = "select * from DOG_2 where DOG_ID = " + id;
			db.retrieveData(q);
			ResultSet rs = db.getResultSet();
			
			if (rs.next())
			{
				dogID = rs.getInt("DOG_ID");
				dogName = rs.getString("DOG_Name");
				dogAge = rs.getInt("DOG_Age");
				dogBreed = rs.getString("DOG_Breed");
				gender = rs.getInt("DOG_Gender");
				dogShelter = rs.getString("DOG_Adoption_Agency");
				dogDescription = rs.getString("DOG_Description");
				dogPic = rs.getString("DOG_Photo_Link");
			}
			
		}catch(Exception dogFail)
		{
			System.out.println(dogFail);
		}
	}
	
	public void addDogToDoggieBag(String user)
	{
		db = new UniversalDogDB();
		String q = "Insert into DOGGIE_BAG Values(\"" + user + "\", " + dogID + ")";
		db.sendData(q);
	}
	
	public String getName()
	{
		return dogName;
	}
	
	public int getAge()
	{
		return dogAge;
	}
	
	public String getBreed()
	{
		return dogBreed;
	}
	
	
	public int getGender()
	{
		return gender;
	}
	
	
	public String getShelter()
	{
		return dogShelter;
	}
	
	public String getDescription()
	{
		return dogDescription;
	}
	
	public String getPicture()
	{
		return dogPic;
	}
	
	public boolean getStatus()
	{
		return dogStatus;
	}
	public int getDogID()
	{
		return dogID;
	}
}
