package labs_examples.datastructures.stack.labs;

import java.util.Stack;

/*      Demonstrate your mastery of Java's built-in Stack class by completing the following:
 *
 *      1) instantiate a new Stack
 *      2) demonstrate the use of EVERY method in the Stack class - there are 5
 */
public class Exercise_01 {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        stringStack.push("A");
        stringStack.push("B");
        stringStack.push("C");
        // empty
        System.out.println("The stack is empty: " + stringStack.isEmpty());
        // peek
        System.out.println("The top of the stack: " + stringStack.peek());
        // pop
        System.out.println("Removed from the stop of the stack: " + stringStack.pop());
        // push
        stringStack.push("D");
        // search
        System.out.println("The index of B: " + stringStack.search("B"));
        System.out.println(stringStack.toString());
    }
}