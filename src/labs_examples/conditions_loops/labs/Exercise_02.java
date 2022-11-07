package labs_examples.conditions_loops.labs;

import java.util.Scanner;


/**
 * Conditions and Loops Exercise 2: Days of the week
 * <p>
 * Take in a number from the user and print "Monday", "Tuesday", ... "Sunday", or "Other"
 * if the number from the user is 1, 2,... 7, or other respectively. Use an if-else statement
 * to accomplish this task.
 * <p>
 * Bonus Tricky Challenge: Use a "nested-if" statement.
 */

public class Exercise_02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number 1-7: ");
        int number = scanner.nextInt();

        if (number % 2 == 0) {
            if (number == 2) {
                System.out.printf("%d is the number for Tuesday", number);
            } else if (number == 4) {
                System.out.printf("%d is the number for Thursday", number);
            } else {
                System.out.printf("%d is the number for Saturday", number);
            }
        } else {
            if (number == 1) {
                System.out.printf("%d is the number for Monday", number);
            } else if (number == 3) {
                System.out.printf("%d is the number for Wednesday", number);
            } else if (number == 5) {
                System.out.printf("%d is the number for Friday", number);
            } else {
                System.out.printf("%d is the number for Sunday", number);
            }
        }

    }
}
