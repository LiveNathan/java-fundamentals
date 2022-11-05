package labs_examples.conditions_loops.labs;

public class whileExample {
    public int whileExample() {
        int count = 0;
        int val = 0;

        // write a while loop below that will loop until "count" is no longer less than 10
        while (count < 10){
            // within the while loop, add the value of "count" to the current value of "val"
            val += count;
            // then, increment your counter variable
            count++;
        }

        return val;
    }
}
