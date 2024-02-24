package quickcheck;

public class ErrorAndUncheckedExceptionTest {
    public static void main(String[] args) {
        try{
//            int i = 1/0;
            throw new Error("Hello");
        }catch (Exception e){
            System.out.println("I am here");
        }catch (Error e){
            System.out.println("catch an error");
        }
        System.out.println("I am there");
    }
}
