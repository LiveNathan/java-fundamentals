package labs_examples.inheritance.labs;

public class playgroundMethods_parameters {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int c = multiply(a, b);
        System.out.printf("%d * %d = %d", a, b, c);
        float d = divide(a, b);
        System.out.printf("%n%d / %d = %f", a, b, d);
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static float divide(int a, int b) {
        return (float) a / b;
    }

}
