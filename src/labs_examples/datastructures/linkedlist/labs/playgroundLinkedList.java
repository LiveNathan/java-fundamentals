package labs_examples.datastructures.linkedlist.labs;

import java.util.LinkedList;

public class playgroundLinkedList {
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();

        // demonstrate adding several elements to the LinkedList
        myList.add("one");
        myList.add("two");
        myList.add("3");

        // demonstrate retrieving one or more element from the LinkedList
        System.out.println("LinkedList: " + myList);
        System.out.println(myList.get(0));

        // demonstrate removing several elements from the LinkedList
        myList.remove(2);

        // demonstrate at least 4 additional method calls against the LinkedList
        myList.set(0, "1");
        System.out.println("LinkedList: " + myList);
        System.out.println(myList.indexOf("two"));
        myList.addFirst("zero");
        System.out.println(myList.getFirst());
        System.out.println(myList.peek());
        System.out.println("LinkedList: " + myList);
        System.out.println(myList.pop());
        System.out.println("LinkedList: " + myList);

    }
}
