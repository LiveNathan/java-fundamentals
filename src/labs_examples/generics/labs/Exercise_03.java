package labs_examples.generics.labs;

/* Generics Exercise 3:
 *
 *      1) Write a generic method that accepts two generic arguments. This generic method should only accept
 *      arguments which are subclasses of Number. The generic method must return the sum (as a double) of whatever two
 *      numbers were passed in regardless of their type.
 *      2) Write a generic method to count the number of elements in a "Collection" of Strings that are palindromes
 *      3) Write a generic method to exchange the positions of two different elements in an array.
 *      4) Write a generic method to find the largest element within the range (begin, end) of a list.
 *
 */

import java.util.ArrayList;  // Leaving this in to ArrayList later.
import java.util.Arrays;
import java.util.Random;

public class Exercise_03 {
    public static void main(String[] args) {
        // 3.1
        System.out.println(CircusOfGenericMethods.GenericSum(7, 3.45F));

        // 3.2
        String[] strings = {"This string is now a palindrome.", "rotator", "Do geese see God", "Rocket science"};
        int numberOfPalindromes = CircusOfGenericMethods.CountStrings(strings);
        System.out.println("There are " + numberOfPalindromes + " palindromes in your collection of strings.");

        // 3.3
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        CircusOfGenericMethods.ExchangeElementArrayPositions(charArray);

        //3.4
        Double[] doubles = {1.23, 4.56, 7.89};
        double maxDouble = CircusOfGenericMethods.CustomFindMax(doubles);
        System.out.println("max: " + maxDouble);
        Integer[] ints = {1, 2, 3, 4, 5};
        int maxInt = (int) CircusOfGenericMethods.CustomFindMax(ints);
        System.out.println("max: " + maxInt);
    }
}

class CircusOfGenericMethods {
    public static <T extends Number, U extends Number> double GenericSum(T t, U u) {
        return t.doubleValue() + u.doubleValue();
    }

    public static <E extends String> int CountStrings(E[] strings) {
        int count = 0;  // Initialize the counter.
        StringBuilder stringBackwards = new StringBuilder();  // Initialize the string builder.
        for (E string : strings) {
            String nextString = string.toLowerCase();  // Convert E to lowercase string.
            nextString = nextString.replaceAll("\\s", "");  // Remove white space.
            stringBackwards.setLength(0);  // Clear string builder.
            stringBackwards.append(string);  // Add to string builder.
            stringBackwards.reverse();  // Reverse string.
            String stringBackwardsLowercase = stringBackwards.toString().toLowerCase();  // Save string builder to lowercase string.
            stringBackwardsLowercase = stringBackwardsLowercase.replaceAll("\\s", "");  // Remove white space.
            if (nextString.equals(stringBackwardsLowercase)) {  // If strings forward and backward match,
                count++;  // increase the count.
            }
        }
        return count;
    }

    public static <E> void ExchangeElementArrayPositions(E[] array) {
        int upperBound = array.length;
        Random random = new Random();
        int randomArrayIndex1 = random.nextInt(upperBound);
        int randomArrayIndex2 = random.nextInt(upperBound);
        System.out.println("before: " + Arrays.toString(array));
        System.out.println(array[randomArrayIndex1] + " at index " + randomArrayIndex1 + " will change places with " + array[randomArrayIndex2] + " at index " + randomArrayIndex2 + ".");
        E temp = array[randomArrayIndex1];
        array[randomArrayIndex1] = array[randomArrayIndex2];
        array[randomArrayIndex2] = temp;
        System.out.println("after: " + Arrays.toString(array));
    }

    public static <E extends Number> double CustomFindMax(E[] array) {
        double max = array[0].doubleValue();
        for (int i = 1; i < array.length; i++) {
            if (array[i].doubleValue() > max) {
                max = array[i].doubleValue();
            }
        }
        return max;
    }
}