package personal.generic;

import java.util.ArrayList;
import java.util.List;

public class WildCards {



    public void extend(){
        List<? extends Number> listNumber;

        List<Integer> listInteger = new ArrayList<>();
        listInteger.add(1);
        listInteger.add(2);

        listNumber = listInteger;
        System.out.println(listNumber.get(0));
        System.out.println(listNumber.get(1) instanceof Integer);

        listInteger.add(2);
//        listNumber.add(3);
    }

    public void superr(){
        System.out.println("------------------------------");
        List<? super Integer> listInteger;

        List<Number> listNumber = new ArrayList<>();
        Number aNumber = new Double(1.4);
        listNumber.add(aNumber);

        listInteger = listNumber;
        System.out.println(listInteger.get(0));
        System.out.println(listInteger.get(0) instanceof Integer);
        System.out.println(listInteger.get(0) instanceof Number);


//        listInteger.add(3.4);
        listInteger.add(3);

        System.out.println(listInteger.get(1));
        System.out.println(listInteger.get(1) instanceof Integer);
        System.out.println(listInteger.get(1) instanceof Number);

//        listNumber
    }

    public static void main(String[] args) {
        WildCards test = new WildCards();
        test.extend();
        test.superr();
    }
}
