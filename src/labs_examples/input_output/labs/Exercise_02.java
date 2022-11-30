package labs_examples.input_output.labs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Input/Output Exercise 2: File encryption
 *      -Using the BufferedReader, read a file character by character and write an encrypted version to a new file.
 *      -For example, change every 'a' to '-' and every 'e' to '~' .
 *      -Make sure you close the connections to both files.
 *      Then, ead back the encrypted file using the BufferedReader and
 *      print out the unencrypted version. Does it match the original file?
 *
 */
public class Exercise_02 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader("example.txt");
            fileWriter = new FileWriter("exampleEncrypted.txt");
            int intASCII;
            System.out.println("Encrypted text:");
            while ((intASCII = fileReader.read()) != -1) {
                intASCII++;
                System.out.print((char) intASCII);
                fileWriter.write(intASCII);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
        try {
            fileReader = new FileReader("exampleEncrypted.txt");
            int intASCII;
            System.out.println("\nUnencrypted text:");
            while ((intASCII = fileReader.read()) != -1) {
                intASCII--;
                System.out.print((char) intASCII);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
    }
}
