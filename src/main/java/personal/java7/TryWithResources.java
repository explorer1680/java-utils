package personal.java7;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class TryWithResources {

	public static void main(String args[]) {
		try ( // Here is the new syntax, try(...){...},  before only try{...}
				// Using multiple resources, implements java.lang.AutoCloseable,
				// which includes all objects which implement java.io.Closeable.
				FileOutputStream fileOutputStream = new FileOutputStream(
						System.getProperty("user.home") + "/work/temp/abc.txt");
				InputStream input = new FileInputStream(System.getProperty("user.home") + "/work/temp/abc.txt");
				DataInputStream inst = new DataInputStream(input);
				/*Integer i = Integer(0)*/) {
			String msg = "Welcome to javaTpoint!";
			byte byteArray[] = msg.getBytes(); 
			fileOutputStream.write(byteArray);
			System.out.println("------------Data written into file--------------");
			System.out.println(msg);
			int data = input.available();
			byte[] byteArray2 = new byte[data]; 
			inst.read(byteArray2);
			String str = new String(byteArray2); 
			System.out.println("------------Data read from file--------------");
			System.out.println(str); 
		} catch (Exception exception) {
			System.out.println(exception);
		} finally {
			System.out.println("Finally executes after closing of declared resources.");
		}
	}

}
