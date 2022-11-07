package labs_examples.arrays.labs;

import java.util.Random;

public class multiDimensionalArrays {
    public static void main(String[] args) {

        // please demonstrate how to declare a Two-Dimensional Array
        // with a height of 4 and a width of 5 below
        int[][] twoDarray = new int[4][5];

        // using a nested for loop, please populate every index in the 2-D Array
        Random rand = new Random(); //instance of random class
        for (int row = 0; row < twoDarray.length; row++) {
            for (int column = 0; column < twoDarray[0].length; column++) {
                twoDarray[row][column] = rand.nextInt(10);
            }
        }

        // once populated, use a nested for loop to print each element in the 2-D array
        for (int[] row : twoDarray) {
            for (int[] column : twoDarray) {
                System.out.print(java.util.Arrays.toString(column));
            }
            System.out.println();
        }

    }
}
