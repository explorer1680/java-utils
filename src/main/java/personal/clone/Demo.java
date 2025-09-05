package personal.clone;

public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {

        MyClass myClass = new MyClass("abc", 12);
        MyClass hisClass = myClass.clone();

        System.out.println(hisClass);

        Object obj = new Object();
        //this call is not available,
//        obj.clone();

    }
}
