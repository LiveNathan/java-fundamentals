package labs_examples.arrays.labs;

import java.util.ArrayList;

/**
 * ArrayLists
 * <p>
 * Please demonstrate how to create an ArrayList, populate an array list, access elements within an ArrayList.
 * Also take a moment to explore the many methods that are available to you when you use an ArrayList. By simply
 * typing the dot operator (".") after the ArrayList object that you create. You should see a menu pop up that
 * shows a list of methods.
 */
public class Exercise_07 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(7);
        list.add(4);
        list.add(16);

        list.remove(1);

        System.out.println(list.get(0));

        list.indexOf(16);
        Boolean listIsEmpty = list.isEmpty();
    }
}
