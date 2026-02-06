import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests specific to the Triangle class.
 * Tests Triangle's constructor, area, perimeter, and toString methods.
 */
public class TriangleTest {

  /**
   * Tests Triangle constructor with valid points
   */
  @Test
  public void testValidConstructor() {
    Triangle triangle = new Triangle(0, 0, 4, 0, 0, 3);
    assertEquals("Triangle: point1 (0.000,0.000) point2 (4.000,0.000) point3 (0.000,3.000)",
            triangle.toString());
  }

  /**
   * Tests another Triangle constructor with valid points
   */
  @Test
  public void testValidConstructor2() {
    Triangle triangle = new Triangle(1, 1, 4, 1, 2.5, 4);
    assertEquals("Triangle: point1 (1.000,1.000) point2 (4.000,1.000) point3 (2.500,4.000)",
            triangle.toString());
  }

  /**
   * Tests that constructor throws exception when points 1 and 2 are identical
   */
  @Test
  public void testIdenticalPoints1And2() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Triangle(1, 1, 1, 1, 3, 3);
    });
  }

  /**
   * Tests that constructor throws exception when points 1 and 3 are identical
   */
  @Test
  public void testIdenticalPoints1And3() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Triangle(2, 2, 5, 5, 2, 2);
    });
  }

  /**
   * Tests that constructor throws exception when points 2 and 3 are identical
   */
  @Test
  public void testIdenticalPoints2And3() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Triangle(1, 1, 3, 3, 3, 3);
    });
  }

  /**
   * Tests that constructor throws exception when all three points are identical
   */
  @Test
  public void testAllIdenticalPoints() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Triangle(5, 5, 5, 5, 5, 5);
    });
  }

  /**
   * Tests that a valid triangle with distinct points does not throw exception
   */
  @Test
  public void testValidTriangleNoException() {
    assertDoesNotThrow(() -> {
      Triangle triangle = new Triangle(0, 0, 3, 0, 0, 4);
      assertNotNull(triangle);
    });
  }

  /**
   * Tests Triangle area calculation for a right triangle
   */
  @Test
  public void testTriangleArea() {
    Triangle triangle = new Triangle(0, 0, 4, 0, 0, 3);
    assertEquals(6.0, triangle.area(), 0.001);
  }

  /**
   * Tests Triangle area calculation for another triangle
   */
  @Test
  public void testTriangleArea2() {
    Triangle triangle = new Triangle(1, 1, 4, 1, 2.5, 4);
    assertEquals(4.5, triangle.area(), 0.001);
  }

  /**
   * Tests Triangle area for collinear points (should be 0)
   */
  @Test
  public void testCollinearTriangleArea() {
    Triangle triangle = new Triangle(0, 0, 2, 0, 4, 0);
    assertEquals(0.0, triangle.area(), 0.001);
  }

  /**
   * Tests another collinear triangle area
   */
  @Test
  public void testCollinearTriangleArea2() {
    Triangle triangle = new Triangle(1, 1, 2, 2, 3, 3);
    assertEquals(0.0, triangle.area(), 0.001);
  }

  /**
   * Tests Triangle perimeter calculation
   */
  @Test
  public void testTrianglePerimeter() {
    Triangle triangle = new Triangle(0, 0, 4, 0, 0, 3);
    assertEquals(12.0, triangle.perimeter(), 0.001);
  }

  /**
   * Tests another Triangle perimeter calculation
   */
  @Test
  public void testTrianglePerimeter2() {
    Triangle triangle = new Triangle(1, 1, 4, 1, 2.5, 4);
    assertEquals(10.155, triangle.perimeter(), 0.001);
  }

  /**
   * Tests Triangle perimeter for equilateral triangle
   */
  @Test
  public void testEquilateralTrianglePerimeter() {
    Triangle triangle = new Triangle(0, 0, 2, 0, 1, Math.sqrt(3));
    assertEquals(6.0, triangle.perimeter(), 0.001);
  }

  /**
   * Tests Triangle perimeter for isosceles triangle
   */
  @Test
  public void testIsoscelesTrianglePerimeter() {
    Triangle triangle = new Triangle(0, 0, 4, 0, 2, 3);
    assertEquals(10.944, triangle.perimeter(), 0.001);
  }

  /**
   * Tests Triangle toString format
   */
  @Test
  public void testTriangleToString() {
    Triangle triangle = new Triangle(1.5, 2.5, 3.5, 4.5, 5.5, 6.5);
    assertEquals("Triangle: point1 (1.500,2.500) point2 (3.500,4.500) point3 (5.500,6.500)",
            triangle.toString());
  }

  /**
   * Tests another Triangle toString format
   */
  @Test
  public void testTriangleToString2() {
    Triangle triangle = new Triangle(0, 0, 1, 0, 0, 1);
    assertEquals("Triangle: point1 (0.000,0.000) point2 (1.000,0.000) point3 (0.000,1.000)",
            triangle.toString());
  }
}
