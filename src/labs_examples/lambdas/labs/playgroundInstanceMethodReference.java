package labs_examples.lambdas.labs;
import java.util.ArrayList;
import java.util.List;

public class playgroundInstanceMethodReference {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(4567);
        nums.add(345);
        nums.add(2467);
        nums.add(12);

        playgroundInstanceMethodReference object = new playgroundInstanceMethodReference();

        // Step 1) Modify the line below to use a method reference rather than a lambda expression
        // Collections.sort(nums, (num1, num2) -> object.compare(num1, num2));
        nums.sort(object::compare);

        // Step 2) Modify the line below to use a method reference rather than a lambda expression
        // nums.forEach((n) -> System.out.println(n));
        nums.forEach(System.out::println);
    }

    public int compare(Integer val1, Integer val2) {
        return val1.compareTo(val2);
    }
}
