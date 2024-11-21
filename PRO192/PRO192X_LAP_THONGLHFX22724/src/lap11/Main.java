package lap11;

public class Main {
    public static void main(String[] args) {
        // Instances of each car type
        Car sportsCar = new SportsCar("Ferrari", 8);
        Car electricCar = new ElectricCar("Tesla Model S");
        Car suv = new SUV("Toyota Land Cruiser", 6);

        // Test polymorphism
        System.out.println(sportsCar.startEngine());
        System.out.println(sportsCar.accelerate());
        System.out.println(sportsCar.brake());

        System.out.println(electricCar.startEngine());
        System.out.println(electricCar.accelerate());
        System.out.println(electricCar.brake());

        System.out.println(suv.startEngine());
        System.out.println(suv.accelerate());
        System.out.println(suv.brake());
    }
}

