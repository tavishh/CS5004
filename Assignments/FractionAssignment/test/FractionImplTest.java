import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FractionImplTest {
  private Fraction half;
  private Fraction oneThird;
  private Fraction negativeNumerator;
  private Fraction negativeDenominator;

  @BeforeEach
  void setUp() {
    half = new FractionImpl(1, 2);
    oneThird  = new FractionImpl(1, 3);
    negativeNumerator = new FractionImpl(-3, 4);
    negativeDenominator = new FractionImpl(1, -3);
  }

  // ---------- Constructor tests ----------

  @Test
  void testConstructorValidPositive() {
    assertEquals(1, oneThird.getNumerator());
    assertEquals(3, oneThird.getDenominator());
  }

  @Test
  void testNegativeNumerator() {
    assertEquals(-3, negativeNumerator.getNumerator());
    assertEquals(4, negativeNumerator.getDenominator());
  }

  @Test
  void testBothNegative() {
    Fraction f = new FractionImpl(-3, -4);
    assertEquals(3, f.getNumerator());
    assertEquals(4, f.getDenominator());
  }

  @Test
  void testZeroNumerator() {
    Fraction z = new FractionImpl(0, 2);
    assertEquals(0, z.getNumerator());
    assertEquals(2, z.getDenominator());
  }

  @Test
  void testGetNegativeDenominator() {
    assertEquals(3, negativeDenominator.getDenominator());
  }

  @Test
  void testZeroDenominator() {
    assertThrows(IllegalArgumentException.class, () -> new FractionImpl(1, 0));
  }

  // ---------- Setter tests ----------

  @Test
  void testSetDenominator() {
    Fraction f = new FractionImpl(3, 5);
    f.setDenominator(10);
    assertEquals(3, f.getNumerator());
    assertEquals(10, f.getDenominator());
  }

  @Test
  void testSetDenominatorThrows() {
    assertThrows(IllegalArgumentException.class, () -> half.setDenominator(0));
    assertThrows(IllegalArgumentException.class, () -> half.setDenominator(-5));
  }

  @Test
  void testSetNumerator() {
    Fraction f = new FractionImpl(1, 2);
    f.setNumerator(5);
    assertEquals(5, f.getNumerator());
    assertEquals(2, f.getDenominator());
  }

  // ---------- toDouble ----------

  @Test
  void testToDouble() {
    assertEquals(0.5, half.toDouble(), 1e-9);
    assertEquals(1.0 / 3.0, oneThird.toDouble(), 1e-9);
  }

  @Test
  void testToDoubleNegative() {
    assertEquals(-0.75, negativeNumerator.toDouble(), 1e-9);
  }

  // ---------- toString ----------

  @Test
  void testToStringSimplifies() {
    Fraction f = new FractionImpl(6, 8);
    assertEquals("3 / 4", f.toString());
  }

  @Test
  void testToStringNegative() {
    Fraction f = new FractionImpl(-2, 4);
    assertEquals("-1 / 2", f.toString());
  }

  @Test
  void testToStringZero() {
    Fraction f = new FractionImpl(0, 5);
    assertEquals("0 / 1", f.toString());
  }

  // ---------- reciprocal ----------

  @Test
  void testReciprocal() {
    Fraction r = half.reciprocal();
    assertEquals("2 / 1", r.toString());
  }

  @Test
  void testReciprocalNegative() {
    Fraction r = negativeNumerator.reciprocal();
    assertEquals("-4 / 3", r.toString());
  }

  @Test
  void testReciprocalZeroThrows() {
    Fraction f = new FractionImpl(0, 5);
    assertThrows(ArithmeticException.class, f::reciprocal);
  }

  // ---------- add ----------

  @Test
  void testAdd() {
    Fraction sum = half.add(oneThird);
    assertEquals("5 / 6", sum.toString());
  }

  @Test
  void testAddNegative() {
    Fraction f1 = new FractionImpl(-1, 2);
    Fraction f2 = new FractionImpl(1, 2);
    assertEquals("0 / 1", f1.add(f2).toString());
  }

  @Test
  void testAddDifferentDenominator() {
    Fraction f1 = new FractionImpl(2, 5);
    Fraction f2 = new FractionImpl(1, 10);
    assertEquals("1 / 2", f1.add(f2).toString());
  }

  // ---------- compareTo ----------

  @Test
  void testCompareToLess() {
    assertTrue(oneThird.compareTo(half) < 0);
  }

  @Test
  void testCompareToGreater() {
    Fraction f = new FractionImpl(3, 4);
    assertTrue(f.compareTo(half) > 0);
  }

  @Test
  void testCompareToEqual() {
    Fraction f = new FractionImpl(2, 4);
    assertEquals(0, f.compareTo(half));
  }

  @Test
  void testCompareToNegative() {
    assertTrue(negativeNumerator.compareTo(half) < 0);
  }

  @Test
  void testCompareToLargeValues() {
    Fraction big1 = new FractionImpl(1_000_000, 3);
    Fraction big2 = new FractionImpl(999_999, 3);
    assertTrue(big1.compareTo(big2) > 0);
  }
}