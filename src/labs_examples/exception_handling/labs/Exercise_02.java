package labs_examples.exception_handling.labs;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Exception Handling Exercise 2:
 * <p>
 * Demonstrate a try/catch with multiple catch statements.
 */

public class Exercise_02 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://s3.amazonaws.com/appforest_uf/f1667322342818x729157300971330400/SRM215%20Silver%203.txt");
        } catch (MalformedURLException e) {
            // try to fix the URL by removing illegal characters
            // save the new URL
        } catch (Exception e2) {
            // if any other error occurs
        }
    }
}
