import java.util.*;

public class DoggieBag
{
	public ArrayList<Dog> DogBag;
	
	public DoggieBag()
	{
		DogBag = new ArrayList<Dog>();
	}
	
	public ArrayList<Dog> getDoggieBag()
	{
		return DogBag;
	}
	
	public void addDog(Dog d)
	{
		DogBag.add(d);
	}
	
	public void deleteDog(Dog d)
	{
		DogBag.remove(d);
	}
}
