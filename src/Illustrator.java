import java.util.ArrayList;
import java.util.Objects;

public class Illustrator extends Person {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Publisher> publishers = new ArrayList<>();

    public Illustrator(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void addBook(Book book){
        if(!books.contains(book))books.add(book);
    }

    public void addPublisher(Publisher publisher){
        if(!publishers.contains(publisher)) publishers.add(publisher);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Publisher> getPublishers() {
        return publishers;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Illustrator that = (Illustrator) o;
        return Objects.equals(books, that.books) && Objects.equals(publishers, that.publishers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), books, publishers);
    }
}
