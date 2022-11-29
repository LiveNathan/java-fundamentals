package labs_examples.exception_handling.labs;

public class playgroundDivisionByZero {
    public int division(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        } else {
            return a / b;
        }



//        try {
//            return a / b;
//        } catch (ArithmeticException arithmeticException) {
//            return -1;
//        }
    }
}
