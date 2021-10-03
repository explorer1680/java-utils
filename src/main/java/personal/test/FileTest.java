package personal.test;

import java.io.File;
import java.io.IOException;

public class FileTest {
	
	public static void main(String[] args) throws IOException {
		File file = new File("/Users/echeng/work/tmp/mytestfile");
//		file.createNewFile();
		if(! file.exists()) {
			System.out.println("not exist");
		}
		
		System.out.println("test");
	}

}
