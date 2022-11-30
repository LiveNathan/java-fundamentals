package labs_examples.input_output.labs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilePrinter2 {
    public static void printFile(String filePath) throws IOException {

        // initialize FileReader "fr" to null
        FileReader fr = null;

        try {
            /*  2. Fully initialize Reader "fr" with "filePath" variable in Try
                statement in case files don't exist
                or can't be accessed. Remember to pass the
                filePath as a parameter */
            fr = new FileReader(filePath);

            int c;

            // 3. While fr has more characters to read
            while ((c = fr.read()) != -1) {
                // Print the character to the console
                // don't forget to cast the int to a char
                System.out.print((char) c);
            }
        } catch (IOException exc) {
            System.out.println("An error occurred: " + exc.getMessage());
        } finally {

            if (fr != null) {
                // 4. Close connections
                fr.close();
            }
        }
    }
}
