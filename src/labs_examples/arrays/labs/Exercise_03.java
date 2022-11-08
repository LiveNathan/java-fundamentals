package labs_examples.arrays.labs;

/**
 * 2D Array
 * <p>
 * Creat and populate a 5x5 2D array with multiples of 3, starting with 3. Once populated, print out the results.
 * <p>
 * The output should look something like this:
 * <p>
 * 3 6 9 12 15
 * 18 21 24 27 30
 * ...
 * ...
 * ...
 */

public class Exercise_03 {

    public static void main(String[] args) {
        int[][] matrix5x5 = new int[5][5];
        int iter = 1;
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                matrix5x5[row][column] = 3 * iter;
                iter++;
            }
        }
        for (int[] row : matrix5x5) {
            for (int column : row) {
                System.out.printf("%d ", column);
            }
            System.out.println();
        }

    }
}
