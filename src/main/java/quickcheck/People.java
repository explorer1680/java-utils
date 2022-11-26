package quickcheck;

public class People implements Cloneable{
	
	private static People singleton = null;
	
	private People() {}

	public static People getSingleton() {
		if (People.singleton == null) {
			Object obj = new Object();
			synchronized(obj) {
				if (People.singleton == null) {
					People.singleton = new People();
				}
			}
			
		}
		return People.singleton;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		People p1 = People.getSingleton();
		People p2 = People.getSingleton();
		
		System.out.println(p1 == p2);
		
		
		People p1Copy = p1.clone();
		
		System.out.println("p1 == p1Copy: " + (p1 == p1Copy));
		
		System.out.println("p1.firstName == p1Copy.firstName: " + (p1.getFirstName() == p1Copy.getFirstName()));
	}
	
	
	private String firstName;
	private String lastName;
	
	public People clone() throws CloneNotSupportedException {
		return (People) super.clone();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
