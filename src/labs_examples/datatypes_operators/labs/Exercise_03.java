package labs_examples.datatypes_operators.labs;

import java.util.Scanner;

/**
 * Please demonstrate the use of all arithmetic operators below. These include:
 * <p>
 * addition, subtraction, multiplication, division and modulus
 */
class ArithmeticOperators {

    public static void main(String[] args) {

        Scanner numbers = new Scanner(System.in);
        System.out.println("a: ");
        float a = numbers.nextFloat();
        System.out.printf("%nb: ");
        float b = numbers.nextFloat();
        System.out.printf("%n%f +  %f = %f", a, b, a + b);
        System.out.printf("%n%f -  %f = %f", a, b, a - b);
        System.out.printf("%n%f *  %f = %f", a, b, a * b);
        System.out.printf("%n%f /  %f = %f", a, b, a / b);
        System.out.printf("%nThe remainder of %f / %f = %f", a, b, a % b);

    }

}
