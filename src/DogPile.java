import java.sql.*;
import java.util.*;

public class DogPile
{
	private ArrayList<Integer> dogPile;
	private int age1;
	private int age2;
	private String breed;
	private int gender;
	private String shelter;
	private boolean ageFilter1;
	private boolean ageFilter2;
	private boolean breedFilter;
	private boolean genderFilter;
	private boolean shelterFilter;
	private boolean filter;
	
	public DogPile()
	{
		dogPile = new ArrayList<Integer>();
		age1 = 0;
		age2 = 100;
		breed = "";
		gender = 2;
		shelter = "";
		ageFilter1 = false;
		ageFilter2 = false;
		breedFilter = false;
		genderFilter = false;
		shelterFilter = false;
	}

	
	public void generateDogPile()
	{
		//connection to db
		//grab ids
		//save to arraylist
		//needs to added to filterframe
		//create with start frame w/user
		
		String query;
		UniversalDogDB db = new UniversalDogDB();
		
		
		checkFilter();
		query = "Select DOG_ID from DOG";
		
		if(filter)
			query = query + " Where ";
		if(ageFilter1)
			query = query + " DOG_Age > " + age1;
		if(ageFilter2)
		{
			if(ageFilter1)
				query = query + ", AND DOG_AGE < "+ age2;
			else
				query = query + "DOG_AGE < "+ age2;
		}
		if(breedFilter)
		{
			if(ageFilter1 || ageFilter2)
				query = query + ", AND DOG_Breed = \"" + breed + "\"";
			else
				query = query + "DOG_Breed = \"" + breed + "\"";
		}
		if(genderFilter)
		{
			if(ageFilter1 || ageFilter2 || breedFilter)
				query = query + ", AND DOG_Gender = " + gender;
			else
				query = query + "DOG_Gender = " + gender;
		if(shelterFilter)
		{
			if(ageFilter1 || ageFilter2 || breedFilter || genderFilter)
				query = query + ", AND DOG_Shelter = \"" + shelter + "\"";
			else
				query = query + "DOG_Shelter = \"" + shelter + "\"";
		}
		query = query + ";";	
			
		db.retrieveData(query);
		ResultSet rs = db.getResultSet();
		
		try
		{
			while(rs.next())
			{
				dogPile.add(rs.getInt("DOG_ID"));
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public int getHeadDog()
	{
		return dogPile.get(0);
	}
	
	public void removeHeadDog()
	{
		dogPile.remove(0);
	}
	
	public void checkFilter()
	{
		if(age1 != 0)
		{
			ageFilter1 = true;
			filter = true;
		}
		if(age2 != 100)
		{
			ageFilter2 = true;
			filter = true;
		}
		if(!breed.isEmpty())
		{
		
			breedFilter = true;
			filter = true;
		}
		if(gender != 2)
		{
			genderFilter = true;
			filter = true;
		}
		if(!shelter.isEmpty())
		{
			shelterFilter = true;
			filter = true;
		}
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