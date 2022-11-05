package labs_examples.conditions_loops.labs;

public class forLoopExample {
    //class Main {
        public static void main(String[] args) {
            // please use a for loop below to print out every number between 0 & 100
            for (int i = 0; i < 101; i++){
                System.out.printf("%d bottles of beer on the wall.%n", i);
            }

            // please use another for loop below to print out every odd number between 100 and 0 in descending order
            for (int i = 1; i < 101; i+=2){
                System.out.printf("The next odd number is %d.%n", i);
            }

            // pleasure demonstrate "nesting" two for loops below
            for (int i = 0; i < 101; i+=10){
                System.out.printf("The next multiple of 10 is %d.%n", i);
                for (int j = i+1; j < i+10; j++){
                    System.out.printf("-- Now counting the inside: %d.%n", j);
                }
            }
        }
    //}
}
