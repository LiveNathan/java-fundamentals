package labs_examples.lambdas.labs;

import java.util.function.Predicate;

public class playgroundStaticMethodReference {
    public static void main(String[] args) {

        // Step 1) modify the Predicate below to use a Method Reference rather than a Lambda expression

        Predicate<Integer> p1 = NumberUtil::isEven;

        boolean result = p1.test(4);
        boolean result2 = p1.test(5);
        System.out.println(result + " & " + result2);
    }
}

class NumberUtil {
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
}