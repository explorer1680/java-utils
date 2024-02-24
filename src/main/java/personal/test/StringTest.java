package personal.test;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);
        String s3 = new String("abc");
        System.out.println(s1 == s3);
        String s4 = new String("abc");
        System.out.println(s3 == s4);

    }
}
