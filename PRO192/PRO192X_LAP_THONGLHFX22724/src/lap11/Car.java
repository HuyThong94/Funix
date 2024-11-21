package lap11;

public class Car {
    private String name;
    private int cylinders;
    private int wheels;
    private boolean engine;

    // Constructor
    public Car(String name, int cylinders) {
        this.name = name;
        this.cylinders = cylinders;
        this.wheels = 4; // Default value
        this.engine = true; // Default value
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public boolean hasEngine() {
        return engine;
    }

    // Methods
    public String startEngine() {
        return name + " is starting the engine.";
    }

    public String accelerate() {
        return name + " is accelerating.";
    }

    public String brake() {
        return name + " is braking.";
    }
}

