package labs_examples.datastructures.stack.labs;

import java.util.Stack;

public class playgroundStackQuiz {
    public static void main(String[] args) {
        // instantiate the Stack
        Stack<Integer> myStack = new Stack<Integer>();

        // push the number 12 to the Stack
        myStack.push(12);

        // push the number 123 to the Stack
        myStack.push(123);

        // push the number 1234 to the Stack
        myStack.push(1234);

        // pop the last element off the stack onto the variable x
        int x = myStack.pop();

        // print x
        System.out.println(x);

        // pop the next element off the stack into the variable x
        x = myStack.pop();

        // print x
        System.out.println(x);

        // pop the next element off the stack into the variable x
        x = myStack.pop();

        // print x
        System.out.println(x);

    }
}
