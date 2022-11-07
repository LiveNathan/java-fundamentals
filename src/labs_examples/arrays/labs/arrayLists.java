package labs_examples.arrays.labs;

import videos_source_code.arrays.ArrayLists;

import java.util.ArrayList;

public class arrayLists {
    public static void main(String[] args) {
        // please demonstrate how to declare an ArrayList below
        ArrayList<Integer> list = new ArrayList<Integer>();

        // please demonstrate how to add values to an array ArrayList
        list.add(7);
        list.add(4);
        list.add(16);

        // please demonstrate how to remove values from an ArrayList
        list.remove(1);

        // please demonstrate how to retrieve values from an ArrayList
        System.out.println(list.get(0));

        // please demonstrate at least two other useful methods available
        // to us when we use ArrayLists
        list.indexOf(16);
        Boolean listIsEmpty = list.isEmpty();
    }
}
