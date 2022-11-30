package labs_examples.input_output.labs;

import java.io.*;

/*
 * Input/Output Exercise 3: variety
 *    1) Demonstrate the usage of at least two additional Byte Streams
 *    2) Demonstrate the usage of at least two additional Character Streams
 *    3) Demonstrate using a buffer on one of the Byte Streams and one of the Character Streams
 *    4) Demonstrate the use of the DataInputStream and DataOutputStream
 *
 */
public class Exercise_03 {
    public static void main(String[] args) throws IOException {
        CopyBytes.CopyBytesMethod();
        CopyLines.CopyLinesMethod();
        DataInputOutputStreamExample.readSingleCharacter();
    }
}

class CopyBytes {
    public static void CopyBytesMethod() throws IOException {
        try (FileInputStream in = new FileInputStream("example.txt"); FileOutputStream out = new FileOutputStream("exampleOut.txt")) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
            byte[] buffer = new byte[5];
            int bytesRead = 0;
            while ((bytesRead = bufferedInputStream.read()) != -1) {
                out.write(buffer);
            }
        }
    }
}

class CopyLines {
    public static void CopyLinesMethod() {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;
        try {
            inputStream = new BufferedReader(new FileReader("example.txt"));
            outputStream = new PrintWriter(new FileWriter("exampleOut2.txt"));
            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } catch (IOException exc) {
            System.out.println("An error occurred: " + exc.getMessage());
        } finally {
            // close connections
            try {
                inputStream.close();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
            outputStream.close();
        }
    }
}

class DataInputOutputStreamExample {
    public static void readSingleCharacter() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("example.txt"));
        int intDataIO = dataInputStream.readInt();
        dataInputStream.close();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("exampleOut3.txt"));
        dataOutputStream.write(intDataIO);
        dataOutputStream.close();
    }
}