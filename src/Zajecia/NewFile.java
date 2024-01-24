package Zajecia;

import java.io.*;

public class NewFile {
    public static void main(String[] args) {
        String filePath = System.getProperty("user.home") + "/Desktop/plik.txt";

        try {
            File newFile = new File(filePath);
            if (newFile.createNewFile()) {
                System.out.println("File was created.");
            } else {
                System.out.println("File exist.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

