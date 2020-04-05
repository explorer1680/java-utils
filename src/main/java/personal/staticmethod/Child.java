package personal.staticmethod;

public class Child extends Parent{
	
	public static void say(){
		System.out.println("Inside of child class.");
	}
	
	public static void main(String[] args){
		Child child = new Child();
		child.say();
	}

}
