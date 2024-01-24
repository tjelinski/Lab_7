package Book;

import java.io.*;
import java.util.*;

public class BookManager {
    private ArrayList<Book> books;

    public BookManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooksInfo() {
        for (Book book : books) {
            book.displayInfo();
        }
    }

    public void saveBooksToFile(String fileName) {
        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + fileName;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(desktopPath))) {
            for (Book book : books) {
                writer.write(book.toTextFormat());
                writer.newLine();
            }
            System.out.println("Book information saved to file: " + desktopPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readBooksFromFile(String fileName) {
        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + fileName;

        try (BufferedReader reader = new BufferedReader(new FileReader(desktopPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Book book = Book.parseFromText(line);
                if (book != null) {
                    books.add(book);
                }
            }
            System.out.println("Books loaded from file: " + desktopPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
