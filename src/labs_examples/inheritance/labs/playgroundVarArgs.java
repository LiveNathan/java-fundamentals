package labs_examples.inheritance.labs;

import java.util.Arrays;
import java.util.Scanner;

public class playgroundVarArgs {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter some words: ");
//        String words = scanner.nextLine();
        String[] words = {"a", "b", "c"};
        int numberOfWords = countWords(words);
        System.out.printf("%nThe number of words in %s is %d.", Arrays.toString(words), numberOfWords);
    }

    public static int countWords(String... words) {
        int count = 0;
        for (String word : words) {
            System.out.printf("Now: %s.", word);
            count++;
        }
        return count;
    }
}
