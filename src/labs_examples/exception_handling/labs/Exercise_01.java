package labs_examples.exception_handling.labs;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Exception Handling Exercise 1:
 * <p>
 * 1) Demonstrate a try/catch.
 */

public class Exercise_01 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://s3.amazonaws.com/appforest_uf/f1667322342818x729157300971330400/SRM215%20Silver%203.txt");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}