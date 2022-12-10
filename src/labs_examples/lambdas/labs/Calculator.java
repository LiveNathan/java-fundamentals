package labs_examples.lambdas.labs;

/* Tasks:
 * Complete the other 3 operations (subtract, multiply & divide)
 * Implement a second functional interface for single operands
 * Implement a lambda expression for the square root operation
 * Hint: Square Root is calculated with the method Math.sqrt(value)
 */
@FunctionalInterface
interface TwoOperandCalculation {
    double calculate(double x, double y);
}

@FunctionalInterface
interface SingleOperandCalculation {
    double calculate(double x);
}

public class Calculator {
    TwoOperandCalculation sum = (x, y) -> x + y; // Returns the sum of x and y
    TwoOperandCalculation subtract = (x, y) -> x - y;  // subtract
    TwoOperandCalculation multiply = (x, y) -> x * y;  //multiply
    TwoOperandCalculation divide = (x, y) -> x / y;  //divide
    SingleOperandCalculation sqrRoot = x -> Math.sqrt(x);  //sqrRoot
}