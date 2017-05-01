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
		dogPic = "dog";
	}
	public void setdogID(int id)
	{
		dogID = id;
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
				dogName = rs.getString("DOG_Name");
				dogAge = rs.getInt("DOG_Age");
				dogBreed = rs.getString("DOG_Breed");
				gender = rs.getInt("DOG_Gender");
				dogShelter = rs.getString("DOG_Shelter");
				dogDescription = rs.getString("DOG_Description");
				//dogPic = rs.getString("DOG_Picture");
			}
			
		}catch(Exception dogFail)
		{
			System.out.println(dogFail);
		}
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
}
