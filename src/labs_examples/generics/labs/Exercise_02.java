package labs_examples.generics.labs;

/* Generics Exercise 2:
 *
 *      Create a class with a generic method that takes in an ArrayList of any Numeric type and returns the sum of all
 *      Numbers in the ArrayList. Demonstrate how to call this method from the main() method.
 */

import java.util.ArrayList;

public class Exercise_02 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayListInt = new ArrayList<>();
        arrayListInt.add(1);
        arrayListInt.add(2);
        double sum = A.CustomArrayListSum(arrayListInt);
        System.out.println(sum);
    }
}

class A {
    public static <E extends Number> double CustomArrayListSum(ArrayList<E> arrayList) {
        double sum = 0;
        for (E element : arrayList) {
            sum += element.doubleValue();
        }
        return sum;
    }
}