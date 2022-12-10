package labs_examples.lambdas.labs;

public class playgroundLambdaRunnable {
    public static void main(String[] args) {

        // Step 1) declare a Lambda expression using the Runnable interface
        Runnable runnable  = () -> System.out.println("I am a runnable.");

        // Step 2) declare a new Thread object and pass in the Runnable Lambda
        new Thread(runnable).start();

        // Step 3) start the thread

    }
}
