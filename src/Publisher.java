import java.util.ArrayList;
import java.util.Objects;

public class Publisher {
    String name;
    Address address;
    ArrayList<Book> publishedBooks = new ArrayList<>();

    public Publisher(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public void addBook(Book book){
        if(!publishedBooks.contains(book)) publishedBooks.add(book);
    }


    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public ArrayList<Book> getAllPublishedBooks() {
        return publishedBooks;
    }

    @Override
    public String toString() {
        return "Publisher: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(name, publisher.name) && Objects.equals(address, publisher.address) && Objects.equals(publishedBooks, publisher.publishedBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, publishedBooks);
    }
}
