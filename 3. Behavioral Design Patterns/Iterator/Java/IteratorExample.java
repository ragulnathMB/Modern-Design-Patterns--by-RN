// Iterator Pattern Example in Java
// Book collection that can be iterated through

import java.util.*;

class Book {
    private final String title;
    private final String author;
    public Book(String title, String author) { this.title = title; this.author = author; }
    public String toString() { return title + " by " + author; }
}

interface Iterator<T> { boolean hasNext(); T next(); }
interface BookCollection { Iterator<Book> createIterator(); }

class BookIterator implements Iterator<Book> {
    private final List<Book> books;
    private int index = 0;
    public BookIterator(List<Book> books) { this.books = books; }
    public boolean hasNext() { return index < books.size(); }
    public Book next() { return books.get(index++); }
}

class ConcreteBookCollection implements BookCollection {
    private final List<Book> books = new ArrayList<>();
    public void addBook(Book book) { books.add(book); }
    public Iterator<Book> createIterator() { return new BookIterator(books); }
}

public class IteratorExample {
    public static void main(String[] args) {
        ConcreteBookCollection collection = new ConcreteBookCollection();
        collection.addBook(new Book("1984", "George Orwell"));
        collection.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        collection.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));

        Iterator<Book> iterator = collection.createIterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
}
