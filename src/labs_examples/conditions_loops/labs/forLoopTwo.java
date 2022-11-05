package labs_examples.conditions_loops.labs;

public class forLoopTwo {
    // 1. Initialize a variable named i with a value of 100

// 2. Initialize a second variable name j with a value of 0

// 3. Create a for loop that uses 'i' as it's counter, counting backwards from 100 to 1

// 4. Within the for loop add the value of i to the current value of j

// 5. Print out the value of j

    public static void forLoopTwo(){
        //int i = 100;
        int j = 0;

        for(int i = 100; i > 0; i--){
            j += i;
        }
        System.out.printf("J is %d", j);



    }
}
