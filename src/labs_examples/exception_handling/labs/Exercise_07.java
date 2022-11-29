package labs_examples.exception_handling.labs;

/*
 * Exception Handling Exercise 7:
 * 1) Create a custom exception.
 * 2) Demonstrate a method throwing your custom exception.
 */
public class Exercise_07 {
    public static void main(String[] args) throws UnderHeightException {
        Rider rider1 = new Rider("Nathan", 5.5);
        System.out.printf("The new rider %s was added successfully.", rider1.getName());
        Rider rider2 = new Rider("John", 3.4);
    }
}

