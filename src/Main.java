import Book.BookManager;
import Book.FictionBook;
import Book.NonFictionBook;
import CarDealership.CarDealership;
import Driver.Car;
import Motorcycle.Motorcycle;
import Motorcycle.ObjectArray;
import ArraySimpleType.ArraySimpleTypeFileIO;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car driverWithCar = new Car("Tomasz", "Jeliński", 40, "12345678901", "ABC123", 2020, "Chevrolet", "Orlando");
        driverWithCar.displayCarInfo();

        int[] originalArray = {1, 2, 3, 4, 5};
        saveArrayToFile(originalArray, "arrayFile.dat");
        int[] loadedArray = loadArrayFromFile("arrayFile.dat");

        if (loadedArray != null) {
            System.out.print("Loaded Array: ");
            for (int value : loadedArray) {
                System.out.print(value + " ");
            }
        }

        Motorcycle[] motorcycles = {
                new Motorcycle("Honda", "CBR1000RR", 2012),
                new Motorcycle("Yamaha", "FZS", 2002),
                new Motorcycle("Ducati", "Monster", 1999)
        };

        saveMotorcyclesToFile(motorcycles, "motorcyclesArray.dat");

        Motorcycle[] loadedMotorcycles = ObjectArray.loadArrayFromFile("motorcyclesArray.dat");

        if (loadedMotorcycles != null) {
            System.out.println("\nLoaded Motorcycles:");
            Arrays.stream(loadedMotorcycles).forEach(System.out::println);
        }

        saveDriverAndCarInfo(driverWithCar, "driverAndCarInfo.txt", true);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter additional driver information:");
        System.out.println("Give the brand of the car:");
        String brand = scanner.nextLine();

        System.out.println("Specify the model of the car:");
        String model = scanner.nextLine();

        CarDealership newCar = new CarDealership(brand, model);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("cars.txt", true))) {
            writer.newLine();
            writer.write(newCar.toString());
            System.out.println("New car added to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Enter additional driver information:");
        System.out.println("First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Last Name:");
        String lastName = scanner.nextLine();

        System.out.println("Age:");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("PESEL:");
        String pesel = scanner.nextLine();

        System.out.println("Enter car information:");
        System.out.println("VIN:");
        String vin = scanner.nextLine();

        System.out.println("Production Year:");
        int productionYear = scanner.nextInt();
        scanner.nextLine();

        Car newDriverWithCar = new Car(firstName, lastName, age, pesel, vin, productionYear, brand, model);

        saveDriverAndCarInfo(newDriverWithCar, "driverAndCarInfo.txt", true);
    }

    private static void saveArrayToFile(int[] array, String fileName) {
        ArraySimpleTypeFileIO.saveArrayToFile(array, fileName);
    }

    private static int[] loadArrayFromFile(String fileName) {
        return ArraySimpleTypeFileIO.loadArrayFromFile(fileName);
    }

    private static void saveMotorcyclesToFile(Motorcycle[] array, String fileName) {
        ObjectArray.saveArrayToFile(array, fileName);
    }

    private static void saveDriverAndCarInfo(Car car, String fileName, boolean append) {
        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop" + File.separator;

        try (PrintWriter writer = new PrintWriter(new FileWriter(desktopPath + fileName, append))) {
            writer.println("\nDriver Information:");
            writer.println("First Name: " + car.getFirstName());
            writer.println("Last Name: " + car.getLastName());
            writer.println("Age: " + car.getAge());
            writer.println("PESEL: " + car.getPesel());
            writer.println("\nCar Information:");
            writer.println("VIN: " + car.getVin());
            writer.println("Production Year: " + car.getProductionYear());
            writer.println("Brand: " + car.getBrand());
            writer.println("Model: " + car.getModel());
            System.out.println("Driver and car information appended to file: " + desktopPath + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FictionBook fictionBook1 = new FictionBook("Tytus Romek i A'Tomek", "J.Christa", "Comics");
        FictionBook fictionBook2 = new FictionBook("kolorowe kredki", "Edek z Krainy Kredek", "Classic");
        NonFictionBook nonFictionBook1 = new NonFictionBook("Pan Tadek", "Adam M.", "History");
        NonFictionBook nonFictionBook2 = new NonFictionBook("Upupieni", "Anonim", "Novel");

        BookManager bookManager = new BookManager();

        bookManager.addBook(fictionBook1);
        bookManager.addBook(fictionBook2);
        bookManager.addBook(nonFictionBook1);
        bookManager.addBook(nonFictionBook2);

        System.out.println("Book information before saving to file:");
        //bookManager.displayAllBooks();
        bookManager.displayBooksInfo();


        bookManager.saveBooksToFile("bookInfo.txt");

        bookManager.readBooksFromFile("bookInfo.txt");

        System.out.println("Book information after loading from file:");
        //bookManager.displayAllBooks();
        bookManager.displayBooksInfo();
    }
}