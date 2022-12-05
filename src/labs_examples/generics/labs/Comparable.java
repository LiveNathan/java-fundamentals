package labs_examples.generics.labs;

public final class Algorithm {

    public static <T extends Number> T max(T x, T y) {

        return x > y ? x : y;

    }

}