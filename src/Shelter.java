import java.sql.ResultSet;

public class Shelter
{
	private int shelterID;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String link;
	private UniversalDogDB db;
	private Dog dog;
	
	public Shelter()
	{
		shelterID= 0;
		name = "";
		address = "";
		phone = "";
		email = "";
		link = "";
	}
	
	public void setShelterID(int id){
		dog.setDogID(id);
		dog.setDogInfo(id);
		shelterID = Integer.parseInt(dog.getShelter());
	}
	
	public void setShelterInfo(long id){
		try{
			db = new UniversalDogDB();
			String q = "select * from ADOPTION_AGENCY where AGENCY_ID = " + id +";";
			System.out.println(q);
			db.retrieveData(q);
			ResultSet rs = db.getResultSet();
			
			if(rs.next()){
				shelterID = rs.getInt("AGENCY_ID");
				name = rs.getString("AGENCY_Name");
				address = rs.getString("AGENCY_Location");
				link = rs.getString("AGENCY_Website");
				phone = rs.getString("AGENCY_Phone_Number");
				email = rs.getString("AGENCY_Email");
			}
		}catch(Exception shelterFail){
			System.out.println(shelterFail);
		}
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getAddress()
	{
		return address;
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
	
	public void setLink(String link)
	{
		this.link = link;
	}
	public String getLink()
	{
		return link;
	}
	public int getShelterID(){
		return shelterID;
	}
}
