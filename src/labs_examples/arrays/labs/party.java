package labs_examples.arrays.labs;

import java.util.ArrayList;

public class party {
    public static void main(String[] args) {

        //YOUR CODE BELOW

        /*  1.  First create and initialize an ArrayList called guests.
                Remember, the syntax to create an ArrayList is:
                ArrayList<type> name = new ArrayList<type>();   */
        ArrayList<String> guests = new ArrayList<>();

        /*  2.  Now add the following names to the list using .add() :
                Arnold, Gerald, Eugene, Helga, Phoebe in that order */
        guests.add("Arnold");
        guests.add("Gerald");
        guests.add("Eugene");
        guests.add("Helga");
        guests.add("Phoebe");

        /*  3.  Print the names using a ForEach loop.
                Remember, the syntax for the ForEach loop is:
                for(type element: collection) { code }          */
        for (String element : guests) {
            System.out.println(element);
        }


        /*  4.  Eugene wont be able to make it.
                Remove him from the list using .remove() */
        guests.remove("Eugene");


        /*  5. Print the list again  */
        for (String element : guests) {
            System.out.println(element);
        }

        //YOUR CODE ABOVE
    }
}

