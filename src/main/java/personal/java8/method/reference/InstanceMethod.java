package personal.java8.method.reference;

interface Sayable2{  
    void say();  
}  

public class InstanceMethod {

    public void saySomething(){  
        System.out.println("Hello, this is non-static method.");  
    }  
    public static void main(String[] args) {  
    	InstanceMethod methodReference = new InstanceMethod(); // Creating object  
        // Referring non-static method using reference  
            Sayable2 sayable = methodReference::saySomething;  
        // Calling interface method  
            sayable.say();  
            // Referring non-static method using anonymous object  
            Sayable2 sayable2 = new InstanceMethod()::saySomething; // You can use anonymous object also  
            // Calling interface method  
            sayable2.say();  
    }  
}
