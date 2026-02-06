/**
 * This class represents a triangle. It defines all the operations mandated by
 * the Shape interface. A triangle is constructed using three points.
 */
public class Triangle extends AbstractShape {
  private Point2D point2;
  private Point2D point3;

  /**
   * Constructs a triangle object with the given three points.
   * The first point is considered the reference point.
   *
   * @param x1 x coordinate of the first point (reference point)
   * @param y1 y coordinate of the first point (reference point)
   * @param x2 x coordinate of the second point
   * @param y2 y coordinate of the second point
   * @param x3 x coordinate of the third point
   * @param y3 y coordinate of the third point
   * @throws IllegalArgumentException if two or three points are identical
   */
  public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
    super(new Point2D(x1, y1));
    this.point2 = new Point2D(x2, y2);
    this.point3 = new Point2D(x3, y3);

    // Validate that no two points are identical
    if (arePointsEqual(reference, point2)) {
      throw new IllegalArgumentException("Points 1 and 2 cannot be identical");
    }
    if (arePointsEqual(reference, point3)) {
      throw new IllegalArgumentException("Points 1 and 3 cannot be identical");
    }
    if (arePointsEqual(point2, point3)) {
      throw new IllegalArgumentException("Points 2 and 3 cannot be identical");
    }
  }

  /**
   * Helper method to check if two points are equal.
   *
   * @param p1 first point
   * @param p2 second point
   * @return true if points are equal, false otherwise
   */
  private boolean arePointsEqual(Point2D p1, Point2D p2) {
    return Math.abs(p1.getX() - p2.getX()) < 0.0001 &&
            Math.abs(p1.getY() - p2.getY()) < 0.0001;
  }

  @Override
  public String toString() {
    return String.format("Triangle: point1 (%.3f,%.3f) point2 (%.3f,%.3f) point3 (%.3f,%.3f)",
            reference.getX(), reference.getY(),
            point2.getX(), point2.getY(),
            point3.getX(), point3.getY());
  }

  @Override
  public double perimeter() {
    double side1 = reference.distanceTo(point2);
    double side2 = point2.distanceTo(point3);
    double side3 = point3.distanceTo(reference);
    return side1 + side2 + side3;
  }

  @Override
  public double area() {
    // Using Heron's formula: Area = sqrt(s(s-a)(s-b)(s-c))
    // where s is the semi-perimeter
    double side1 = reference.distanceTo(point2);
    double side2 = point2.distanceTo(point3);
    double side3 = point3.distanceTo(reference);

    double s = (side1 + side2 + side3) / 2.0;
    double areaSquared = s * (s - side1) * (s - side2) * (s - side3);

    // Handle collinear points (area would be 0 or very close to 0)
    if (areaSquared <= 0) {
      return 0.0;
    }

    return Math.sqrt(areaSquared);
  }

  @Override
  public Shape resize(double factor) {
    // To resize by a factor, we need to scale the triangle from its centroid
    // First, find the centroid
    double centroidX = (reference.getX() + point2.getX() + point3.getX()) / 3.0;
    double centroidY = (reference.getY() + point2.getY() + point3.getY()) / 3.0;

    // Scale factor for linear dimensions
    double scaleFactor = Math.sqrt(factor);

    // Calculate new points relative to centroid
    double newX1 = centroidX + scaleFactor * (reference.getX() - centroidX);
    double newY1 = centroidY + scaleFactor * (reference.getY() - centroidY);

    double newX2 = centroidX + scaleFactor * (point2.getX() - centroidX);
    double newY2 = centroidY + scaleFactor * (point2.getY() - centroidY);

    double newX3 = centroidX + scaleFactor * (point3.getX() - centroidX);
    double newY3 = centroidY + scaleFactor * (point3.getY() - centroidY);

    return new Triangle(newX1, newY1, newX2, newY2, newX3, newY3);
  }
}
