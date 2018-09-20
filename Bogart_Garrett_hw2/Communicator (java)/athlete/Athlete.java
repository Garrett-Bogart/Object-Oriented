package athlete;

public class Athlete {
	private String firstName;
	private String lastName;
	private int time;
	private int age;
	//private int clients[];
	private int ID;
	private char gender;
	private Status status;

	
	public Athlete(int ID, int time, String firstName, String lastName, char gender, int age ) 
	{
		this.firstName= firstName;
		this.lastName= lastName;
		this.time= time;
		this.age= age;
		this.ID = ID;
		this.gender= gender;
		this.status = Status.Registered;//might change to an 
	}
	
	public int getID() {return ID;}
	public int getTime() {return time;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public char getGender() {return gender;}
	public int getAge() {return age;}
	public Status getStatus() {return status;}
	
	public void setID(int ID) {this.ID = ID;}
	public void setTime(int time) {this.time= time;}
	public void setFirstName(String firstName) {this.firstName= firstName;}
	public void setLastName(String lastName) {this.lastName= lastName;}
	public void setGender(char gender) {this.gender= gender;}
	public void setAge(int age) {this.age= age;}
	public void setStatus(Status status) {this.status = status;}
}
