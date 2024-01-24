package Zajecia;

import java.io.*;

public class FillText {
    public static void main(String[] args) {
        String sciezkaDoPliku = System.getProperty("user.home") + "/Desktop/plik.txt";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(sciezkaDoPliku));
            PrintStream customOut = new PrintStream(fileOutputStream);
            System.setOut(customOut);
            System.out.println("This is text write to file.");
            System.setOut(System.out);
            customOut.close();
            System.out.println("Data write to file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

