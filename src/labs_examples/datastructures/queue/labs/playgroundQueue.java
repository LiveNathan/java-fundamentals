package labs_examples.datastructures.queue.labs;

import java.util.PriorityQueue;

public class playgroundQueue {
    public static void main(String[] args) {
        PriorityQueue<String> myQueue = new PriorityQueue<>();

        // add several elements to the myQueue
        myQueue.add("B");
        myQueue.add("D");
        myQueue.add("A");
        myQueue.add("C");

        // print out every element in this myQueue
        System.out.println(myQueue.toString());
        for (String element:myQueue) {
            System.out.println(element);
        }

        // why did they print out in the order they did
        // Natural ordering

        // poll the first element off the myQueue
        System.out.println("First element: " + myQueue.poll());

        // print out every element again
        System.out.println(myQueue.toString());

        // demonstrate several other PriorityQueue methods
        System.out.println("First element: " + myQueue.peek());
        System.out.println("Queue contains D: " + myQueue.contains("D"));
        myQueue.clear();
    }
}
