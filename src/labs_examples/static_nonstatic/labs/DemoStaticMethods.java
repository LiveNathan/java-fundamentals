package labs_examples.static_nonstatic.labs;

public class DemoStaticMethods {
    public static void main(String[] args) {
        // demonstrate how to invoke both method in the MyMath class below
        int a = MyMath.multiply(2, 3);
        int b = MyMath.divide(2, 3);

    }
}

class MyMath{
    public static int multiply(int a, int b){
        return a * b;
    }

    public static int divide(int a, int b){
        if (b == 0){
            return -1;
        } else {
            return a/b;
        }
    }
}
