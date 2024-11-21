package lap11;

public class ElectricCar extends Car {
    public ElectricCar(String name) {
        super(name, 0); // Electric cars have no cylinders
    }

    @Override
    public String startEngine() {
        return getName() + " starts silently with an electric motor.";
    }

    @Override
    public String accelerate() {
        return getName() + " accelerates smoothly and silently.";
    }

    @Override
    public String brake() {
        return getName() + " uses regenerative braking to save energy.";
    }
}
