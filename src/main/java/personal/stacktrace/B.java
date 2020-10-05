package personal.stacktrace;

public class B {
	
	public void methodBB() throws ExceptionB {
		A a = new A();
		try {
			a.methodA();
		} catch (ExceptionA e) {
			throw new ExceptionB(e);
		}
	}
	
	public void methodB() throws ExceptionB {
		methodBB();
	}
	
	
}
