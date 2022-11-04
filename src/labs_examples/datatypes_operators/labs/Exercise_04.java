package labs_examples.datatypes_operators.labs;

import java.util.Scanner;

/**
 * Please demonstrate the use of all relational operators below. These include:
 * <p>
 * less than, less than or equal to, greater than, greater than or equal to, and equal to
 */
class RelationalOperators {

    public static void main(String[] args) {

        Scanner numbers = new Scanner(System.in);
        System.out.println("a: ");
        float a = numbers.nextFloat();
        System.out.printf("%nb: ");
        float b = numbers.nextFloat();

        if (a < b)
            System.out.printf("%n%f is less than %f.", a, b);

        if (a >= b)
            System.out.printf("%n%f is greater than or equal to %f.", a, b);

        if (a > b)
            System.out.printf("%n%f is greater than than %f.", a, b);

        if (a >= b)
            System.out.printf("%n%f is greater than or equal to %f.", a, b);

        if (a == b)
            System.out.printf("%n%f is equal to %f.", a, b);

    }

}

