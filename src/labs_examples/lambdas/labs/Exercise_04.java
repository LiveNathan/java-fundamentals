package labs_examples.lambdas.labs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/* Lambdas Exercise 4:
 *      Stream API Labs
 *      1) Demonstrate the use of the range function to print out the numbers 1 through 15 (inclusive)
 *      2) Demonstrate the use of the sum function to determine the range of a set of numbers.
 *      3) Demonstrate the use of the map() function to alter each int in a List of Integers, then use the sum function
 *          to get the sum of the modified list
 *      4) Demonstrate the filter function by filtering out all Integers that are less than 10 - then use the average
 *          function to average the remaining numbers, assign this result to an int variable.
 *      5) Demonstrate the reduce() function to determine the sum of a list of Integers
 *      6) Demonstrate how to Stream a text file and print out each line
 *      7) Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the lines into String arrays,
 *          then print out the element at the 1 index for each array.
 *      8) Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the lines into String arrays,
 *          then print out the sum of all elements at index 2.
 *      9) Demonstrate the anyMatch() function.
 *      10) Demonstrate the allMatch() function.
 *      11) Demonstrate the collect() terminal operation to store resulting values into a List
 */

public class Exercise_04 {
    public static void main(String[] args) {
        // 4.1
        IntStream
                .range(1, 16)
                .forEach(System.out::print);
        System.out.println();

        // 4.2
        int sum = IntStream.range(1, 100).sum();
        System.out.println(sum);

        // 4.3
        double sum2 = IntStream.range(1, 101)  // Create a Stream of a range of integers
                .mapToDouble(Math::sqrt)  // Convert the integers to double and use a method reference to find the square root of each
                .sum();  // Sum all elements
        System.out.println(sum2);

        // 4.4
        double average = IntStream.range(1, 101)
                .filter(x -> x > 9)  // filter in everything greater than 9
                .average()
                .orElse(0);  // This seems to be required to account for a possible empty stream.
//                .orElseThrow();  // Some exception for a catch block "The stream was empty, no average"
        System.out.println(average);

        // 4.5
        int sum3 = IntStream.range(1, 101)
                .reduce(0, Integer::sum);
        System.out.println(sum3);

        // 4.6
        String filePath = "/Users/nathanlively/Downloads/SRM215 Silver 3 (1).txt";
        Stream<String> TF = null;
        try {
            TF = Files.lines(Paths.get(filePath));  // returns a stream of strings
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TF.forEach(System.out::println);  // Print each element
        TF.close();  // Close the connection to the file

        // 4.7
        String dataFile = "/Users/nathanlively/Documents/CodingNomads/labs/online-java-fundamentals/src/labs_examples/lambdas/labs/stream_text_lab.csv";
        Stream<String> rows = null;
        try {
            rows = Files.lines(Paths.get(dataFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        rows
                .map(x -> x.split(","))  // Call String.split() on comma - returns array of values
                .forEach(x -> System.out.println(x[1]));  // Print index 1
        rows.close();  //close file connection

        // 4.8 sum of all elements at index 2
        Stream<String> rows2 = null;
        try {
            rows2 = Files.lines(Paths.get(dataFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Double sum4 = rows2
                .map(x -> x.split(",")[2])
                .mapToDouble(Double::parseDouble)
                .sum();
        System.out.println(sum4);
        rows2.close();  //close file connection

        // 4.9 anyMatch()
        Stream<String> streamOfUsers = Stream.of("Nathan", "Elis", "Choco", "Taco", "Lucas");
        boolean userAlreadyExists = streamOfUsers.anyMatch(string -> string.equals("Taco"));
        System.out.println("User Courtney already exists: " + userAlreadyExists);

        // 4.10 allMatch()
        Stream<String> streamOfUsers2 = Stream.of("Nathan", "Elis", "Choco", "Taco", "Lucas");
        boolean allWordsAreCapitalized = streamOfUsers2.allMatch(string -> Character.isUpperCase(string.charAt(0)));
        System.out.println("All of the words are capitalized: " + allWordsAreCapitalized);

        // 4.11 collect()
        List<Integer> integerList = IntStream.range(1, 101)
                .filter(x -> x % 3 == 0)
                .collect(toList());

        List<Integer> integerList1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> integerList2 = integerList1.stream().collect(toList());

    }
}
