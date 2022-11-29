package labs_examples.exception_handling.labs;

import java.util.Arrays;

/**
 * Exception Handling Exercise 5:
 * <p>
 * Demonstrate how to throw an exception.
 */

class Exercise_05 {
    public static void main(String[] args) throws ArithmeticException {
        int a = 1;
        int b = 0;
        int c = Division.customDivide(a, b);
        System.out.println(c);
    }
}

class Division {
    static int customDivide(int a, int b) throws ArithmeticException {
        if (b == 0 | a == 0) {
            throw new ArithmeticException();
        } else {
            return a / b;
        }
    }
}