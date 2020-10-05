package personal.stacktrace;

public class C {
	
	public void methodC() throws ExceptionC {
		B b = new B();
		try {
			b.methodB();
		} catch (ExceptionB e) {
			throw new ExceptionC(e);
		}
	}

}
