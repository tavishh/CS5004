/**
 * This class represents a Triangle. It offers all the operations mandated by the
 * Shape interface
 */
public class Triangle extends AbstractShape {
  private Point2D point1;
  private Point2D point2;
  private Point2D point3;

  /**
   * Construct a Triangle object given the three points (x1, y1), (x2, y2), (x3, y3)
   *
   * @param x1 x coordinate of first (reference) point of the triangle
   * @param y1 y coordinate of first (reference) point of the triangle
   * @param x2 x coordinate of second point of the triangle
   * @param y2 y coordinate of second point of the triangle
   * @param x3 x coordinate of third point of the triangle
   * @param y3 y coordinate of third point of the triangle
   */

  public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
    super (new Point2D(x1, y1)); //Reference point

    point1 = new Point2D(x1, y1);
    point2 = new Point2D(x2, y2);
    point3 = new Point2D(x3, y3);

    // Check for identical points
    if (point1.equals(point2) || (point1.equals(point3)) || (point3.equals(point2)) {
      throw new IllegalArgumentException("Triangles cannot have more than 2 identical points.");
    }
  }
  /*
    FIELDS:
    this.x1 : double;
    this.y1 : double;
    this.x2 : double;
    this.y2 : double;
    this.x3 : double;
    this.y3 : double;
   */
//  public String toString() {
//    return String.format("Triangle at coordinates a(%.3f), b(%.3f), and c(%.3f)",
//        point1, point2, point3);
//  }

  @Override
  public double distanceFromOrigin() {
    return 0;
  }

  @Override
  public double area() {
    double lengthA, lengthB, lengthC, s;
    lengthA = Math.sqrt((Math.pow((this.x2 - this.x1), 2) + Math.pow((this.y2 - this.y1), 2)));
    lengthB = Math.sqrt((Math.pow((this.x3 - this.x2), 2) + Math.pow((this.y3 - this.y2), 2)));
    lengthC = Math.sqrt((Math.pow((this.x1 - this.x3), 2) + Math.pow((this.y1 - this.y3), 2)));

    // Using Heron's formula, calculating the semi-perimeter s then returning the area
    s = (lengthA + lengthB + lengthC) / 2;
    return Math.sqrt(s * (s - lengthA) * (s - lengthB) * (s - lengthC));
  }

  @Override
  public double perimeter() {
    return 0;
  }

  @Override
  public Shape resize(double factor) {
    return null;
  }

  @Override
  public int compareTo(Shape s) {
    return 0;
  }
}