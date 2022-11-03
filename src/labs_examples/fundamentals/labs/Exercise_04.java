package labs_examples.fundamentals.labs;

/**
 * Fundamentals Exercise 4: My Second Program
 * <p>
 * Write the necessary code to display, declare and print each of Java's primitive data types.
 * Please declare a single variable of each type, give it an appropriate value, then print that variable.
 */

public class Exercise_04 {

    public static void main(String[] args) {

        // char
        char letter = 'A';
        System.out.println("letter = " + letter);

        // byte
        byte b = 127;
        System.out.println("byte = " + b);

        // short
        short shortVal = 32767;
        System.out.println("short = " + shortVal);

        // int
        int intVal = 2147;
        System.out.println("integer = " + intVal);

        // long
        long longVal = 1234123412341234L;
        System.out.println("long = " + longVal);

        // float
        float floatVal = 41234.12341234f;
        System.out.println("float = " + floatVal);

        // double
        double doubleVal = 1234.1234;
        System.out.println("double = " + doubleVal);

    }

}
