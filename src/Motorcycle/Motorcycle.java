package Motorcycle;

import java.io.*;
import java.util.Arrays;

public class Motorcycle implements Serializable {
    private String brand;
    private String model;
    private int year;

    public Motorcycle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

    public static void saveArrayToFile(Motorcycle[] array, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(array);
            System.out.println("Array saved to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Motorcycle[] loadArrayFromFile(String fileName) {
        Motorcycle[] loadedArray = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            loadedArray = (Motorcycle[]) ois.readObject();
            System.out.println("Array loaded from file: " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loadedArray;
    }
}
