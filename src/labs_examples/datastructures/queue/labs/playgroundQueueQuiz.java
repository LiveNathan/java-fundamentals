package labs_examples.datastructures.queue.labs;

import java.util.PriorityQueue;

public class playgroundQueueQuiz {
    public static void main(String[] args) {
        // a priority queue orders its elements by their natural order
        // by default with Strings this will be alphabetically
        PriorityQueue<String> myQueue = new PriorityQueue<String>();

        // add the elements "12", "123" and "1234" elements to the Queue
        myQueue.add("12");
        myQueue.add("123");
        myQueue.add("1234");

        // peek at the "top/front" of the Queue
        System.out.println(myQueue.peek());

        // demonstrate contains() method
        System.out.println("Contains \"12\"? -> " + myQueue.contains("123"));

        // print the output
//        System.out.println(myQueue.toString());

        // remove an element from the front of the Queue
        String a = myQueue.poll();

        // print out what you just removed
        System.out.println(a);

        // Retrieve an element, but do not remove, the head of this queue.
        String b = myQueue.peek();

        // print out that element
        System.out.println(b);

        // iterate over Queue and print out elements
        for (String element:myQueue) {
            System.out.println(element);
        }

        // clear the Queue
        myQueue.clear();
    }
}
