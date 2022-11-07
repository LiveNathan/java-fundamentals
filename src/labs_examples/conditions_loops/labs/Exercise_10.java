package labs_examples.conditions_loops.labs;

import java.util.Random;

/**
 * Conditions and Loops Exercise 10: continue
 * <p>
 * Demonstrate the use of the "continue" statement to skip to the next iteration of a loop.
 */

public class Exercise_10 {
    public static void main(String[] args) {
        Random rand = new Random(); //instance of random class
        int int_random = rand.nextInt(100);
        for (int iter = 0; iter < 101; iter++) {
            if (iter != int_random) {
                continue;
            }
            System.out.printf("The magic number is %d!", iter);
        }
    }
}
