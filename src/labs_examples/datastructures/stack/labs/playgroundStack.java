package labs_examples.datastructures.stack.labs;

import java.util.Stack;

public class playgroundStack {
    public static void main(String[] args) {
        Stack<String> myStack = new Stack<>();

        // push several elements onto the Stack
        myStack.push("one");
        myStack.push("two");
        myStack.push("three");
        myStack.push("four");
        System.out.println(myStack.toString());

        // print the first element in the Stack
        System.out.println("First element: " + myStack.firstElement());

        // pop the first element off the Stack
        System.out.println("Popped element: " + myStack.pop());

        // print the first element in the Stack again
        System.out.println("First element: " + myStack.firstElement());

        // demonstrate at least 3 other Stack method
        System.out.println("Size of stack: " + myStack.size());
        System.out.println("Top of the stack: " + myStack.peek());
        System.out.println("The stack is empty: " + myStack.isEmpty());
    }
}
