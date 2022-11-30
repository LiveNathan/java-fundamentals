package labs_examples.input_output.labs;

import java.io.*;

/**
 * Input/Output Exercise 1: File input/output
 * Using the BufferedInputStream, read a text file 5 bytes at a time and write each byte to a new file.
 * Make sure you close the connections to both files.
 */

class Example_01 {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        String filePathIn = "example.txt";
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        String filePathOut = "exampleOut.txt";
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(filePathIn));
            byte[] bytes = new byte[5];
            int bytesRead = 0;
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePathOut));
            while ((bytesRead = bufferedInputStream.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, bytesRead));
                bufferedOutputStream.write(bytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}