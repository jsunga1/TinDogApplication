
import java.util.*;

public class DogPile
{
	private Queue<Dog> dogPile;
	private int age1;
	private int age2;
	private String breed;
	private int gender;
	private String shelter;
	private boolean filter;
	
	public DogPile()
	{
		dogPile = new LinkedList<Dog>();
		age1 = 0;
		age2 = 100;
		breed = "";
		gender = 2;
		shelter = "";
		filter = false;
	}
	
	public Queue<Dog> createPile()
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
			
			dogPile.add(d);
			
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