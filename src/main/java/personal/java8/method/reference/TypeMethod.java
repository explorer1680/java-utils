package personal.java8.method.reference;


interface TypeInterface{
	//Please note, it has the TypeMethod as the parameter
	String getInfo(TypeMethod t);
}

interface TypeInterface2{
	//It has the TypeMethod as the first parameter
	String apply(TypeMethod t, String s);
}

interface NormalInterface{
	String hello();
}

public class TypeMethod {
	
	private String name;
	
	public TypeMethod(String s) {
		this.name = s;
	}
	
	
	private static String getString() {
		return "abc";
	}
	
	private String getName() {
		return this.name;
	}
	
	private String hello(String s) {
		return this.name + s;
	}
	
	private String getInfo(TypeMethod t) {
		return t.name;
	}
	
	public static void main(String[] args) {
		
		TypeMethod typeInstance = new TypeMethod("ABC");
		
		//Here, you provide:
		//Reference to an instance method of an arbitrary object of a particular type
		//this method expect an TypeMethod instance as the parameter
		TypeInterface t1 = TypeMethod::getName;
		//You provide this instance when use it.
		t1.getInfo(typeInstance);
		//to be more accurate, it expect an TypeMethod instance as the first parameter
		TypeInterface2 t2 = TypeMethod::hello;
		t2.apply(typeInstance, "Hello");
		
		//Reference to an instance method of a particular object do not expect extra parameter.
		NormalInterface n = typeInstance::getName;
		//No instance provided
		n.hello();
		
		//getString is static method, it does not expect extra parameter.
		NormalInterface ns = TypeMethod::getString;
		
		//You can all provide implementation to TypeInterface by: Reference to an instance method of a particular object
		TypeInterface t3 = typeInstance::getInfo;
		//So, the special thing is not about the definition of Functional Interface
		//The special thing is about: Reference to an instance method of an arbitrary object of a particular type
		//the other implementation just provide a method, and call this method directly
		//but, the Reference to an instance method of an arbitrary object of a particular type
		//will expect an instance, and call the instance.method
		//that means it not only provide a method, but also specify how to call this method, and where to get the instance
		//the usage of the implementation or definition of interface will provide the instance as the first parameter.
		
		
	}
}

