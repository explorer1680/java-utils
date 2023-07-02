package personal.java8.optional;

import java.util.Optional;

public class Demo {

    public static void main(String[] args) {
        //this will throw exception
//        Optional<String> optionalString = Optional.of(null);
        Optional<String> optionalString = Optional.ofNullable(null);

        //this will throw exception
//        optionalString.get();

        Male male = new Male();
        male.age = Optional.of(28);

        Human human = new Human();
        human.male = Optional.of(male);

        Employee employee = new Employee();
        employee.human = Optional.of(human);

        employee.getHuman().flatMap(Human::getMale).flatMap(Male::getAge).ifPresent(System.out::println);


        Male2 male2 = new Male2();
        male2.setAge(30);

        Human2 human2 = new Human2();
//        human2.setMale2(male2);

        Employee2 employee2 = new Employee2();
        employee2.setHuman2(human2);

        Optional.ofNullable(employee2.getHuman2()).map(Human2::getMale2).map(Male2::getAge).ifPresent(System.out::println);
    }
}
