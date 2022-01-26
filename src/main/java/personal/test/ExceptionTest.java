package personal.test;

public class ExceptionTest {
	public static void main(String[] args) throws Exception {
		try {
			throw new MyException("hello");
		}catch(MyException e) {
			throw new Exception("A exception", e);
//			throw new Exception(e);
		}
		
	}
}
