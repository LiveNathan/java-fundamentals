package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import com.sun.media.sound.WaveFileReader;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TruncateIR {
    public static void main(String[] args) {
        // Import IR
        String IRurl = "https://s3.amazonaws.com/appforest_uf/f1660040393454x716545782075606000/Y12%20ARC-48k.wav";
        URL url;
        try {  // Seems like this is required
            url = new URL(IRurl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        Wav objRead1 = new Wav();
        objRead1.readWav(inputFilename);
        Hashtable<String, Long> propsOut = objRead1.getProperties(); // Gets the WAV file properties
        double[][] signal = objRead1.getData("int"); // Can be 'int', 'long' 'double'

        // Get Sample Rate
        AudioInputStream audioInputStream;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(url);
        } catch (UnsupportedAudioFileException | IOException e) {
            throw new RuntimeException(e);
        }
        AudioFormat audioFormat = audioInputStream.getFormat();
        float Fs = audioFormat.getSampleRate();
        System.out.printf("%nSample rate: %f", Fs);

        // Create array from audio file
        int audioBytesAvailable;
        try {
            audioBytesAvailable = audioInputStream.available();
            System.out.printf("%naudio bytes available: %d. Framelength * framesize = %d", audioBytesAvailable, audioInputStream.getFrameLength() * audioFormat.getFrameSize());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byte[] IRByteArray = new byte[(int) audioInputStream.getFrameLength() * audioFormat.getFrameSize()];
        int numBytesRead = 0;
        try {
            numBytesRead = audioInputStream.read(IRByteArray);
            System.out.printf("%nnumber of bytes read: " + numBytesRead);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Length of array: " + IRByteArray.length);

        // Extract amplitude data from byte array
        int IRlengthInSamples = IRByteArray.length / 2;  // I really don't know why this is necessary. Saw it in someone else's code.
        int[] audioData = new int[IRlengthInSamples];
        List<Integer> audioDataList = new ArrayList<Integer>();
        for (int i = 0; i < IRlengthInSamples; i++) {
            int leastSignificantBit = IRByteArray[2 * i];
            int mostSignificantBit = IRByteArray[2 * i + 1];
            audioData[i] = mostSignificantBit << 8 | (255 & leastSignificantBit);
            audioDataList.add(audioData[i]);
        }

        // Plot array???

        // Find peak
        int IRmaxVal = audioData[0];
        int IRmaxIndex = 0;
        for (int i = 1; i < audioData.length; i++) {
            if (Math.abs(audioData[i]) > IRmaxVal) {
                IRmaxVal = Math.abs(audioData[i]);
                IRmaxIndex = i;
            }
        }
        System.out.printf("%nThe IR max of %d was found at %d.", IRmaxVal, IRmaxIndex);
        System.out.printf("%nThe max value is %d and the minimum is %d", Arrays.stream(audioData).max().getAsInt(), Arrays.stream(audioData).min().getAsInt());
        System.out.printf("%nThe max value of the arrayList is %d at %d and the minimum is %d at %d.", Collections.max(audioDataList), audioDataList.indexOf(Collections.max(audioDataList)), Collections.min(audioDataList), audioDataList.indexOf(Collections.min(audioDataList)));

        // Normalize
        double[] IRnormalized = new double[audioData.length];
        ArrayList<Double> IRnormalizedList = new ArrayList<>();
        for (int i = 0; i < audioData.length; i++) {
            IRnormalized[i] = (double) audioData[i] / IRmaxVal;
            IRnormalizedList.add((double) audioDataList.get(i) / IRmaxVal);
        }
        System.out.printf("%nThe max value is %f and the minimum is %f", Arrays.stream(IRnormalized).max().getAsDouble(), Arrays.stream(IRnormalized).min().getAsDouble());
        System.out.printf("%nThe max value of the arrayList is %f and min is %f", Collections.max(IRnormalizedList), Collections.min(IRnormalizedList));
        System.out.printf("%nThe value at index zero: %f", IRnormalized[0]);

        // Find start and end
        double IRstartThresholdVal = 0.5;  // start threshold, min value
        int numberOfContinuousSamplesBelowThreshold = 50;  // how many samples need to be below the min value?
        // find first continuous series of samples below threshold
        int IRstartIndex = 0;
        for (int i = IRmaxIndex; i > -1 + numberOfContinuousSamplesBelowThreshold; i--) {
            double[] slicedArray = Arrays.copyOfRange(IRnormalized, i - numberOfContinuousSamplesBelowThreshold, i); // Slice array
            // find max value
            double slicedArrayMaxVal = slicedArray[0];
            for (int j = 1; j < slicedArray.length; j++) {
                if (Math.abs(slicedArray[j]) > slicedArrayMaxVal) {
                    slicedArrayMaxVal = Math.abs(slicedArray[j]);
                }
            }
//            System.out.print(slicedArrayMaxVal + ", ");
            if (slicedArrayMaxVal <= IRstartThresholdVal) {
                IRstartIndex = i;
                break;
            }
        }
        System.out.printf("%nIR start index: %d", IRstartIndex);

        // Plot
        // Save
    }

    private static boolean URLisValid(String iRurl) {
        try {
            URL url = new URL(iRurl);
            url.toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }

}
