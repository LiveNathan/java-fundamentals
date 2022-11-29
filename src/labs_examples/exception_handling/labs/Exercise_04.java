package labs_examples.exception_handling.labs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Exception Handling Exercise 4:
 * <p>
 * Demonstrate a nested try/catch.
 */
public class Exercise_04 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://s3.amazonaws.com/appforest_uf/f1667322342818x729157300971330400/SRM215%20Silver%203.txt");
            try {
                InputStream inputStreamReader = url.openStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}