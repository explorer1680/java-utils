package interview;

public class Interview {
	
	
	
	public static void main(String[] args) {
		
		
		InterViewQueue<String> ivq = new InterViewQueue<>();
		
		
		ivq.push("A");
		ivq.push("B");
		ivq.push("C");
		ivq.push("C");
		
		System.out.println(ivq.pop());
		System.out.println(ivq.pop());
		
		
	}

}
