package labs_examples.generics.labs;

public class playgroundGenericMethods {
    public static void main(String[] args) {

        // Step 1) create the generic method as instructed in the NumericExample class

        // Step 2) call that method and pass two doubles
        double sum = NumericExample.genericSum(1.234, 5.678);
        System.out.println(sum);

        // Step 3) call that method and pass two ints
        double sumInts = NumericExample.genericSum(1, 2);
        System.out.println(sumInts);

        // Step 4) call that method and pass two floats
        double sumFloats = NumericExample.genericSum(1.234F, 5.678F);
        System.out.println(sumFloats);

        // Step 5) call that method and pass one int and one double
        double sumIntDouble = NumericExample.genericSum(1, 1.2345);
        System.out.println(sumIntDouble);
    }
}

class NumericExample {

    // write a generic method below that will return the sum of ANY two numeric values (no matter what their specific data type is) (but remember the values must be Numeric)
    public static <T extends Number, U extends Number> double genericSum(T t, U u) {
        return t.doubleValue() + u.doubleValue();
    }

}

