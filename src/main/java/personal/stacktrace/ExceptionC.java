package personal.stacktrace;

public class ExceptionC extends Exception{

	public ExceptionC() {
		super();
	}

	public ExceptionC(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExceptionC(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionC(String message) {
		super(message);
	}

	public ExceptionC(Throwable cause) {
		super(cause);
	}
	
}
