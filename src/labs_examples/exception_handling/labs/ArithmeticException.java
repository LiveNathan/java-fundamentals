package labs_examples.exception_handling.labs;

public class ArithmeticException extends Exception {

    @Override
    public String toString() {
        return "Watch out! Cannot divide by zero.";
    }
}
