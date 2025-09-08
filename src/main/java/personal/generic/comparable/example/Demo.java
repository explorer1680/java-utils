package personal.generic.comparable.example;

import personal.stacktrace.A;

import java.util.ArrayList;
import java.util.List;

public class Demo<T> {

    private T t;

    public static void main(String[] args) {
        List<Fruit> list1= new ArrayList<>();
        List<Apple> list2 = new ArrayList<>();

        Demo<Fruit> fruitDemo = new Demo<>();
        fruitDemo.method1(list1);
        fruitDemo.method1(list2);

        fruitDemo.method2(list1);
        //following is not working for <T extends Comparable<T>>
//        fruitDemo.method2(list2);

        fruitDemo.method3(new Fruit());
        fruitDemo.method3(new Apple());
//      this is working
        fruitDemo.method4(new Fruit());
        fruitDemo.method4(new Apple());

    }


    public  <T extends Comparable<? super T>> void method1(List<T> list){
    }

    public  <T extends Comparable<T>> void method2(List<T> list){
    }

    public  <T extends Comparable<? super T>> void method3(T t){
    }

    public  <T extends Comparable<T>> void method4(T t){
    }


}
