package personal.java8.method.reference;


interface TypeInterface1{
	//Please note, it has the TypeMethod as the parameter
	String apply1(TypeMethod t);
}

interface TypeInterface2{
	//It has the TypeMethod as the first parameter
	String apply2(TypeMethod t, String s);
}

interface TypeInterface0{
	String apply0();
}

interface TypeInterface1_2{
	String apply1_2(String s);
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
		return this.name + " getName";
	}
	
	private String hello(String s) {
		return this.name + s;
	}
	
	private String getInfo(TypeMethod t) {
		return t.name + " getInfo" + this.name;
	}
	
	public static void main(String[] args) {
		
		TypeMethod typeInstance1 = new TypeMethod("ABC");
		TypeMethod typeInstance2 = new TypeMethod("123");
		
		//Here, you provide:
		//Reference to an instance method of an arbitrary object of a particular type
		//when you provide this kind of method reference, you expect the method call provide the instance as the first parameter
		//That means, when you provide this kind of method reference:
		//1. the Type must be the type of the first parameter on the Functional Interface.
		//2. the method has less than 1 parameters of the Functional Interface.
		//in this example:
		//the TypeInterface1's method take TypeMethod as first parameter, you can provide TypeMethod::xxx as method reference.
		//the TypeInterface1's method take 1 parameter, the getName take 0 parameter.
		TypeInterface1 t1 = TypeMethod::getName;
		//You provide this instance when use it.
		System.out.println(t1.apply1(typeInstance1));
		
		//following not working:
//		TypeInterface1 t12 = TypeMethod::hello; //hello take 1 parameter
//		TypeInterface1 t12 = TypeMethod::getInfo; //getInfo take 1 parameter
		
//		Following works
		//the Reference to an instance method of a particular object is normal
		TypeInterface1 t12 = typeInstance1::getInfo;
		//looks it also provide 1 parameter, but, this just happen to be type TypeMethod
		//it not means, the method call on typeInstance2
		//it still call on typeInstance1,
		//you can add this.name in getInfo
		System.out.println(t12.apply1(typeInstance2));
		
		
		//this example clearly shows the Reference to an instance method of a particular object is normal, it is different from
		//Reference to an instance method of an arbitrary object of a particular type
		TypeInterface1_2 t1_2 = typeInstance1::hello;
		System.out.println(t1_2.apply1_2("ni hao"));
		
		//For Reference to an instance method of an arbitrary object of a particular type
		//when calling the method, the first parameter is the receiver of the this call
		//the other method reference is just normal parameter.
		
		
		//to be more accurate, it expect an TypeMethod instance as the first parameter
		TypeInterface2 t2 = TypeMethod::hello;
		System.out.println(t2.apply2(typeInstance1, "Hello"));
		
		//Reference to an instance method of a particular object do not expect extra parameter.
		TypeInterface0 n = typeInstance1::getName;
		//No instance provided
		System.out.println(n.apply0());
		
		//This is not working:
//		TypeInterface0 n2 = TypeMethod::getName;
		
		//getString is static method, it does not expect extra parameter.
		TypeInterface0 ns = TypeMethod::getString;
		System.out.println(ns.apply0());
		
		//You can also provide implementation to TypeInterface by: Reference to an instance method of a particular object
		//but this method must take a Type of this instance as first parameter.
		TypeInterface1 t3 = typeInstance1::getInfo;
		System.out.println(t3.apply1(typeInstance2));
		
		
		
		//this not working:
//		TypeInterface1 t4 = typeInstance::getName;
//		TypeInterface1 t4 = typeInstance::hello;
		//the TypeInterface.getInfo have one parameter, you need to provide at least one parameter to it.
		
		
		//So, the special thing is not about the definition of Functional Interface
		//The special thing is about: Reference to an instance method of an arbitrary object of a particular type
		//the other implementation just provide a method, and call this method directly
		//but, the Reference to an instance method of an arbitrary object of a particular type
		//will expect an instance of the type of the first parameter, and this instance will be the receiver of the call.
		//call the instance.method
		//that means it not only provide a method, but also specify how to call this method, and where to get the instance
		//the call of interface will provide the instance as the first parameter.
		
	}
}

