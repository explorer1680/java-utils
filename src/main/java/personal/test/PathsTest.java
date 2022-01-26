package personal.test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsTest {
	public static void main(String[] args) {
		Path p1 = Paths.get("/abc/123");
		Path p2 = Paths.get(File.separator + "abc" + File.separator + "123");
		System.out.println(p1);
		System.out.println(p2);
		
	}

}
