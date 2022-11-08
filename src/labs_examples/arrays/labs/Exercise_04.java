package labs_examples.arrays.labs;

/**
 * Irregular Arrays
 * <p>
 * Create and populate a 2 dimensional irregular array of size and contents of your choosing. Using a nested
 * "for-each" loop, iterate and print out each element of the array.
 */

public class Exercise_04 {
    public static void main(String[] args) {
        int[][] irreg_array = {
                {546, 23},
                {123, 345, 87},
                {345, 87, 907, 45}
        };
        for (int[] row : irreg_array) {
            for (int column : row) {
                System.out.println(column + " ");
            }
            System.out.println();
        }
    }
}
