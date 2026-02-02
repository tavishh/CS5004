import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

  Shape triangle1;

  @org.junit.jupiter.api.BeforeEach
  public void setUp() {
    triangle1 = new Triangle(1,1, 2,4,4,3);
    triangle1 = new Triangle(1,1, 2,4,4,3);
  }

  @org.junit.jupiter.api.Test
  public void testToString() {
  }

  @org.junit.jupiter.api.Test
  public void testDistanceFromOrigin() {
  }

  @org.junit.jupiter.api.Test
  public void testArea() {
    assertEquals(3.5,triangle1.area(),0.001);
  }

  @org.junit.jupiter.api.Test
  public void testPerimeter() {
  }

  @org.junit.jupiter.api.Test
  public void testResize() {
  }

  @org.junit.jupiter.api.Test
  public void testCompareTo() {
  }
}