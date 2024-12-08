package biblioteca;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class LibraryTest {

  @Test public void testNewLibraryHasNoAuthors() {
    assertTrue( new Library().searchAvailableByAuthor( "Anonimous" ).isEmpty() );
  }

  @Test public void testNewLibraryHasNoGenres() {
    assertTrue( new Library().searchAvailableByGenre( "SiFy" ).isEmpty() );
  }

  @Test public void testNewLibraryHasNoStock() {
    assertEquals( 0, new Library().available() );
  }

  @Test public void testLibraryWhitABookHasStock() {
    Library library = new Library();
    library.addBook(java4Dummies());
    assertEquals( 1, library.available() );
  }

  @Test public void testLibraryWhitABookFindsItsGenre() {
    Library library = new Library();
    library.addBook(java4Dummies());
    assertTrue( library.searchAvailableByGenre( java4Dummies().getGenre() )
            .contains(java4Dummies()) );
  }


  @Test public void testLibraryWhitABookFindsItsAuthor() {
    Library library = new Library();
    library.addBook(java4Dummies());
    assertTrue( library.searchAvailableByAuthor( java4Dummies().getAuthor() )
            .contains(java4Dummies()) );
  }

  @Test public void testLibraryWhitABookRemoved() { //Son importantes los espacios entre lineas de código para que sea más claro
    Library library = new Library();
    library.addBook(java4Dummies());

    assertEquals( 1, library.available() );

    library.removeBook(java4Dummies());
    assertEquals( 0, library.available() );
  }

  @Test public void testLibraryWhitNoBooktoRemove() {
    Library library = new Library();

    assertEquals("cannot remove, book not registered", assertThrows(Exception.class, ()-> library.removeBook(java4Dummies())).getMessage());
  }
  
  @Test public void testLibraryWhitTwiceABook() {
    Library library = new Library();
    library.addBook(java4Dummies());

    assertThrowsLike(library.BookAlreadyRegistered, ()-> library.addBook(java4Dummies()));
    assertEquals( 1, library.available() );

  }
  public void assertThrowsLike(String msg, Executable codeToRun){
    assertEquals(msg, assertThrows(Exception.class, codeToRun).getMessage());

  }

  @Test public void testFiltersAuthorsOnLibrary() { //tarea
    Library library = new Library();
    library.addBook(java4Dummies());
    library.addBook(pythonForDummies());
    library.addBook(TolkienUniverse());

    assertEquals( 3, library.available() );
    assertTrue( library.searchAvailableByAuthor( "Martin Fowler" ).contains(java4Dummies()) );
    assertTrue( library.searchAvailableByAuthor( "Martin Fowler" ).contains(TolkienUniverse()) );
    assertFalse( library.searchAvailableByAuthor( "Martin Fowler" ).contains(pythonForDummies()) );
  }



  @Test public void testFiltersGenreOnLibrary() { //tarea
    Library library = new Library();
    library.addBook(java4Dummies());
    library.addBook(pythonForDummies());
    library.addBook(TolkienUniverse());

    assertEquals( 3, library.available() );
    assertTrue( library.searchAvailableByGenre( "IT" ).contains(java4Dummies()) );
    assertTrue( library.searchAvailableByGenre( "IT" ).contains(pythonForDummies()) );
    assertFalse( library.searchAvailableByGenre( "IT" ).contains(TolkienUniverse()) );
  }

  // nuevo feature, alquiler de libros!
  
  @Test public void testSucessfulRent() {
    Library library = new Library();
    library.addBook(java4Dummies());
    
    library.rentBook(java4Dummies());
    
    assertEquals( 0, library.available() );
  }

  @Test public void testUnexistentRent() {
    Library library = new Library();
    assertEquals ("book unavailable", assertThrows(Exception.class, ()->library.rentBook(java4Dummies())).getMessage());

  }

  @Test public void testRentTwice() {
    Library library = new Library();
    library.addBook(java4Dummies());
    
    library.rentBook(java4Dummies());
      
    try {
      library.rentBook(java4Dummies());
      fail( "Ups" );
    } catch (Exception e) {
      assertEquals( "book unavailable", e.getMessage() );
    }
  }

  @Test public void testRestoreRented() {
    Library library = new Library();
    library.addBook(java4Dummies());
    
    library.rentBook(java4Dummies());

    library.returnBook(java4Dummies());
      
    assertEquals( 1, library.available() );
  }

  @Test public void testRestoreUnrented() {
    Library library = new Library();
    library.addBook(java4Dummies());
    
    try {
      library.returnBook(java4Dummies());
      fail( "Ups" );
    } catch (Exception e) {
      assertEquals( "book not rented", e.getMessage() );
    }
     
    assertEquals( 1, library.available() );
  }

  @Test public void testLibraryWhitARentedBookRemoved() {
    Library library = new Library();
    library.addBook(java4Dummies());

    library.rentBook(java4Dummies());

    library.removeBook(java4Dummies());
    try {
      library.returnBook(java4Dummies());
      fail( "Ups" );
    } catch (Exception e) {
      assertEquals( "book not rented", e.getMessage() );
    } 
  }

  private Book java4Dummies() {
    return new Book("Martin Fowler", "Java4Dummies", "IT");
  }

  private Book pythonForDummies() {
    return new Book("Chamond Liu", "pythonForDummies", "IT");
  }

  private static Book TolkienUniverse() {
    return new Book("Martin Fowler", "TolkienUniverse", "SiFi");
  }


}
