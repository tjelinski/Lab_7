package Book;

import java.io.*;
import java.util.*;
public class FictionBook extends Book implements Serializable {
    private String genre;

    public FictionBook(String title, String author, String genre) {
        super(title, author);
        this.genre = genre;
    }

    protected Object getAdditionalInfo() {
        return genre;
    }

    protected Object getGenre() {
        return "Fiction";
    }

    @Override
    public void displayInfo() {
        System.out.println("Fiction Book:");
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Genre: " + genre);
        System.out.println();
    }
}
