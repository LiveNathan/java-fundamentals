package labs_examples.arrays.labs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Arrays calculator
 * <p>
 * Take in 10 numbers from the user. Place the numbers in an array. Using the loop of your choice,
 * calculate the sum of all of the numbers in the array as well as the average.
 * <p>
 * Print the results to the console.
 */

public class Exercise_01 {
    public static void main(String[] args) {
        Scanner numberInput = new Scanner(System.in);
        int[] intArray = new int[10];
        int sum = 0;
        for (int iter = 0; iter < intArray.length; iter++) {
            System.out.println("Next number: ");
            intArray[iter] = numberInput.nextInt();
            sum += intArray[iter];
        }
        float average = (float) sum / intArray.length;
        System.out.printf("The sum of the array is %d and the average is %f.", sum, average);
    }

}