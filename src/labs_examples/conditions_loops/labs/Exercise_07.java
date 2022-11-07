package labs_examples.conditions_loops.labs;

import java.util.Scanner;

/**
 * Conditions and Loops Exercise 7: First vowel
 * <p>
 * Take in a word from the user and using a "while" loop, find the first vowel in the word.
 * Once you find the vowel, print out the word and the first vowel.
 * <p>
 * Hints:
 * - there are a few helpful methods in the String class called length(), charAt() and indexOf()
 * - you'll likely want to use a String that contains all the vowels:
 * - ie: String vowels = "aeiou";
 */

public class Exercise_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scanner.next();
        String vowels = "aeiou";
        int idx1 = 0;
        int idx2 = 0;
        while (vowels.charAt(idx1) != word.charAt(idx2)) {
            idx1++;
            if (idx1 == vowels.length()) {
                idx1 = 0;
                idx2++;
            }
        }
        System.out.printf("%c is the first vowel in %s.", vowels.charAt(idx1), word);
    }
}
