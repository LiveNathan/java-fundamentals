package labs_examples.conditions_loops.labs;

import java.util.Random;


/**
 * Conditions and Loops Exercise 9: break
 * <p>
 * Demonstrate the use of the "break" statement to exit a loop.
 */

public class Exercise_09 {
    public static void main(String[] args) {
        Random rand = new Random(); //instance of random class
        int int_random = rand.nextInt(100);
        for (int i = 0; i < 101; i++) {
            System.out.printf("Checking on %d%n", i);
            if (i == int_random) {
                break;
            }
        }
        System.out.print("You found the magic number!");
    }
}
