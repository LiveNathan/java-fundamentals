package labs_examples.objects_classes_methods.labs.methods;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class Exercise_01 {

    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int c = multiply(a, b);
        System.out.printf("%d * %d = %d", a, b, c);
        int d = divide(a, b);
        System.out.printf("%n%d / %d = %d", a, b, d);
        printJoke();
        int seconds = years2seconds(a);
        System.out.printf("%n%d years is %d seconds.", a, seconds);
        String[] words = {"a", "b", "c", "d", "e"};
        int numberOfArrayElements = countArrayElements(words);
        System.out.printf("%nThere are %d elements in the array.", numberOfArrayElements);

    }


    // 1) Create a static multiply() method below that takes two int arguments (int a, int b) and
    //    returns the result of a * b
    public static int multiply(int a, int b) {
        return a * b;
    }


    // 2) Create a static divide() method below that takes two int arguments (int a, int b) and
    //    returns the result of a / b
    public static int divide(int a, int b) {
        return a / b;
    }


    // 3) Create a static void method that will print of joke of your choice to the console
    public static void printJoke() {
        System.out.println();
        System.out.println("all chess is three dimensional");
    }


    // 4) Create a static method that takes in a number in years (int years) as an argument
    //    and returns the number of seconds that number in years represents
    public static int years2seconds(int years) {
        return years * 365 * 24 * 60 * 60;
    }


    // 5) Create a varargs method that will return the length of the varargs array passed in
    public static int countArrayElements(String... words) {
        int count = 0;
        for (String word : words) {
            count++;
        }
        return count;
    }


}
