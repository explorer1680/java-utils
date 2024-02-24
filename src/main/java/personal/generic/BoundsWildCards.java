package personal.generic;

import java.util.ArrayList;
import java.util.List;

public class BoundsWildCards {

    public static void main(String[] args) {
        List<Parent> parentList = new ArrayList<>();
        parentList.add(new Parent());

        List<? super Child> childList = parentList;
        childList.set(0, new Child());
//        Child child = childList.get(0);
    }

}

class GrandParent {}

class Parent extends GrandParent{}

class Child extends Parent{}