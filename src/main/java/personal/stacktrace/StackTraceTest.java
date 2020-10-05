package personal.stacktrace;

public class StackTraceTest {
	
	public static void main(String[] args){
		C c = new C();
		try {
			c.methodC();
		} catch (ExceptionC e) {
			e.printStackTrace();
		}
	}

}
