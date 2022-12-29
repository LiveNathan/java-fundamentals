package labs_examples.datastructures.queue.labs;

import java.util.Arrays;

/*      Queues - Exercise_02
 *
 *      Write a new custom (Generic) Queue class that uses a traditional Array as the underlying data structure
 *      rather than the LinkedList as in the example we have already seen.
 *
 *      Your custom Queue class must also do the following:
 *
 *      1) throw a custom exception when trying to pop  an element from an empty Queue
 *      2) resize the Queue (the underlying array) to be twice the size when the Queue is more than 3/4 full
 *      3) resize the Queue (the underlying array) to be half the size when the Queue is more than 1/4 empty
 *      4) contain the methods peekFirst() and peekLast()
 *      5) contain a size() method
 *      6) contain a method to print out the data of all elements in the Queue
 *
 */
public class Exercise_02 {
    public static void main(String[] args) {
        kustomCue<String> kustomCue = new kustomCue<>();
        kustomCue.add("Z");
        kustomCue.add("X");
        kustomCue.add("Y");
        kustomCue.add("t");
        // Remove
        System.out.println("Front element removed: " + kustomCue.removeFrontElement());
        // Peek
        System.out.println("Front element: " + kustomCue.peekFirst());
        System.out.println("Last element: " + kustomCue.peekLast());
        // Size
        System.out.println("Size: " + kustomCue.queueSize());

        System.out.println(kustomCue.toString());
    }
}
class kustomCue<E>{
    private E[] array = (E[]) new Object[0];

    public kustomCue() {
    }
    public void add(E newElement) {
        if (array == null){
            E[] array = (E[]) new Object[1];
            array[0] = newElement;
        } else {
            E[] newArray = (E[]) new Object[array.length + 1];  //
            System.arraycopy(array, 0, newArray, 0, array.length);  // Add the n elements of the original array in this array.
            newArray[array.length] = newElement;  // Add the new element in the n+1 th position.
            array = newArray;
        }
    }
    public E removeFrontElement() {
        if (array == null) {
            System.out.println("Error: Array is empty. Cannot remove.");
            return null;
        } else {
            E[] newArray = (E[]) new Object[array.length - 1];
            System.arraycopy(array, 1, newArray, 0, array.length - 1);
            E frontElement = array[0];
            array = newArray;
            return frontElement;
        }
    }
    public E peekFirst(){
        return array[0];
    }
    public E peekLast(){
        return array[array.length-1];
    }
    public int queueSize(){
        return array.length;
    }

    @Override
    public String toString() {
        return "kustomCue{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}