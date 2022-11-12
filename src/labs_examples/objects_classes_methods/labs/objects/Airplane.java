package labs_examples.objects_classes_methods.labs.objects;

class airplaneExample {

    public static void main(String[] args) {
        Engine myEngine = new Engine(400);
        SafetyFeatures mySafetyFeatures = new SafetyFeatures(4, 10);
        AirPlane myAirplane = new AirPlane(myEngine, mySafetyFeatures, "Boeing", "White", 100.0, 90.0);
        System.out.println("I fly a " + myAirplane.getColor() + " " + myAirplane.getModel() + " with "
                + myAirplane.getSafetyFeatures().getExits() + " exits, and a " + myAirplane.getEngine().getHorsePower() + " horsepower engine.");
        // OR
        System.out.println(myAirplane);
        Nuts myNuts = new Nuts("cashew", true);
        System.out.println("There are " + myNuts.getName() + " nuts on the " + myAirplane.getModel() + " airplane.");
        System.out.println(myAirplane.toString());
        System.out.println(myNuts.toString());

    }

}

class Engine {
    private double horsePower;

    public Engine(double horsePower) {
        this.horsePower = horsePower;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "horsePower=" + horsePower +
                '}';
    }
}

class SafetyFeatures {
    private int exits;
    private int parachutes;

    public SafetyFeatures(int exits, int parachutes) {
        this.exits = exits;
        this.parachutes = parachutes;
    }

    public int getExits() {
        return exits;
    }

    public int getParachutes() {
        return parachutes;
    }

    public void setExits(int exits) {
        this.exits = exits;
    }

    public void setParachutes(int parachutes) {
        this.parachutes = parachutes;
    }

    @Override
    public String toString() {
        return "SafetyFeatures{" +
                "exits=" + exits +
                ", parachutes=" + parachutes +
                '}';
    }
}

class AirPlane {
    private Engine engine;
    private SafetyFeatures safetyFeatures;
    private String model;
    private String color;
    private double fuelCapacity;
    private double currentFuelLevel;

    public AirPlane(Engine engine, SafetyFeatures safetyFeatures, String model, String color, double fuelCapacity, double currentFuelLevel) {
        this.engine = engine;
        this.safetyFeatures = safetyFeatures;
        this.model = model;
        this.color = color;
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = currentFuelLevel;
    }

    public Engine getEngine() {
        return engine;
    }

    public SafetyFeatures getSafetyFeatures() {
        return safetyFeatures;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setSafetyFeatures(SafetyFeatures safetyFeatures) {
        this.safetyFeatures = safetyFeatures;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public void setCurrentFuelLevel(double currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }


    @Override
    public String toString() {
        return "AirPlane{" +
                "engine=" + engine +
                ", safetyFeatures=" + safetyFeatures +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", fuelCapacity=" + fuelCapacity +
                ", currentFuelLevel=" + currentFuelLevel +
                '}';
    }

}

class Nuts {
    private String name;
    private boolean isSalted;

    public Nuts(String name, boolean isSalted) {
        this.name = name;
        this.isSalted = isSalted;
    }

    public String getName() {
        return name;
    }

    public boolean isSalted() {
        return isSalted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalted(boolean salted) {
        isSalted = salted;
    }

    @Override
    public String toString() {
        return "Nuts{" +
                "name='" + name + '\'' +
                ", isSalted=" + isSalted +
                '}';
    }
}

