package labs_examples.input_output.labs;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/*
 *      Following the video examples and source code found in the src/labs_examples/input_output/examples/csv_parser
 *      package, create a new application that will parse a custom CSV file that you created and map each line of the
 *      csv to a custom POJO that you create.
 *
 *      Then add that object to an arraylist. After you have mapped each row of the csv to objects
 *      and added each object to an arraylist, print out each object using the objects custom toString() method.
 *
 *      Then, write the arraylist of objects back out to a new .csv file. Ensure that the resulting csv file is valid.
 */
public class Exercise_04 {
    public static void main(String[] args) throws IOException {
        // Open URL
        String urlPath = "https://s3.amazonaws.com/appforest_uf/f1667322342818x729157300971330400/SRM215%20Silver%203.txt";
        URL url;
        // URL encoder
        try {
            url = new URL(urlPath);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        // Create BufferedReader
        BufferedReader in;
        try {
            in = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Read Buffer by line
        String inputLine;
        TransferFunction tf = new TransferFunction();
        String[] values;
        while ((inputLine = in.readLine()) != null) {
//            System.out.println(inputLine);
            values = inputLine.split("\\s+");  // Any number of whitespaces (greedy)
            tf.AddNextRowToTransferFunction(values);  // Add values to ArrayLists
        }
        System.out.println(tf);  // toString unnecessary
        try {
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Create BufferedWriter
        PrintWriter out = null;

        // Write buffer to new text file
        try {
            String filePathOut = "tfOut.txt";
            out = new PrintWriter(new FileWriter(filePathOut));
            String[] strings;
            String lineOut;
            for (int i = 0; i < tf.getFrequency().size(); i++) {  // Every element of each arrayList
                strings = new String[] {tf.getFrequency().get(i).toString(), tf.getMagnitude().get(i).toString(), tf.getPhase().get(i).toString(), tf.getCoherence().get(i).toString()};  // Put the next row elements into an array.
                lineOut = String.join("\t", strings);  // Join arrayList into a single string.
                out.println(lineOut);
            }
        } catch (IOException exc){
            System.out.println("An error occurred: " + exc.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
}
}

