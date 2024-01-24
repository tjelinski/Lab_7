package Book;

import java.io.*;
import java.util.*;
public class NonFictionBook extends Book implements Serializable {
    private String topic;

    public NonFictionBook(String title, String author, String topic) {
        super(title, author);
        this.topic = topic;
    }

    protected Object getAdditionalInfo() {
        return topic;
    }

    protected Object getGenre() {
        return "NonFiction";
    }

    @Override
    public void displayInfo() {
        System.out.println("Non-Fiction Book:");
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Topic: " + topic);
        System.out.println();
    }
}
