
import java.util.*;

public class User
{
	private DoggieBag db;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	public User()
	{
		db = new DoggieBag();
		name = "User";
		email = "User";
		phone = "User";
		password = "User";
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return email;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getPhone()
	{
		return phone;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return password;
	}
	
	public void addDog(Dog d)
	{
		db.addDog(d);
	}
}
