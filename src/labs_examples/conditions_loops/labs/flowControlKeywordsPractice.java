package labs_examples.conditions_loops.labs;

import java.util.Random;


public class flowControlKeywordsPractice {
    public static void main(String[] args) {
        // please demonstrate the use of the "continue" keyword below within a for loop
        Random rand = new Random(); //instance of random class
        int int_random = rand.nextInt(20);

        for (int iter = 0; iter < 21; iter++) {
            if (iter != int_random) {
                continue;
            }
            System.out.printf("The random number is: %d", iter);
        }

        // please demonstrate the use of the "break" keyword below in a do-while loop
        int int_random2 = rand.nextInt(20);
        int iter = 0;
        do {
            System.out.printf("%nIf %d is the random number, I'll stop.", iter);
            if (iter == int_random2) {
                break;
            }
            iter++;
        } while (iter != int_random2);
    }
}
