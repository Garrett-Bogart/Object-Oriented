package athlete;

public class Athlete {
	private String firstName;
	private String lastName;
	private String time;
	private String age;
	//private int clients[];
	private String ID;
	private String gender;
	private String status;

	
	public Athlete(String ID, String time, String firstName, String lastName, String gender, String age, String status ) 
	{
		this.firstName= firstName;
		this.lastName= lastName;
		this.time= time;
		this.age= age;
		this.ID = ID;
		this.gender= gender;
		this.status =status;
	}
	
	public String getID() {return ID;}
	public String getTime() {return time;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getGender() {return gender;}
	public String getAge() {return age;}
	public String getStatus() {return status;}
	
	public void setID(String ID) {this.ID = ID;}
	public void setTime(String time) {this.time= time;}
	public void setFirstName(String firstName) {this.firstName= firstName;}
	public void setLastName(String lastName) {this.lastName= lastName;}
	public void setGender(String gender) {this.gender= gender;}
	public void setAge(String age) {this.age= age;}
	public void setStatus(String status) {this.status = status;}
}
