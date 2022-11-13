package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

import java.util.Arrays;

public class AudioInventory {
    public static void main(String[] args) {
        FullRange prx615m = new FullRange("JBL", "PRX615M", 2, true, (float) .429, (float) .66, (float) .414, 90, 30);
        System.out.println(prx615m);
        prx615m.rent(1);
        prx615m.returnEquipment(1);
    }
}

class AudioEquipment {
    String make;
    String model;
    int count;

    public AudioEquipment() {
        this.make = "NaN";
        this.model = "NaN";
        this.count = 0;
    }

    public AudioEquipment(String make, String model, int count) {
        this.make = make;
        this.model = model;
        this.count = count;
    }

    public void rent(int rentalCount) {
        count -= rentalCount;
        System.out.printf("You just rented a %s %s. There are %d left.", make, model, count);
    }

    public void returnEquipment(int rentalCount) {
        count += rentalCount;
        System.out.printf("You just returned a %s %s. There are %d left.", make, model, count);
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getCount() {
        return count;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "audioEquipment{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", count=" + count +
                '}';
    }
}

class Loudspeaker extends AudioEquipment {
    boolean isSelfPowered;
    float widthMeters;
    float heightMeters;
    float depthMeters;

    public Loudspeaker(String make, String model, int count, boolean isSelfPowered, float widthMeters, float heightMeters, float depthMeters) {
        super(make, model, count);
        this.isSelfPowered = isSelfPowered;
        this.widthMeters = widthMeters;
        this.heightMeters = heightMeters;
        this.depthMeters = depthMeters;
    }

    @Override
    public void rent(int rentalCount) {
        super.rent(rentalCount);
        System.out.println("Don't forget to make sure it turns on!");
    }

    @Override
    public void returnEquipment(int rentalCount) {
        super.returnEquipment(rentalCount);
        System.out.println("Don't forget to make sure it turns on!");
    }

    public boolean isSelfPowered() {
        return isSelfPowered;
    }

    public void setSelfPowered(boolean selfPowered) {
        isSelfPowered = selfPowered;
    }

    public float getWidthMeters() {
        return widthMeters;
    }

    public void setWidthMeters(float widthMeters) {
        this.widthMeters = widthMeters;
    }

    public float getHeightMeters() {
        return heightMeters;
    }

    public void setHeightMeters(float heightMeters) {
        this.heightMeters = heightMeters;
    }

    public float getDepthMeters() {
        return depthMeters;
    }

    public void setDepthMeters(float depthMeters) {
        this.depthMeters = depthMeters;
    }

    @Override
    public String toString() {
        return "louspeaker{" +
                "isSelfPowered=" + isSelfPowered +
                ", widthMeters=" + widthMeters +
                ", heightMeters=" + heightMeters +
                ", depthMeters=" + depthMeters +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", count=" + count +
                '}';
    }
}

class FullRange extends Loudspeaker {
    int horizontalCoverage;
    int verticalCoverage;

    public FullRange(String make, String model, int count, boolean isSelfPowered, float widthMeters, float heightMeters, float depthMeters, int horizontalCoverage, int verticalCoverage) {
        super(make, model, count, isSelfPowered, widthMeters, heightMeters, depthMeters);
        this.horizontalCoverage = horizontalCoverage;
        this.verticalCoverage = verticalCoverage;
    }

    public int getHorizontalCoverage() {
        return horizontalCoverage;
    }

    public void setHorizontalCoverage(int horizontalCoverage) {
        this.horizontalCoverage = horizontalCoverage;
    }

    public int getVerticalCoverage() {
        return verticalCoverage;
    }

    public void setVerticalCoverage(int verticalCoverage) {
        this.verticalCoverage = verticalCoverage;
    }

    @Override
    public String toString() {
        return "fullRange{" +
                "horizontalCoverage=" + horizontalCoverage +
                ", verticalCoverage=" + verticalCoverage +
                ", isSelfPowered=" + isSelfPowered +
                ", widthMeters=" + widthMeters +
                ", heightMeters=" + heightMeters +
                ", depthMeters=" + depthMeters +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", count=" + count +
                '}';
    }
}

class Bandpass extends Loudspeaker {
    String passband;
    int[] operatingRange = new int[2];

    public Bandpass(String make, String model, int count, boolean isSelfPowered, float widthMeters, float heightMeters, float depthMeters, String passband, int[] operatingRange) {
        super(make, model, count, isSelfPowered, widthMeters, heightMeters, depthMeters);
        this.passband = passband;
        this.operatingRange = operatingRange;
    }

    @Override
    public void rent(int rentalCount) {
        super.rent(rentalCount);
        System.out.println("And some other instructions for bandpass.");
    }

    @Override
    public void returnEquipment(int rentalCount) {
        super.returnEquipment(rentalCount);
    }

    public String getPassband() {
        return passband;
    }

    public void setPassband(String passband) {
        this.passband = passband;
    }

    public int[] getOperatingRange() {
        return operatingRange;
    }

    public void setOperatingRange(int[] operatingRange) {
        this.operatingRange = operatingRange;
    }

    @Override
    public String toString() {
        return "Bandpass{" +
                "passband='" + passband + '\'' +
                ", operatingRange=" + Arrays.toString(operatingRange) +
                ", isSelfPowered=" + isSelfPowered +
                ", widthMeters=" + widthMeters +
                ", heightMeters=" + heightMeters +
                ", depthMeters=" + depthMeters +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", count=" + count +
                '}';
    }
}