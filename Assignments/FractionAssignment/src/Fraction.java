/**
 * Represents a fraction with an integer numerator and a positive integer denominator.
 */
public interface Fraction extends Comparable<Fraction> {

  /**
   * Gets the numerator of this fraction
   *
   * @return the numerator
   */
  int getNumerator();

  /**
   * Sets the numerator of this fraction
   *
   * @param numerator the new numerator value
   */
  void setNumerator(int numerator);

  /**
   * Gets the denominator of this fraction
   *
   * @return the denominator
   */
  int getDenominator();

  /**
   * Sets the denominator of this fraction
   *
   * @param denominator the new denominator value
   * @throws IllegalArgumentException if denominator is less than or equal to zero
   */
  void setDenominator(int denominator);

  /**
   * Converts this fraction to its decimal value
   *
   * @return the decimal representation of this fraction
   */
  double toDouble();

  /**
   * Returns the reciprocal of this fraction
   *
   * @return a new Fraction representing the reciprocal
   * @throws ArithmeticException if the numerator is zero
   */
  Fraction reciprocal();

  /**
   * Adds this fraction to the given fraction
   *
   * @param other the fraction to add
   * @return a new Fraction representing the sum in simplest form
   */
  Fraction add(Fraction other);

  /**
   * Compares this fraction to another fraction
   *
   * @param other the fraction to compare to
   * @return a negative integer, zero, or positive integer as this fraction
   *         is less than, equal to, or greater than the other
   */
  int compareTo(Fraction other);
}