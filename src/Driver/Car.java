package Driver;

import java.io.Serializable;

public class Car extends Driver implements Serializable {
    private String vin;
    private int productionYear;
    private String brand;
    private String model;

    public Car(String firstName, String lastName, int age, String pesel, String vin, int productionYear, String brand, String model) {
        super(firstName, lastName, age, pesel);
        this.vin = vin;
        this.productionYear = productionYear;
        this.brand = brand;
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void displayCarInfo() {
        displayInfo();
        System.out.println("VIN: " + vin);
        System.out.println("Production Year: " + productionYear);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
    }
}
