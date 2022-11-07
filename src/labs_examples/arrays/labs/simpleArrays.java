package labs_examples.arrays.labs;

public class simpleArrays {
        public static void main(String[] args) {
            // please demonstrate how to declare and initialize a
            // String array of size five below
            int[] intArray = new int[5];
            System.out.println("The array: " + java.util.Arrays.toString(intArray));

            // once initialized, please populate each index of the array
            //for (int i : intArray){
            for (int i = 0; i < intArray.length; i++){
                System.out.printf("%nNow i is %d", i);
                intArray[i] = i;
            }
            System.out.println("The array: " + java.util.Arrays.toString(intArray));

            // once populated, please print out each element in the array
            // using a For Loop
            for (int i : intArray){
                System.out.printf("%nThe value at index %d is %d", i, intArray[i]);
            }
        }
}
