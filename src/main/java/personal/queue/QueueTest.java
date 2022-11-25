package personal.queue;

public class QueueTest {
	
	
	
	public static void main(String[] args) {
		
		
		Queue<String> ivq = new Queue<>();
		
		
		ivq.push("A");
		ivq.push("B");
		ivq.push("C");
		ivq.push("C");
		
		System.out.println(ivq.pop());
		System.out.println(ivq.pop());
		System.out.println(ivq.pop());
		
		
	}

}
