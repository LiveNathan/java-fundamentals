package labs_examples.conditions_loops.labs;

/**
 * Conditions and Loops Exercise 8: do-while loop
 * <p>
 * Use a "do-while" loop print out every third number counting backwards from 1000 to 1.
 */

public class Exercise_08 {
    public static void main(String[] args) {
        int iter = 1000;
        do {
            System.out.printf("The next 3rd number is %d.%n", iter);
            iter -= 3;
        } while (iter > 0);
    }
}
