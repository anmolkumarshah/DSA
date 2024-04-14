package lambda;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Main
 */

interface Person {
    String greeting();
}

// preDefined functional interface : Predicate, function, Consumer, supplier

public class Main {

    static Person p = () -> {
        return "Good Night";
    };

    static Predicate<Integer> isEven = (Integer n) -> n % 2 == 0;
    static Function<String, Integer> countNumbers = (String str) -> str.length();
    static Consumer<Integer> display = (val) -> {
        System.out.println(val);
    };
    static Supplier<Date> currentDate = () -> {
        return new Date();
    };

    public static void main(String[] args) {
        System.out.println(p.greeting());
        System.out.println(isEven.test(23));
        display.accept(countNumbers.apply("Anmol"));
        System.out.println(currentDate.get());
    }
}