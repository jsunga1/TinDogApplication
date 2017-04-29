
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
			
			dogPile.add(d);
			
			if(filter)
			{
				//if any of the dog's values do not fit the filter it is removed
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
}