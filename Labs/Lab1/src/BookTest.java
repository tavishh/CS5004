import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {
  private Book theHobbit;

  @BeforeEach
  void setUp() {
    this.theHobbit = new Book("The Hobbit", "J.R.R Tolkien", 300);
  }

  @Test
  void getTitle() {
    Assertions.assertEquals("The Hobbit", theHobbit.getTitle());
  }

  @Test
  void getAuthor() {
    Assertions.assertEquals("J.R.R Tolkien", theHobbit.getAuthor());
  }

  @Test
  void getPages() {
    Assertions.assertEquals(300, theHobbit.getPages());
  }
}