package personal.java8.optional;

import java.util.Optional;

public class Human {
    Optional<Male> male;

    public Optional<Male> getMale() {
        return male;
    }

    public void setMale(Optional<Male> male) {
        this.male = male;
    }
}
