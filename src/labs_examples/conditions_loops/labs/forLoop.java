package labs_examples.conditions_loops.labs;

public class forLoop {
    public static void forLoop(){

        // declare an int variable named "val" and set it to zero
    int val = 0;



        // write a for loop (with a counting variable named "i") that will iterate from zero to 100 (inclusive),
    for(int i = 0; i < 101; i++){
        val += i;
    }

        // incrementing by 1 on each loop


        // inside the for loop, add the value of "i" to the current value of "val"


        System.out.println(val);

    }
}
