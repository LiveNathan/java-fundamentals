package labs_examples.lambdas.labs;

/* Lambdas Exercise 2:
 *      1) Demonstrate the use of 10 pre-built Functional Interfaces from the java.util.functions package. That's right,
 *      10 of them! You can do it! You'll know so much about them when you're done!
 */

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.*;

public class Exercise_02 {
    public static void main(String[] args) {
        // 1. Function
        Function<Double, Double> squareRootLambda = Math::sqrt;
        System.out.println("The square root of " + 5 + " is " + squareRootLambda.apply(5.0));

        // 2. Consumer
        Consumer<Integer> printIntegerSquared = x -> System.out.print(x*x);
        System.out.print("2 squared is "); printIntegerSquared.accept(2);

        // 3. Supplier
        Supplier<Double> randomDouble0to1 = Math::random;
        System.out.println("\nA random double between 0 and 1: " + randomDouble0to1.get());

        // 4. Predicate
        Predicate<Integer> isPositiveInteger = x -> (x>0);
        int a = 6;
        System.out.println(a + " is a positive number: " + isPositiveInteger.test(a));

        // 5. UnaryOperator
        UnaryOperator<String> addTxtFileExtension = text -> text + ".txt";
        System.out.println(addTxtFileExtension.apply("greatness"));

        // 6. IntFunction
        IntFunction<Double> cubed = x -> Math.pow(x, 3);
        System.out.println(cubed.apply(2));

        // 7. Runnable
        Runnable runnable = () -> System.out.println("I am a runnable.");
        new Thread(runnable).start();

        // 8. Callable
        Callable<String> callable = () -> "I am the string you asked for.";
        try {
            System.out.println(callable.call());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 9. Comparator
        Comparator<Integer> integerComparator = Integer::compareTo;
        System.out.println(integerComparator.compare(2, 1));

        // 10. BinaryOperator
        BinaryOperator<Integer> integerBinaryOperator = Integer::sum;
        System.out.println(integerBinaryOperator.apply(3, 5));
    }
}