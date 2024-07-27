package personal.java8.constructor;

public class Demo {

    private void getPeopleWithoutName(TypeWithNoParam t0){
        System.out.println(t0.getPerson());
    }

    private void getPeopleWithOneName(TypeWithOneParam t1){
        System.out.println(t1.getPerson("John"));
    }

    private void getPeopleWithTwoName(TypeWithTwoParam t2){
        System.out.println(t2.getPerson("John", 20));
    }


    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.getPeopleWithoutName(Person::new);
        demo.getPeopleWithOneName(Person::new);
        demo.getPeopleWithTwoName(Person::new);


    }
}
