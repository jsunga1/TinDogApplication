
import java.util.*;

public class DogPile
{
	private ArrayList<Integer> dogPile;
	private int age1;
	private int age2;
	private String breed;
	private int gender;
	private String shelter;
	private boolean filter;
	
	public DogPile()
	{
		dogPile = new ArrayList<Integer>();
		age1 = 0;
		age2 = 100;
		breed = "";
		gender = 2;
		shelter = "";
		filter = false;
	}
	
	public ArrayList<Integer> createPile()
	{
		for(int i = 0; i < 50; i++)
		{
			checkFilter();
			
			int dogID = (int)Math.random();
			Dog d = new Dog();
			
			/*retrieve data
			 * String q = "Select * from DOG where DOG_ID = " + dogID + ";";
			 * d.setName(rs.getString("DOG_NAME"));
			 * d.setAge(rs.getInt("DOG_AGE"));
			 * d.setBreed(rs.getString("DOG_BREED"));
			 * d.setGender(rs.getInt("DOG_GENDER"));
			 * d.set
			 * 
			 */
			
			//dogPile.add(d);
			
			if(filter)
			{
				if(d.getAge() < age1 || d.getAge() > age2)
					dogPile.remove(d);
				else if(!d.getBreed().equals(breed))
					dogPile.remove(d);
				else if(d.getGender() != gender)
					dogPile.remove(d);
				else if(!d.getShelter().equals(shelter))
					dogPile.remove(d);
			}
			
		}
		return dogPile;
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
		if(filter)
			query = "Select DOG_ID from DOG Where DOG_Age > " + age1 +" AND DOG_AGE < "+ age2 + 
			", DOG_Breed = " + breed + ", DOG_Gender = " + gender;
		else
			query = "Select DOG_ID from DOG";
			
		db.sendData(query);
		
		
	}
	
	public Dog createDog(int i)
	{
		Dog d = new Dog();
		UniversalDogDB db = new UniversalDogDB();
		String query = "Select * from DOG where DOG_ID = " + i;
		db.sendData(query);
		
		return d;
	}
	
	public void removeHeadDog()
	{
		dogPile.remove(0);
	}
	
	public void checkFilter()
	{
		if(age1 != 0)
			filter = true;
		else if(age2 != 100)
			filter = true;
		else if(!breed.isEmpty())
			filter = true;
		else if(gender != 2)
			filter = true;
		else if(!shelter.isEmpty())
			filter = true;
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