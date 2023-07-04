package quickcheck;

public class SingletonPeople implements Cloneable{
	
	private static volatile SingletonPeople singleton = null;
	
	private SingletonPeople() {}

//https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples
	public static synchronized SingletonPeople getInstanceWay2(){		//this approach is correct, but, with synchronized on the method directly, every call maybe wait.
		if (SingletonPeople.singleton == null) {
			SingletonPeople.singleton = new SingletonPeople();
		}
		return SingletonPeople.singleton;
	}

	public static SingletonPeople getSingleton() {
		if (SingletonPeople.singleton == null) {
//			Object obj = new Object();
			synchronized(Object.class) {
				if (SingletonPeople.singleton == null) {					//this SingletonPeople.singleton maybe not the latest(current) value, need "volatile"
					SingletonPeople.singleton = new SingletonPeople();
				}
			}
			
		}
		return SingletonPeople.singleton;
	}

	public static SingletonPeople getSingleton3() {
		if (SingletonPeople.singleton == null) {
			Object obj = new Object();
			synchronized(obj) {									//this obj is not the same one in the different Thread
				if (SingletonPeople.singleton == null) {
					SingletonPeople.singleton = new SingletonPeople();
				}
			}

		}
		return SingletonPeople.singleton;
	}

	public static SingletonPeople getSingleton2() {
		if (SingletonPeople.singleton == null) {				//this should be checked again
			Object obj = new Object();
			synchronized(obj) {
				SingletonPeople.singleton = new SingletonPeople();
			}

		}
		return SingletonPeople.singleton;
	}

	public static SingletonPeople getSingleton1() {
		if (SingletonPeople.singleton == null) {
			SingletonPeople.singleton = new SingletonPeople();	//this need protected
		}
		return SingletonPeople.singleton;
	}

	
	public static void main(String[] args) throws CloneNotSupportedException {
		SingletonPeople p1 = SingletonPeople.getSingleton();
		SingletonPeople p2 = SingletonPeople.getSingleton();
		
		System.out.println(p1 == p2);
		
		
		SingletonPeople p1Copy = p1.clone();
		
		System.out.println("p1 == p1Copy: " + (p1 == p1Copy));
		
		System.out.println("p1.firstName == p1Copy.firstName: " + (p1.getFirstName() == p1Copy.getFirstName()));
	}
	
	
	private String firstName;
	private String lastName;
	
	public SingletonPeople clone() throws CloneNotSupportedException {
		return (SingletonPeople) super.clone();
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
