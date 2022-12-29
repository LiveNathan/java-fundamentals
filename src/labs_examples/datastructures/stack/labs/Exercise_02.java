package labs_examples.datastructures.stack.labs;

import java.util.Arrays;

/*      Stacks - Exercise_02
 *
 *      Write a new custom (Generic) Stack class that uses a traditional Array as the underlying data structure
 *      rather than the LinkedList as in the example we have already seen.
 *
 *      Your custom Stack class must also do the following: (Ryan Take 2)
 *
 *      1) throw a custom exception when trying to pop an element from an empty Stack
 *      2) resize the Stack (the underlying array) to be twice the size when the Stack is more than 3/4 full
 *      3) resize the Stack (the underlying array) to be half the size when the Stack is more than 1/4 empty
 *      4) contain the methods peekFirst() and peekLast()
 *      5) contain a size() method
 *      6) contain a method to print out the data of all elements in the Stack
 *
 *      TIP: To initialize a new array of a Generic type you can use this:
 *           T[] data = (T[]) new Object[10];
 */
public class Exercise_02 {
    public static void main(String[] args) {
        // Initialize object
        kustomStack<Integer> kustomStack = new kustomStack<>();
        // Add elements
        kustomStack.add(7);
        kustomStack.add(8);
        kustomStack.add(9);
        kustomStack.add(10);
        System.out.println(kustomStack.toString());
        // Remove elements
        System.out.println("Top plate removed: " + kustomStack.removeTopPlate());
        // Peek
        System.out.println("Bottom plate: " + kustomStack.peakBottom());
        System.out.println("Top plate: " + kustomStack.peakTop());
        // Size
        System.out.println("The size of the array: " + kustomStack.stackSize());

        System.out.println(kustomStack.toString());
    }
}

class kustomStack<E> {
    private E[] array = (E[]) new Object[0];

    public kustomStack() {
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

    public E removeTopPlate() {
        if (array == null) {
            System.out.println("Error: Array is empty. Cannot remove.");
            return null;
        } else {
            E[] newArray = (E[]) new Object[array.length - 1];
            System.arraycopy(array, 0, newArray, 0, array.length - 1);
            E topPlate = array[array.length - 1];
            array = newArray;
            return topPlate;
        }
    }
    public E peakBottom(){
        return array[0];
    }
    public E peakTop(){
        return array[array.length-1];
    }
    public int stackSize(){
        return array.length;
    }

    // To String
    @Override
    public String toString() {
        return "kustomStack{" +
                "elements=" + Arrays.toString(array) +
                '}';
    }
}