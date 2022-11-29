package labs_examples.exception_handling.labs;

public class Rider {
    private String name;
    private double height;

    public Rider(String name, double height) throws UnderHeightException {
        this.name = name;
        if (height < 4){
            throw new UnderHeightException();
        } else {
            this.height = height;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
