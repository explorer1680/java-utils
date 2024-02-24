package personal.test;

import org.apache.kafka.common.protocol.types.Field;

public class ParentChild {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.getStr());
        Parent p = new Child();
        System.out.println(p.str1);
    }
}


class Parent{
    private String str ="abc";
    public String str1 = "abc1";

    public String getStr() {
        return str;
    }

    public void method(){

    }
}

class Child extends Parent{

    private String str = "dec";
    public String str1 = "dec1";

    public Child(String str){
//        this();
    }
    public Child(){
//        super();
        this("abc");
        System.out.println("in the Child");
    }

    @Override
//    public void method() throws Error{
    public void method() throws RuntimeException{
    }
}
