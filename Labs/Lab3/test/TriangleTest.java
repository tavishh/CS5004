import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests specific to the Triangle class.
 * Tests Triangle's constructor, area, perimeter, and toString methods.
 */
public class TriangleTest {

  @BeforeEach
  void setUp() {
  }

  /**
   * Tests Triangle constructor with valid points
   */
  @Test
  void testValidConstructor() {
    Triangle triangle = new Triangle(0, 0, 4, 0, 0, 3);
    assertEquals("Triangle: point1 (0.000,0.000) point2 (4.000,0.000) point3 (0.000,3.000)",
        triangle.toString());
    Triangle triangle2 = new Triangle(1, 1, 4, 1, 2.5, 4);
    assertEquals("Triangle: point1 (1.000,1.000) point2 (4.000,1.000) point3 (2.500,4.000)",
        triangle2.toString());
  }

  /**
   * Tests that constructor throws exception when two points are identical
   */
  @Test
  void testIdenticalPointsException() {
    assertThrows(IllegalArgumentException.class, () -> {
      new Triangle(1, 1, 1, 1, 3, 3);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Triangle(2, 2, 5, 5, 2, 2);
    });
  }

  /**
   * Tests that a valid triangle does not throw exception
   */
  @Test
  void testValidTriangleNoException() {
    assertDoesNotThrow(() -> {
      new Triangle(0, 0, 3, 0, 0, 4);
    });
    assertDoesNotThrow(() -> {
      new Triangle(1, 1, 4, 1, 2.5, 4);
    });
  }

  /**
   * Tests Triangle toString format
   */
  @Test
  void testToString() {
    Triangle triangle = new Triangle(0, 0, 1, 0, 0, 1);
    assertEquals("Triangle: point1 (0.000,0.000) point2 (1.000,0.000) point3 (0.000,1.000)",
        triangle.toString());
    Triangle triangle2 = new Triangle(1.5, 2.5, 3.5, 4.5, 5.5, 6.5);
    assertEquals("Triangle: point1 (1.500,2.500) point2 (3.500,4.500) point3 (5.500,6.500)",
        triangle2.toString());
  }

  /**
   * Tests Triangle perimeter calculation
   */
  @Test
  void testPerimeter() {
    Triangle triangle = new Triangle(0, 0, 4, 0, 0, 3);
    assertEquals(12.0, triangle.perimeter(), 0.001);
    Triangle triangle2 = new Triangle(1, 1, 4, 1, 2.5, 4);
    assertEquals(9.708, triangle2.perimeter(), 0.001);
  }

  /**
   * Tests Triangle area calculation
   */
  @Test
  void testArea() {
    Triangle triangle = new Triangle(0, 0, 4, 0, 0, 3);
    assertEquals(6.0, triangle.area(), 0.001);
    Triangle triangle2 = new Triangle(1, 1, 4, 1, 2.5, 4);
    assertEquals(4.5, triangle2.area(), 0.001);
  }

  /**
   * Tests Triangle resize method
   */
  @Test
  void testResize() {
    Triangle triangle = new Triangle(0, 0, 4, 0, 0, 3);
    Shape resized = triangle.resize(2.0);
    assertEquals(2.0 * triangle.area(), resized.area(), 0.001);
    Triangle triangle2 = new Triangle(1, 1, 4, 1, 2.5, 4);
    Shape resized2 = triangle2.resize(0.5);
    assertEquals(0.5 * triangle2.area(), resized2.area(), 0.001);
  }
}
