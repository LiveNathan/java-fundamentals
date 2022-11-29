package labs_examples.exception_handling.labs;

public class HTTPError extends Exception {
    public int errorNo = 418;

    @Override
    public String toString() {
        return "I'm a teapot";
    }
}
