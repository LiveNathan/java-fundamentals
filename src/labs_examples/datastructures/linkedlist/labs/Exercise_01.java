package labs_examples.datastructures.linkedlist.labs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/*      LinkedLists - Exercise_01
 *
 *      Demonstrate your mastery of Java's built-in LinkedList class by demonstrating the following:
 *      1) create a LinkedList (from Java's libraries)
 *      2) add()
 *      3) addAll()
 *      4) addFirst()
 *      5) addLast()
 *      6) getFirst()
 *      7) getLast()
 *      8) get()
 *      9) set()
 *      10) push()
 *      11) pop()
 *      12) remove()
 *      13) contains()
 *      14) listIterator()
 *      15) clear()
 */
public class Exercise_01 {
    public static void main(String[] args) {
        // 1) create a LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        // 2) add()
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        // 3) addAll()
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(21);
        arrayList.add(22);
        arrayList.add(23);
        linkedList.addAll(arrayList);
        // 4) addFirst()
        linkedList.addFirst(99);
        // 6) getFirst()
        System.out.println("The first element is: " + linkedList.getFirst());
        // 7) getLast()
        System.out.println("The last element is: " + linkedList.getLast());
        // 8) get()
        System.out.println("The second element is: " + linkedList.get(1));
        // 9) set()
        linkedList.set(2, 7);
        // 10) push()
        linkedList.push(101);
        // 11) pop()
        System.out.println("This first element was: " + linkedList.pop());
        // 12) remove()
        linkedList.remove();  // Remove the first element
        linkedList.remove(3);  // Remove element at index 3
        // 13) contains()
        System.out.println("LinkedList contains 7: " + linkedList.contains(7));
        // 14) listIterator()
        ListIterator<Integer> listIterator = linkedList.listIterator(2);
        while (listIterator.hasNext()){
            System.out.print(listIterator.next() + " ");
        }
        // 15) clear()
        linkedList.clear();

        System.out.println(linkedList);
    }
}