package personal.java8.constructor;

public class Person {

    private String name;
    private int age;

    public Person(){}

    public Person(String name){
        this.name = name;
        this.age = 10;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

//    public Person(String s, int i) {
//    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
