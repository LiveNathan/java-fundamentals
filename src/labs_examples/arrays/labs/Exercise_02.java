package labs_examples.arrays.labs;

import sun.security.util.ArrayUtil;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

/**
 * More labs_examples.arrays
 * <p>
 * Using the array below, take in a number from 1-10 from the user and print out the index of that
 * element.
 */

public class Exercise_02 {

    public static void main(String[] args) {

        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Choose a number 1-10: ");
        Scanner scanner = new Scanner(System.in);
        int numberInput = scanner.nextInt();
        int iter = 0;
        for (int elem : array) {
            if (elem == numberInput) {
                System.out.printf("The index of %d is %d.", numberInput, iter);
                break;
            }
            iter++;
        }


    }
}