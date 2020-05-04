package personal.java8.method.reference;


/*
 * Please Note, there is no so called Class method.
 * By using Instance Method, the Functional Interface can take instance data.
 */
interface Sayable2{  
    void say();  
//    void second();//if you define the second abstract method, it will not working like this way.
}  

public class InstanceMethod {
	
	private String s;
	
	public InstanceMethod(String s){
		this.s = s;
	}

    public void saySomething(){  
        System.out.println("Hello, this is non-static method.");  
        System.out.println(s);  
    }  
    public static void main(String[] args) {  
    	InstanceMethod methodReference = new InstanceMethod("Hi"); // Creating object  
        // Referring non-static method using reference  
    		//	Please note, it is an FunctionalInterface equals to a method reference.
            Sayable2 sayable = methodReference::saySomething;  
        // Calling interface method  
            sayable.say();  
            // Referring non-static method using anonymous object  
            Sayable2 sayable2 = new InstanceMethod("Hello")::saySomething; // You can use anonymous object also  
            // Calling interface method  
            sayable2.say();  
    }  
}
