import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class BookShelf {
    private ArrayList<Book> books = new ArrayList<>();

    public BookShelf() {
    }

    public ArrayList<Book> searchForTitle(String title){
        ArrayList<Book> foundBooks = new ArrayList<>();

        for(Book book : books){
            if(book.getTitle().toLowerCase().contains(title.toLowerCase())) foundBooks.add(book);
        }
        return foundBooks;
    }

    public ArrayList<Book> searchForAuthor(Author author){
        ArrayList<Book> foundBooks = new ArrayList<>();

        for(Book book : books){
            for(Author authorInBooks : book.getAuthors()){
                if(authorInBooks.equals(author)) foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public ArrayList<Book> searchForAuthorLastName(String lastName){
        ArrayList<Book> foundBooks = new ArrayList<>();

        for(Book book : books){
            for(Author authorInBooks : book.getAuthors()){
                if(authorInBooks.getLastName().contains(lastName)) foundBooks.add(book);
            }
        }
        return foundBooks;
    }



    public void addBook(Book book){
        if(!books.contains(book)) books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return books + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookShelf bookShelf = (BookShelf) o;
        return Objects.equals(books, bookShelf.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }
}
