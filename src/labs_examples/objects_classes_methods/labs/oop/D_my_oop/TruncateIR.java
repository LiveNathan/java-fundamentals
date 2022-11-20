package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

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

        // Get Sample Rate
        AudioInputStream audioInputStream;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(url);
        } catch (UnsupportedAudioFileException | IOException e) {
            throw new RuntimeException(e);
        }
        AudioFormat audioFormat = audioInputStream.getFormat();
        float Fs = audioFormat.getSampleRate();
//        System.out.println(Fs);

        // Create array from audio file
        int audioBytesAvailable;
        try {
            audioBytesAvailable = audioInputStream.available();
            System.out.println("audio bytes available:" + audioBytesAvailable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byte[] IRarray = new byte[audioBytesAvailable];
        int numBytesRead = 0;
        try {
            numBytesRead = audioInputStream.read(IRarray);
            System.out.println("number of bytes read: " + numBytesRead);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Length of array: " + IRarray.length);

        // Find peak

//        audioInputStream.read(audioBytesAvailable, IRarray);

        // Find start and end
        // Normalize
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
