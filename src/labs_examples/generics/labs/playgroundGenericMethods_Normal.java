package labs_examples.generics.labs;

public class playgroundGenericMethods_Normal {
    public static void main(String[] args) {
        // Step 1) create an array of 5 strings then call the printArray() method and pass the String array
        String[] strings = {"a", "b", "c", "d", "e"};
        printArray(strings);

        // Step 1) create an array of 5 ints then call the printArray() method and pass the int array
        Integer[] ints = {1, 2, 3, 4, 5};
        printArray(ints);

        // Step 1) create an array of 5 doubles then call the printArray() method and pass the double array
        Double[] doubles = {1.23, 4.56, 7.89, 10.112, 13.145};
        printArray(doubles);
    }

    public static < E > void printArray( E[] inputArray ) {
        // Display array elements
        for(E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }
}
