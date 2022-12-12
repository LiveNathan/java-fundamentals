package labs_examples.lambdas.labs;

/* Lambdas Exercise 3:
 *      1) Demonstrate the use of a static method reference
 *      2) Demonstrate the use of an instance method reference
 *      3) Demonstrate the use of a constructor reference
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Exercise_03 {
    public static void main(String[] args) {
        // 3.1
        Function<Double, Double> squareRootFunction = Math::sqrt;
        System.out.println("The square root of " + 5 + " is " + squareRootFunction.apply(5.0));

        // 3.2
//        Even even = new Even();
        Pie<Even, Integer, Boolean> pie = Even::isEven;
        System.out.println("The number 3 is even: " + pie.slice(new Even(), 3));

        // Another example from the internet
        TriFunction<Sum, String, String, Integer> mRef = Sum::doSum;

        // 3.3
        Supplier<ArrayList<Integer>> arrayList = ArrayList::new;
        ArrayList<Integer> arrayList1 = arrayList.get();
    }
}

@FunctionalInterface
interface Pie<T, U, R> {
    R slice(T t, U u);
}

class Even {
    boolean isEven(int number) {
        return number % 2 == 0;
    }
}

interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

class Sum {
    Integer doSum(String s1, String s2) {
        return Integer.parseInt(s1) + Integer.parseInt(s1);
    }
}