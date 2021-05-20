import java.util.HashMap;

public class Library {

    private final HashMap<String, Book> bookHashMap = new HashMap<>();


    public void addBook(Book book) throws BookAlreadyInCollectionException{

        if(bookHashMap.containsKey(book.getIsbn())) {
            throw new BookAlreadyInCollectionException(book.getTitle() + " already In Collection");
        } else bookHashMap.computeIfAbsent(book.getIsbn(), T-> book);
    }

    public Book getABook(String isbn){
        return bookHashMap.get(isbn);
    }

    public void removeBook(String isbn){
        System.out.println("Should ask if really really sure");
        bookHashMap.remove(isbn);
    }

    public HashMap<String, Book> getBookHashMap() {
        return bookHashMap;
    }

    @Override
    public String toString() {
        return "Library: "+ bookHashMap;
    }
}
