package labs_examples.generics.labs;

import java.util.ArrayList;

public class playgroundCodingChallengeGenericClass {
    Generic<Integer> a = new Generic<>();
    Integer[] array = {1, 2, 3, 4};
//    a.printArray(array);
}

class Generic<E> {
    public void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.println(element);
        }
    }
}