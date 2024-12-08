package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {

    public static final String CANNOT_REMOVE_BOOK_NOT_REGISTERED = "cannot remove, book not registered";
    public static String BookAlreadyRegistered = "book already registered";
    private List<Book> books;
    private List<Book> rented;

    public Library() {
        books = new ArrayList<>();
        rented = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (isInLibrary(book)) {
            throw new RuntimeException(BookAlreadyRegistered);
        }
        books.add(book);
    }



    public void rentBook( Book book ) {
    if (!books.contains( book )) { 
      throw new RuntimeException( "book unavailable" );
    }
    rented.add( book );
    books.remove(book);
  }

  public void returnBook( Book book ) {
    if (!rented.contains( book )) { 
      throw new RuntimeException( "book not rented" );
    }
    books.add( book );
    rented.remove(book);
  }

  public void removeBook( Book book ) {
    if (!isInLibrary(book) ) {
      throw new RuntimeException(CANNOT_REMOVE_BOOK_NOT_REGISTERED);
    }
    books.remove(book);
    rented.remove(book);
  }

  public List<Book> searchAvailableByGenre( String genre ) {
    List<Book> result = new ArrayList<>();
    for (Book book : books) {
      if (book.getGenre().equals( genre )) { result.add( book ); }
    }
    return result;
  }

  public List<Book> searchAvailableByAuthor( String author ) {
    List<Book> result = new ArrayList<>();
    for (Book book : books) {
      if (book.getAuthor().equals( author )) { result.add( book ); }
    }
    return result;
  }

  public int available() {
    return books.size();
  }
  private boolean isInLibrary(Book book) {
        return books.contains(book) || rented.contains(book);
    }
}
