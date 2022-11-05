package labs_examples.conditions_loops.labs;

public class str2int {
    public static void main(String[] args) {


        String str = "five";

        switch (str) {
            case "one":
                System.out.println("1");
                break;
            case "two":
                System.out.println("2");
                break;
            case "three":
                System.out.println("3");
                break;
            case "four":
                System.out.println("4");
                break;
            default:
                System.out.println("-1");
        }
    }
}
