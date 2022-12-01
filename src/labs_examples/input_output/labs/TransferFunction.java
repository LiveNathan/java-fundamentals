package labs_examples.input_output.labs;

import java.util.ArrayList;
import java.util.Arrays;

public class TransferFunction {
    // Instance variables
    private ArrayList<Double> frequency = new ArrayList<>();
    private ArrayList<Double> magnitude = new ArrayList<>();
    private ArrayList<Double> phase = new ArrayList<>();
    private ArrayList<Double> coherence = new ArrayList<>();

    // Constructors
    public TransferFunction() {
    }

    // Getters & Setters
    public ArrayList<Double> getFrequency() {
        return frequency;
    }

    public void setFrequency(ArrayList<Double> frequency) {
        this.frequency = frequency;
    }

    public ArrayList<Double> getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(ArrayList<Double> magnitude) {
        this.magnitude = magnitude;
    }

    public ArrayList<Double> getPhase() {
        return phase;
    }

    public void setPhase(ArrayList<Double> phase) {
        this.phase = phase;
    }

    public ArrayList<Double> getCoherence() {
        return coherence;
    }

    public void setCoherence(ArrayList<Double> coherence) {
        this.coherence = coherence;
    }

    // Other methods
    public void AddNextRowToTransferFunction(String[] values) {
        this.frequency.add(Double.parseDouble(values[0]));
        this.magnitude.add(Double.parseDouble(values[1]));
        this.phase.add(Double.parseDouble(values[2]));
        this.coherence.add(Double.parseDouble(values[3]));
    }

    // To String
    @Override
    public String toString() {
        return "TransferFunction{" +
                "frequency=" + frequency + "\n" +
                "magnitude=" + magnitude + "\n" +
                "phase=" + phase + "\n" +
                "coherence=" + coherence +
                '}';
    }
}
