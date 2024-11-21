package lap11;

public class SportsCar extends Car {
    public SportsCar(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        return getName() + " roars to life with a powerful engine sound!";
    }

    @Override
    public String accelerate() {
        return getName() + " accelerates rapidly to 100 km/h in 3 seconds!";
    }

    @Override
    public String brake() {
        return getName() + " uses high-performance brakes for sharp stopping.";
    }
}

