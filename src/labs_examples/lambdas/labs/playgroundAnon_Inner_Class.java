package labs_examples.lambdas.labs;

public class playgroundAnon_Inner_Class {
    public static void main(String[] args) {

        // Step 1) Please demonstrate the creation of an anonymous inner class from the interface AnonymousInner below
        AnonymousInner anonymousInner = new AnonymousInner() {
            @Override
            public void methodOne() {
                System.out.println("Method one.");
            }

            @Override
            public int methodTwo(int a) {
                return 0;
            }
        };
        // Step 2) Demonstrate calling both methods using the object you created (by creating an anonymous inner class)
        anonymousInner.methodOne();
        System.out.println(anonymousInner.methodTwo(7));
    }
}

interface AnonymousInner {
    public void methodOne();

    public int methodTwo(int a);
}

