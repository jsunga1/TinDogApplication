
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
	
	public void setName(String name)
	{
		dogName = name;
	}
	public String getName()
	{
		return dogName;
	}
	
	public void setAge(int age)
	{
		dogAge = age;
	}
	public int getAge()
	{
		return dogAge;
	}
	
	public void setBreed(String breed)
	{
		dogBreed = breed;
	}
	public String getBreed()
	{
		return dogBreed;
	}
	
	public void setGender(int gender)
	{
		this.gender = gender;
	}
	public int getGender()
	{
		return gender;
	}
	
	public void setShelter(String shelter)
	{
		dogShelter = shelter;
	}
	public String getShelter()
	{
		return dogShelter;
	}
	
	public void setDescription(String des)
	{
		dogDescription = des;
	}
	public String getDescription()
	{
		return dogDescription;
	}
	
	public void setPicture(String pic)
	{
		dogPic = pic;
	}
	public String getPicture()
	{
		return dogPic;
	}
	
	public void setStatus(boolean status)
	{
		dogStatus = status;
	}
	public boolean getStatus()
	{
		return dogStatus;
	}
}
