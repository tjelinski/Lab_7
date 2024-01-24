package Zajecia;


import java.io.File;

public class DelFile {
    public static void main(String[] args) {
        String filePath = System.getProperty("user.home") + "/Desktop/plik.txt";

        File fileToDelete = new File(filePath);
        if (fileToDelete.exists()) {
            if (fileToDelete.delete()) {
                System.out.println("File was deleted.");
            } else {
                System.out.println("Can't delete a file.");
            }
        } else {
            System.out.println("File not exist.");
        }
    }
}

