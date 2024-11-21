package lap11;

public class SUV extends Car {
    public SUV(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        return getName() + " starts with a rugged growl.";
    }

    @Override
    public String accelerate() {
        return getName() + " accelerates steadily on rough terrain.";
    }

    @Override
    public String brake() {
        return getName() + " applies ABS for safe stopping on all surfaces.";
    }
}

