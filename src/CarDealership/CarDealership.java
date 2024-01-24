package CarDealership;

public class CarDealership {
    private String brand;
    private String model;

    public CarDealership(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return brand + " " + model;
    }
}


