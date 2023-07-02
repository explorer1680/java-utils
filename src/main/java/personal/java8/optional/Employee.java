package personal.java8.optional;

import java.util.Optional;

public class Employee {
    Optional<Human> human;

    public Optional<Human> getHuman() {
        return human;
    }

    public void setHuman(Optional<Human> human) {
        this.human = human;
    }
}
