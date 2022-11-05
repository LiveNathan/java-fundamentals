package labs_examples.conditions_loops.labs;

public class doWhilePractice {
    public static void main(String[] args) {
        // declare a counter variable to use in our while loop (don't forget to increment it as you loop!)
        int counter = 1;

        // please use a while loop to print out every 3rd number between 0 and 100 below
        while (counter < 101){
            if (counter % 3 == 0){
                System.out.printf("The next 3rd number is %d.%n", counter);
            }
            counter++;
        }
        counter = 0;
        // please use a do-while loop to print out every 5th number below
        do {
            if (counter % 5 == 0){
                System.out.printf("The next 5th number is %d.%n", counter);
            }
            counter++;
        } while (counter < 101);
    }
}
