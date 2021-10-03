package personal.java8.method.reference;

//the reference constructor is a way to create Object.
interface Messageable {
	Message getMessage(String msg);
}

class Message {
	private String msg;

	Message(String msg) {
		this.msg = msg;
		System.out.print(this.msg);
	}
}

public class ReferenceConstructor {

	public static void main(String[] args) {
		Messageable hello = Message::new;
		hello.getMessage("Hello");
	}
}
