import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains all the unit tests for various kinds of shapes
 */
public class ShapeTest {

  Shape circle1,circle2,circle3,rect1,rect2,triangle1,triangle2;

  @BeforeEach
  public void setup() {
    circle1 = new Circle(3,4,5);
    circle2 = new Circle(10.32,10.43,10);
    circle3 = new Circle(20);

    rect1 = new Rectangle(5,6,2.5,2);
    rect2 = new Rectangle(2,3,10,10);

    triangle1 = new Triangle(0,0,4,0,0,3);
    triangle2 = new Triangle(1,1,4,1,2.5,4);
  }

  /**
   * Tests whether objects have been created with the correct numbers or not.
   * It does this by using their toString methods
   */
  @Test
  public void testObjectData() {
    assertEquals("Circle: center (3.000,4.000) radius 5.000",circle1.toString
            ());
    assertEquals("Circle: center (10.320,10.430) radius 10.000",circle2.toString
            ());
    assertEquals("Circle: center (0.000,0.000) radius 20.000",circle3
            .toString
            ());
    assertEquals("Rectangle: LL corner (5.000,6.000) width 2.500 height 2.000",
            rect1.toString());
    assertEquals("Rectangle: LL corner (2.000,3.000) width 10.000 height 10" +
            ".000",rect2
            .toString());
    assertEquals("Triangle: point1 (0.000,0.000) point2 (4.000,0.000) point3 (0.000,3.000)",
            triangle1.toString());
    assertEquals("Triangle: point1 (1.000,1.000) point2 (4.000,1.000) point3 (2.500,4.000)",
            triangle2.toString());
  }

  /**
   * Tests whether the area methods work correctly for all shapes
   */
  @Test
  public void testArea() {
    assertEquals(Math.PI*25,circle1.area(),0.001);
    assertEquals(Math.PI*100,circle2.area(),0.001);
    assertEquals(Math.PI*400,circle3.area(),0.001);
    assertEquals(5,rect1.area(),0.001);
    assertEquals(100,rect2.area(),0.001);
    assertEquals(6.0,triangle1.area(),0.001);
    assertEquals(4.5,triangle2.area(),0.001);
  }

  /**
   * Tests whether the perimeter methods work correctly for all shapes
   */
  @Test
  public void testPerimeter() {
    assertEquals(2*Math.PI*5,circle1.perimeter(),0.001);
    assertEquals(2*Math.PI*10,circle2.perimeter(),0.001);
    assertEquals(2*Math.PI*20,circle3.perimeter(),0.001);
    assertEquals(9,rect1.perimeter(),0.001);
    assertEquals(40,rect2.perimeter(),0.001);
    assertEquals(12.0,triangle1.perimeter(),0.001);
    assertEquals(10.155,triangle2.perimeter(),0.001);
  }

  @Test
  public void testResizes() {
    Shape resizedCircle1,resizedCircle2,resizedCircle3,resizedRect1,
            resizedRect2,resizedTriangle1,resizedTriangle2;

    resizedCircle1 = circle1.resize(2.5);
    resizedCircle2 = circle2.resize(0);
    resizedCircle3 = circle3.resize(10);
    resizedRect1 = rect1.resize(12.5);
    resizedRect2 = rect2.resize(0.001);
    resizedTriangle1 = triangle1.resize(2.0);
    resizedTriangle2 = triangle2.resize(0.5);

    assertEquals(2.5*circle1.area(),resizedCircle1.area(),0.001);
    assertEquals(0*circle2.area(),resizedCircle2.area(),0.001);
    assertEquals(10*circle3.area(),resizedCircle3.area(),0.001);
    assertEquals(12.5*rect1.area(),resizedRect1.area(),0.001);
    assertEquals(0.001*rect2.area(),resizedRect2.area(),0.001);
    assertEquals(2.0*triangle1.area(),resizedTriangle1.area(),0.001);
    assertEquals(0.5*triangle2.area(),resizedTriangle2.area(),0.001);
  }

  /**
   * Tests the distanceFromOrigin method for all shapes
   */
  @Test
  public void testDistanceFromOrigin() {
    assertEquals(5.0,circle1.distanceFromOrigin(),0.001);
    assertEquals(14.613,circle2.distanceFromOrigin(),0.001);
    assertEquals(0.0,circle3.distanceFromOrigin(),0.001);
    assertEquals(7.810,rect1.distanceFromOrigin(),0.001);
    assertEquals(3.606,rect2.distanceFromOrigin(),0.001);
    assertEquals(0.0,triangle1.distanceFromOrigin(),0.001);
    assertEquals(1.414,triangle2.distanceFromOrigin(),0.001);
  }

  /**
   * Tests the compareTo method for all shapes
   */
  @Test
  public void testCompareTo() {
    // Test less than
    assertTrue(rect1.compareTo(circle1) < 0);
    assertTrue(triangle2.compareTo(triangle1) < 0);

    // Test equal to
    Shape smallCircle = new Circle(Math.sqrt(100/Math.PI));
    assertEquals(0, rect2.compareTo(smallCircle));

    // Test greater than
    assertTrue(circle1.compareTo(rect1) > 0);
    assertTrue(triangle1.compareTo(triangle2) > 0);
  }
}
