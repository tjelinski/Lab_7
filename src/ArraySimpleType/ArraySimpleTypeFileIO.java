package ArraySimpleType;

import java.io.*;
import java.util.*;

public class ArraySimpleTypeFileIO {

    public static void saveArrayToFile(int[] array, String fileName) {
        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop" + File.separator;
        try (PrintWriter writer = new PrintWriter(new FileWriter(desktopPath + fileName))) {
            for (int value : array) {
                writer.println(value);
            }
            System.out.println("Array saved to file: " + desktopPath + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] loadArrayFromFile(String fileName) {
        int[] loadedArray = null;
        List<Integer> arrayList = new ArrayList<>();
        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop" + File.separator;

        try (Scanner scanner = new Scanner(new File(desktopPath + fileName))) {
            while (scanner.hasNextInt()) {
                arrayList.add(scanner.nextInt());
            }
            loadedArray = arrayList.stream().mapToInt(Integer::intValue).toArray();
            System.out.println("Array loaded from file: " + desktopPath + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedArray;
    }
}
