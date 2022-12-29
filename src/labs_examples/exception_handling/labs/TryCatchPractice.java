package labs_examples.exception_handling.labs;

public class TryCatchPractice {
    /*
    1) Run this program as is. Do you see the exception thrown? Does "Program Complete" print?

    2) Uncomment the try/catch block (the 4 lines that start with "//") then run the application again. See the difference? Did "Program complete" print?

    3) Try to generate a new exception and catch it properly.
*/

    public static void main(String[] args) {

        int[] nums = {67, 43};

        try {
            System.out.println(nums[5]);
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("Error detected. Sorry bout that!");
        }
        int a = nums[0] / 0;
        System.out.println("Program complete");
    }
}

