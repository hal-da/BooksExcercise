import java.util.ArrayList;
import java.util.Objects;

public class Author extends Person{
    ArrayList<Book> books;
    ArrayList<Publisher> publishers;

    public Author(String firstName, String lastName) {
        super(firstName, lastName);
        books = new ArrayList<>();
        publishers = new ArrayList<>();
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
        Author author = (Author) o;
        return Objects.equals(books, author.books) && Objects.equals(publishers, author.publishers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books, publishers);
    }
}
