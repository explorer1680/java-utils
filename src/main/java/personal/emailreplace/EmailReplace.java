package personal.emailreplace;

public class EmailReplace {
	
	public static void main(String[] args) {
		String str = "echeng@realmatters.com";
		str = str.replaceAll("(\\w{1})(\\w+)(\\w{1})(@.*)", "$1****$3$4");
		System.out.println(str);
	}

}
