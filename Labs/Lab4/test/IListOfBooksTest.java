import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit5 tests for IListOfBooks implementations: EmptyNode and ElementNode.
 * Contains two assertions per method per class (20 total).
 */

public class IListOfBooksTest {
  private Book book1;
  private Book book2;
  private Book book3;
  private IListOfBooks emptyList;
  private IListOfBooks emptyList2;
  private IListOfBooks oneBookList;
  private IListOfBooks threeBookList;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    book1 = new Book("The Hobbit", "Tolkien", 1937, 12.99f);
    book2 = new Book("1984", "Orwell", 1949, 9.99f);
    book3 = new Book("Dune", "Herbert", 2021, 15.50f);

    emptyList = new EmptyNode();
    emptyList2 = new EmptyNode();
    oneBookList = new ElementNode(book1, new EmptyNode());
    threeBookList = new ElementNode(book1, new ElementNode(
        book2, new ElementNode(book3, new EmptyNode())));

  }

  // Empty Node Tests


  @org.junit.jupiter.api.Test
  void testCountEmptyNode() {
    assertEquals(0, emptyList.count());
    assertEquals(0, emptyList2.count());
  }

  @org.junit.jupiter.api.Test
  void testTotalPriceEmptyNode() {
    assertEquals(0.00, emptyList.totalPrice());
    assertEquals(0.00, emptyList2.totalPrice(),0.1);
  }

  @org.junit.jupiter.api.Test
  void testAllBeforeEmptyNode() {
    assertEquals(0,emptyList.allBefore(2025).count());
    assertEquals(0,emptyList2.allBefore(1950).count());
  }

  @org.junit.jupiter.api.Test
  void testAddAtEndEmptyNode() {
    // Adds  book1 to an empty list -> count increases by 1
    assertEquals(1, emptyList.addAtEnd(book1).count());
    assertEquals(1, emptyList2.addAtEnd(book2).count());
  }

  @org.junit.jupiter.api.Test
  void testToStringEmptyNode() {
    assertEquals("", emptyList.toString());
    assertEquals("", emptyList2.toString());
  }

  // Element Node Tests

  @org.junit.jupiter.api.Test
  void testCountElementNode() {
    assertEquals(1, oneBookList.count());
    assertEquals(3, threeBookList.count());
  }

  @org.junit.jupiter.api.Test
  void testTotalPriceElementNode() {
    assertEquals(12.99f, oneBookList.totalPrice(),0.0001);
    assertEquals(38.48f, threeBookList.totalPrice(),0.0001);
  }

  @org.junit.jupiter.api.Test
  void testAllBeforeElementNode() {
    assertEquals(1,oneBookList.allBefore(2025).count());
    assertEquals(2, threeBookList.allBefore(1950).count());
  }

  @org.junit.jupiter.api.Test
  void testAddAtEndElementNode() {
    Book book4 = new Book("Absolute Java", "Savitch", 2004, 100.00f);
    assertEquals(2, oneBookList.addAtEnd(book2).count());
    assertEquals(4, threeBookList.addAtEnd(book4).count());
  }

  @org.junit.jupiter.api.Test
  void testToStringElementNode() {
    assertEquals("Title: The Hobbit Author: Tolkien Year: 1937 Price: 12.99", oneBookList.toString());
    assertEquals("Title: The Hobbit Author: Tolkien Year: 1937 Price: 12.99\n"
            + "Title: 1984 Author: Orwell Year: 1949 Price: 9.99\n"
            + "Title: Dune Author: Herbert Year: 2021 Price: 15.50",
        threeBookList.toString());
  }

}

