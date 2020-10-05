package personal.stacktrace;

public class ExceptionA extends Exception{

	public ExceptionA() {
		super();
	}

	public ExceptionA(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExceptionA(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionA(String message) {
		super(message);
	}

	public ExceptionA(Throwable cause) {
		super(cause);
	}
	
	

}
