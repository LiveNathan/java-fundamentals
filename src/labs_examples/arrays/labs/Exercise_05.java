package labs_examples.arrays.labs;

import java.util.Random;

/**
 * Traversing Arrays Backwards
 * <p>
 * Please create and populate an array of your choosing. Then, please demonstrate how to print out every other
 * element in the array in reverse order.
 */

public class Exercise_05 {
    public static void main(String[] args) {
        int[][] primeMatrix5x5 = new int[5][5];
        Random rand = new Random(); //instance of random class
        for (int row = 0; row < primeMatrix5x5.length; row++) {
            for (int column = 0; column < primeMatrix5x5[0].length; column++) {
                primeMatrix5x5[row][column] = rand.nextInt(101);
            }
        }
        for (int row = primeMatrix5x5.length - 1; row >= 0; row -= 2) {
            for (int column = primeMatrix5x5[0].length - 1; column >= 0; column -= 2) {
                System.out.println(primeMatrix5x5[row][column] + " ");
            }
        }
    }

}
