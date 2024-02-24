package personal.nestedclass;

import java.util.function.Function;
import java.util.stream.IntStream;

public class AnonymousClass {
    public void method(){
        new Function<String, String>() {
            @Override
            public String apply(String s) {
                return null;
            }
        };
    }
}
