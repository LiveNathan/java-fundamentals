package labs_examples.datastructures.queue.labs;

import java.util.Iterator;
import java.util.PriorityQueue;

/*      Demonstrate your mastery of Java's (sun's) built-in Queue class (as seen in the import statement
 *      above) by completing the following:
 *
 *      1) instantiate a new Queue
 *      2) demonstrate the use of EVERY method in the Queue class - there are 7
 */
public class Exercise_01 {
    public static void main(String[] args) {
        PriorityQueue<String> myQueue = new PriorityQueue<>();

        // add several elements to the myQueue
        myQueue.add("B");
        myQueue.add("D");
        myQueue.add("A");
        myQueue.add("C");

        // contains
        System.out.println("Queue contains D: " + myQueue.contains("D"));
        // iterator
        Iterator<String> iterator = myQueue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        // offer
        myQueue.offer("E");
        // peek
        System.out.println(myQueue.peek());
        // poll
        System.out.println(myQueue.poll());
        // remove
        myQueue.remove("B");
        // size
        System.out.println("size: " + myQueue.size());
        // toArray
        Object[] strings = myQueue.toArray();

        // print out every element again
        System.out.println(myQueue.toString());

        myQueue.clear();

    }
}
