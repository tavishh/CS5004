import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoeTest {
  private Shoe adidasBoost;
  private Shoe clarksOxford;


  @BeforeEach
  void setUp() {
    this.adidasBoost = new Shoe(Kind.SNEAKER, Color.BLACK, Brand.ADIDAS, 7.5);
    this.clarksOxford = new Shoe(Kind.DRESS, Color.WHITE, Brand.CLARKS, 10.0);
  }

  @Test
  void testConstructorValid(){
    // Test that valid shoes are created without exception
    Shoe newShoe = new Shoe(Kind.DRESS, Color.BLACK, Brand.TIMBERLAND, 9.0);
    assertEquals(Kind.DRESS, newShoe.getKind());
    assertEquals(Brand.TIMBERLAND, newShoe.getBrand());
  }

  @Test
  void testConstructorThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Shoe(Kind.DRESS, Color.BLACK, Brand.NIKE, 8.0);
    });
    // Verify other brands CAN sell dress shoes
    assertDoesNotThrow(() -> {
      new Shoe(Kind.DRESS, Color.BLACK, Brand.CLARKS, 8.0);
    });
  }

  @Test
  void getKind() {
    assertEquals(Kind.SNEAKER, adidasBoost.getKind());
    assertEquals(Kind.DRESS, clarksOxford.getKind());
  }

  @Test
  void getColor() {
    assertEquals(Color.BLACK, adidasBoost.getColor());
    assertEquals(Color.WHITE, clarksOxford.getColor());
  }

  @Test
  void getBrand() {
    assertEquals(Brand.ADIDAS, adidasBoost.getBrand());
    assertEquals(Brand.CLARKS, clarksOxford.getBrand());
  }

  @Test
  void getSize() {
    assertEquals(7.5, adidasBoost.getSize());
    assertEquals(10, clarksOxford.getSize());
  }

  @Test
  void testToString() {
    //Verify toString contains all 4 attributes
    String adidasStr = adidasBoost.toString();
    assertTrue(adidasStr.contains("Adidas"));
    assertTrue(adidasStr.contains("Black"));
    assertTrue(adidasStr.contains("Sneaker"));
    assertTrue(adidasStr.contains("7.5"));

    String clarksStr = clarksOxford.toString();
    assertTrue(clarksStr.contains("Clarks"));
    assertTrue(clarksStr.contains("White"));
    assertTrue(clarksStr.contains("Dress"));
    assertTrue(clarksStr.contains("10"));
  }
}