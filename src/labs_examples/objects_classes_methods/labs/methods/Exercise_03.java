package labs_examples.objects_classes_methods.labs.methods;

/**
 * Create a recursive method named factorial that will return the factorial of any number passed to it.
 * <p>
 * For instance, after creating the factorial method, uncomment the two lines in the main() method. When you run
 * it, it should print 120. It should also work for any other number you pass it.
 */
public class Exercise_03 {

    public static void main(String[] args) {
        int x = recursiveFactorial(5);
        System.out.println(x);
//        should print 120
    }

    public static int recursiveFactorial(int a) {
        int total;
        if (a == 1) {
            return 1;
        }
        total = recursiveFactorial(a - 1) * a;
        return total;

    }


}

