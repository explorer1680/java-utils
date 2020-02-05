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
			byte byteArray[] = msg.getBytes(); // Converting string into byte
												// array
			fileOutputStream.write(byteArray); // Writing data into file
			System.out.println("------------Data written into file--------------");
			System.out.println(msg);
			// -----------------------------Code to read data from
			// file---------------------------------------------//
//			DataInputStream inst = new DataInputStream(input);
			int data = input.available();
			// Returns an estimate of the number of bytes that can be read from
			// this input stream.
			byte[] byteArray2 = new byte[data]; //
			inst.read(byteArray2);
			String str = new String(byteArray2); // passing byte array into
													// String constructor
			System.out.println("------------Data read from file--------------");
			System.out.println(str); // display file data
		} catch (Exception exception) {
			System.out.println(exception);
		} finally {
			System.out.println("Finally executes after closing of declared resources.");
		}
	}

}
