package labs_examples.conditions_loops.labs;

import java.util.Scanner;

/**
 * Conditions and Loops Exercise 3: Months of the year
 * <p>
 * Take in a number from the user and print "January", "February", ... "December", or "Other"
 * if the number from the user is 1, 2,... 12, or other respectively. Use a "switch" statement.
 */

public class Exercise_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number 1-12: ");
        int number = scanner.nextInt();

        switch (number) {
            case 1:
                System.out.printf("%d is the number for January.", number);
                break;
            case 2:
                System.out.printf("%d is the number for February.", number);
                break;
            case 3:
                System.out.printf("%d is the number for March.", number);
                break;
            case 4:
                System.out.printf("%d is the number for April.", number);
                break;
            case 5:
                System.out.printf("%d is the number for May.", number);
                break;
            case 6:
                System.out.printf("%d is the number for June.", number);
                break;
            case 7:
                System.out.printf("%d is the number for July.", number);
                break;
            case 8:
                System.out.printf("%d is the number for August.", number);
                break;
            case 9:
                System.out.printf("%d is the number for September.", number);
                break;
            case 10:
                System.out.printf("%d is the number for October.", number);
                break;
            case 11:
                System.out.printf("%d is the number for November.", number);
                break;
            case 12:
                System.out.printf("%d is the number for December.", number);
                break;
        }
    }

}
