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
	private int position;
	
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

	
	public void generateDogPile(String email)
	{
		dogPile.clear();
		String query;
		UniversalDogDB db = new UniversalDogDB();
		checkFilter();
		query = "Select DOG_ID from DOG_2";
		
		if(filter)
		{
			if(shelterFilter)
			{
				query = query + " JOIN ADOPTION_AGENCY ON DOG_Adoption_Agency = AGENCY_ID ";
			}
			query = query + " where ";
			if(ageFilter1)
				query = query + "DOG_Age >= " + age1;
			
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
		query = query + ";";
		db.retrieveData(query);
		ResultSet rs = db.getResultSet();
		
		
		try
		{
			while(rs.next())
			{
				String q2 = "Select DOG_Id from DOGGIE_BAG where USER_Email = \"" + email + "\";";
				UniversalDogDB db2 = new UniversalDogDB();
				db2.retrieveData(q2);
				ResultSet rs2 = db2.getResultSet();
				int test = 0;
				int di = rs.getInt("DOG_Id"); 
				
				while(rs2.next())
				{
					int i = rs2.getInt("DOG_Id");
					if(di == i)
						test++;
				}
				if(test == 0)
					dogPile.add(di);
			}
			getHeadDog();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getHeadDog()
	{
		Random r = new Random();
		position = r.nextInt(dogPile.size());
	}
	public int getCurrentPosition()
	{
		
		return dogPile.get(position);
	}
	
	public void removeHeadDog()
	{
		dogPile.remove(position);
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
	public ArrayList <Integer> getDogPileArray()
	{
		return dogPile;
	}
}