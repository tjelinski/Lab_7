package Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

abstract class Book implements Serializable {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public abstract void displayInfo();

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    public String toTextFormat() {
        return String.format("%s,%s,%s,%s", getGenre(), getAuthor(), getTitle(), getAdditionalInfo());
    }

    protected abstract Object getAdditionalInfo();

    protected abstract Object getGenre();

    public static Book parseFromText(String text) {
        String[] parts = text.split(",");
        if (parts.length == 4) {
            String genre = parts[0];
            String author = parts[1];
            String title = parts[2];
            String additionalInfo = parts[3];

            if (genre.equals("Fiction")) {
                return new FictionBook(author, title, additionalInfo);
            } else if (genre.equals("NonFiction")) {
                return new NonFictionBook(author, title, additionalInfo);
            }
        }
        return null;
    }

}

