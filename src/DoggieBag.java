import java.util.*;
import java.sql.*;

public class DoggieBag
{
	public ArrayList<Integer> DogBag;
	
	public DoggieBag()
	{
		DogBag = new ArrayList<Integer>();
	}
	
	public void fillBag(String user, int id)
	{
		UniversalDogDB db = new UniversalDogDB();
		String q = "Select DOG_Id from DOGGIEBAG where USER_Email = \"" + user + "\" AND DOG_Id = " + id;
		db.retrieveData(q);
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
	}
	
	/*public ArrayList<Dog> getDoggieBag()
	{
		return DogBag;
	}
	
	public void addDog(Dog d)
	{
		DogBag.add(d);
	}*/
	
	public void deleteDog(int i)
	{
		
	}
}
