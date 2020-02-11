package personal.java8;

import java.util.ArrayList;
import java.util.List;

public class ForEach {
	public static void main(String[] args) {  
        List<String> gamesList = new ArrayList<String>();  
        gamesList.add("Football");  
        gamesList.add("Cricket");  
        gamesList.add("Chess");  
        gamesList.add("Hocky");  
        System.out.println("------------Iterating by passing method reference---------------");  
        gamesList.forEach(System.out::println);  
//        gamesList.forEach(System.out.println);  //this is a statement, not a method reference.
        gamesList.forEach((a) -> System.out.println(a));
    }  
}
