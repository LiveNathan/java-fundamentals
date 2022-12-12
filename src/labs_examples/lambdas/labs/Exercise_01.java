package labs_examples.lambdas.labs;

/* Lambdas Exercise 1:
 *
 *      1) Demonstrate creating a functional interface with an abstract method that takes no parameters and returns void
 *      2) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      3) Demonstrate creating a functional interface with an abstract method that takes 1 parameter and returns a
 *          value of the same type as the parameter
 *      4) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      5) Demonstrate creating a functional interface with an abstract method that takes 2 parameters and returns a
 *          value
 *      6) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      7) Demonstrate the use of at least two built-in functional interfaces from the java.util.function package.
 */

import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Exercise_01 {
    public static void main(String[] args) {
        // 1.2
        Bread sourdough = () -> System.out.println("Lambda sourdough bread.");
        sourdough.drift();
        // Anonymous inner class
        Bread bread = new Bread() {
            @Override
            public void drift() {
                System.out.println("Anonymous sourdough bread.");
            }
        };
        bread.drift();

        // 1.4
        Wealth<String> wealth = (x) -> "I will fund my wealth with lambda " + x + ".";
        System.out.println(wealth.fund("goats"));
        // Anonymous inner class
        Wealth<String> wealth1 = new Wealth<String>() {
            @Override
            public String fund(String s) {
                return "I will fund my wealth with anonymous " + s + ".";
            }
        };
        System.out.println(wealth1.fund("goats"));

        // 1.6
        Meat meat = (max, min) -> new Random().nextInt(max-min) + min;  // Find a random int between y and x.
        System.out.println(meat.dare(10, 1));
        // Anonymous inner class
        Meat meat1 = new Meat() {
            @Override
            public int dare(int x, int y) {
                return x/y;
            }
        };
        System.out.println(meat1.dare(100, 10));

        // 1.7
        Predicate<Integer> isPositiveNumber = x -> (x > 0);
        int song = -5;
        System.out.println(song + " is a positive number: " + isPositiveNumber.test(-5));

        Supplier<Integer> randomNumber0to100 = () -> (int) (Math.random() * 100);
        System.out.println("A random number from 0 to 100: " + randomNumber0to100.get());
    }
}

// 1.1
@FunctionalInterface
interface Bread {
    void drift();
}

// 1.3
@FunctionalInterface
interface Wealth<T> {
    T fund(T t);
}

// 1.5
@FunctionalInterface
interface Meat {
    int dare(int x, int y);
}