package labs_examples.input_output.labs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Complete the following code.
 * Classes to use:
 * FileInputStream
 * <p>
 * Methods:
 * .read()
 * .close()
 */


public class FilePrinter {
    public static void printFile(String filePath) throws IOException {

        // declare Input Stream outside of Try statment so they're accessible in the Finally statement
        FileInputStream inputStream = null;
//        BufferedInputStream bufferedInputStream = null;

        try {
            // initialize them within the Try in case the files do not exist or cannot be accessed
            inputStream = new FileInputStream(filePath);
            int b;

            // while there is more data to read in the InputStream 
            while ((b = inputStream.read()) != -1) {
                // print the data to the console (byte by byte) 
                System.out.print((char) b);
            }
        } catch (IOException exc) {
            System.out.println("An error occurred: " + exc.getMessage());
        } finally {
            // close connections to files
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}