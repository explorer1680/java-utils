package test;

public class GCTest {
	
	public static void main(String[] args) throws InterruptedException{
		GCTest t1 = new GCTest();
		
		System.out.println("t1 address: " + t1);
		GCTest t2 = m1(t1);
		System.out.println("t2 address: " + t2);
		GCTest t3 = new GCTest();
		t2 = t3;
		
		System.gc();
		Thread.sleep(10000);
		
	}

	static GCTest m1(GCTest temp){
		System.out.println("temp address 1: " + temp);
		temp = new GCTest();
		System.out.println("temp address 2: " + temp);
		return temp;
	}
	
	protected void finalize(){
		System.out.println(this.toString() + " successfully garbage collected");
	}
}
