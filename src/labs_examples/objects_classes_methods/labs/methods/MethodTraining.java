package labs_examples.objects_classes_methods.labs.methods;

import java.util.ArrayList;

public class MethodTraining {
    public static void main(String[] args) {
//        1) Demonstrate method overloading in this class
        int a = 1;
        int b = 7;
        int c = multiply(a, b);
        System.out.printf("%d * %d = %d%n", a, b, c);
//        2) Demonstrate the difference between "pass by value" and "pass by reference"
        ArrayList<String> exampleList = new ArrayList();
        exampleList.add("a");
        exampleList.add("b");
        exampleList.add("c");
        ArrayList<String> exampleList2 = exampleList;
        exampleList2.remove("b");
        if (exampleList == exampleList2) {
            System.out.println("The lists are still the same");
        } else {
            System.out.println("The lists are different.");
        }
//        3) Create a method that will return the largest of 4 numbers (all of which are passed in as arguments)
        int d = 10;
        int largestNumber = findLargestNumber(a, b, c, d);
        System.out.printf("%nThe largest number between %d, %d, %d, and %d is %d.", a, b, c, d, largestNumber);
//        4) Write a method to count all consonants (the opposite of vowels) in a String
        String exampleString = "Hello world";
        int numberOfConsonants = countCosonants(exampleString);
        System.out.printf("%nThere are %d consonants in %s.", numberOfConsonants, exampleString);
//        5) Write a method that will determine whether or not a number is prime
        boolean isPrimeNumber = verifyPrimeNumber(c);
        System.out.printf("%n%d is a prime number: %b", c, isPrimeNumber);
//        6) Write a method that will return a small array containing the highest and lowest numbers in a given numeric array,
//                which is passed in as an argument
        int[] arrayOfIntegers = {1, 2, 3, 4, 5};
        int[] minAndMax = findMinMax(arrayOfIntegers);
        System.out.printf("%nmin: %d%nmax: %d", minAndMax[0], minAndMax[1]);

//        7) Write a method that takes 3 arguments (int maxNum, int divisor1, int divisor2) and returns an Integer Arraylist.
//                In this method create an Integer ArrayList and populate it with each number between zero and maxNum that is
//        divisible by both divisor1 and divisor2. Then return this ArrayList. After calling this method, print out the
//        length of the returned list
        int maxNum = 100;
        int divisor1 = 2;
        int divisor2 = 3;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList = generateArrayList(maxNum, divisor1, divisor2);
        int lengthOfArray = arrayList.size();
        System.out.printf("%nThe size of the array is %d.", lengthOfArray);

//
//        8) Write a method that will reverse an array in place use only one extra temp variable. For this exercise you cannot
//        instantiate a second array. You must reverse the array in place using only one extra temp variable. Hint: this
//        variable is used to temporarily store individual values in the array
        ArrayList<Integer> arrayListReversed = new ArrayList<>();
        arrayListReversed = reverseArrayList(arrayList);
        System.out.println();
        System.out.println("The array reversed" + arrayListReversed.toString());
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    public static float multiply(int a, float b) {
        return a * b;
    }

    public static int findLargestNumber(int a, int b, int c, int d) {
        return Math.max(Math.max(Math.max(a, b), c), d);
    }

    public static int countCosonants(String a) {
        a = a.toLowerCase();
        String vowels = "bcdfghjklmnpqrstvwxyz";
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < vowels.length(); j++) {
                if (a.charAt(i) == vowels.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean verifyPrimeNumber(int a) {
        for (int i = 2; i < a / 2; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] findMinMax(int[] array) {
        int currentMax = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > currentMax) {
                currentMax = array[i];
            }
        }
        int currentMin = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < currentMin) {
                currentMin = array[i];
            }
        }
        return new int[]{currentMin, currentMax};
    }

    public static ArrayList<Integer> generateArrayList(int maxNum, int divisor1, int divisor2) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < maxNum; i++) {
            if (i % divisor1 == 0 & i % divisor2 == 0) {
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    public static ArrayList<Integer> reverseArrayList(ArrayList<Integer> arrayList) {
        int nextElement;
        for (int i = 0; i < arrayList.size() / 2; i++) {
            nextElement = arrayList.get(i);
            arrayList.set(i, arrayList.get(arrayList.size() - i - 1));
            arrayList.set(arrayList.size() - i - 1, nextElement);
        }
        return arrayList;
    }
}
