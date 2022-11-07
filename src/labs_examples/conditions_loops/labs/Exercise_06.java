package labs_examples.conditions_loops.labs;

/**
 * Conditions and Loops Exercise 6: Basic while loop
 * <p>
 * Use a "while" loop find the sum of numbers to from 1-100. Print the sum to the console
 */

public class Exercise_06 {
    public static void main(String[] args) {
        int iter = 1;
        int sum = 0;
        while (iter < 101) {
            sum += iter;
            iter++;
        }
        System.out.printf("The sum of every integer between 1 and 100 is %d.", sum);
    }
}
