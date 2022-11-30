package labs_examples.input_output.labs;

import java.io.IOException;

public class TestFilePrinter {
    public static void main(String[] args) throws IOException {
        FilePrinter filePrinter = new FilePrinter();
        filePrinter.printFile("example.txt");
    }
}
