package labs_examples.arrays.labs;

public class forEachLoops {
    public static void main(String[] args) {

        // please declare an array or arraylist below
        int[] intArray = new int[5];

        // please populate that array or arraylist
        for (int iter = 0; iter < 5; iter++){
            intArray[iter] = iter;
        }

        // please use a For Each Loop to print each element
        // in the array or arraylist you declared and populated above
        for (int elem : intArray){
            System.out.printf("The next element in the array is %d.%n", elem);
        }
    }
}
