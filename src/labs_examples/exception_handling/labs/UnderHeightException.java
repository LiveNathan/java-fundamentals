package labs_examples.exception_handling.labs;

public class UnderHeightException extends Exception {
    @Override
    public String toString() {
        return "UnderHeightException{ Must be at least 4 feet tall to to ride }";
    }
}
