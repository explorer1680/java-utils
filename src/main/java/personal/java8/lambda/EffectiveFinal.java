package personal.java8.lambda;

//http://ilkinulas.github.io/programming/java/2016/03/27/effectively-final-java.html
public class EffectiveFinal {
	public static void main(String[] args){
		for (int i = 0; i < 10; i++) {
		    new Thread(() -> {
//		        System.out.println("i = " + i); // Does not compile!
		    	System.out.println(Thread.currentThread().getName());
		    }).start();
		}
	}
}
