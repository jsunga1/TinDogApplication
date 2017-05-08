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
	private boolean ageFilter1;
	private boolean filter;
	private boolean ageFilter2;
	private boolean breedFilter;
	private boolean genderFilter;
	private boolean shelterFilter;
	public DoggieBag()
	{
		DogBag = new ArrayList<Integer>();
	}
	
	public DoggieBag(String user)
	{
		/*UniversalDogDB db = new UniversalDogDB();
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
		}*/
		DogBag = new ArrayList<Integer>();
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
		userID = user;
	}
	public ArrayList <Integer> generateDogBag()
	{
		DogBag.clear();
		UniversalDogDB db = new UniversalDogDB();
		String query = "Select DOG_Id from DOGGIE_BAG ";
		System.out.println(query);
		
		checkFilter();
		if(filter)
		{
			if(shelterFilter)
			{
				query = query + " JOIN ADOPTION_AGENCY ON DOG_Adoption_Agency = AGENCY_ID where USER_Email = \"" + userID + "\";";
			}
			else
			query = query + " where USER_Email = \"" + userID + "\";";
			System.out.println(DogBag.size());
			if(ageFilter1)
				query = query + " AND DOG_Age >= " + age1;
			
			if(ageFilter2)
			{
				if(ageFilter1)
					query = query + " AND DOG_Age <= "+ age2;
				else
					query = query + "DOG_Age <= " + age2;
			}
			if(breedFilter)
			{
				if(ageFilter1 || ageFilter2)
					query = query + " AND DOG_Breed = \"" + breed + "\"";
				else
					query = query + "DOG_Breed = \"" + breed + "\"";
			}
			if(genderFilter)
			{
				if(ageFilter1 || ageFilter2 || breedFilter)
				query = query + " AND DOG_Gender = " + gender;
				else
				query = query + "DOG_Gender = " + gender;
			}
			if(shelterFilter)
			{
				if(ageFilter1 || ageFilter2 || breedFilter || genderFilter)
					query = query + " AND Agency_Name = \"" + shelter + "\"";
				else
					query = query + "Agency_Name = \"" + shelter + "\"";
			}
		}
		db.retrieveData(query);
		ResultSet rs = db.getResultSet();
		
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
		String q = "DELETE from DOGGIE_BAG where DOG_ID = " + i + " AND USER_Email = \"" + u.getEmail() + "\";";
		db.sendData(q);
	}
	public void clearFilter()
	{
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
		filter = false;
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
		if(!breed.equals(""))
		{
		
			breedFilter = true;
			filter = true;
		}
		if(gender != 2)
		{
			genderFilter = true;
			filter = true;
		}
		if(!shelter.equals(""))
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
