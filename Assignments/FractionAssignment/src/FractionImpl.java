public class FractionImpl implements Fraction {
  private int numerator;
  private int denominator;

  /**
   * Constructs a fraction with the given numerator and denominator
   * Signs are normalized so the denominator is always positive
   *
   * @param numerator the numerator of the fraction
   * @param denominator the denominator of the fraction
   * @throws IllegalArgumentException if denominator is less or equal to zero
   */

  public FractionImpl(int numerator, int denominator){
    if (denominator < 0) {
      numerator = -numerator;
      denominator = -denominator;
    }
    setNumerator(numerator);
    setDenominator(denominator);
  }


  @Override
  public int getDenominator(){
    return denominator;
  }

  @Override
  public int getNumerator(){
    return numerator;
  }

  @Override
  public void setDenominator(int denominator) {
    if (denominator <= 0){
      throw new IllegalArgumentException("Denominator should be a non-zero positive integer.");
    }
    this.denominator = denominator;
  }
  @Override
  public void setNumerator(int numerator){
    this.numerator = numerator;
  }

  @Override
  public double toDouble(){
    return (double) getNumerator()/getDenominator();
  }

  /**
   *  Returns a string representation of this fraction in simplest form.
   *
   *  @return the fraction in its simplest form a/b.
   **/

  @Override
  public String toString(){
    int divisor = gcd(Math.abs(numerator), denominator);
    return numerator/divisor +" / " + denominator/divisor;

  }

  /**
   *
   * @param a the first integer
   * @param b the second integer
   * @return the greatest common divisor of a and b
   */

  private static int gcd(int a, int b){
    if(b == 0){return a;}
    return gcd(b, a % b);
  }

  @Override
  public Fraction reciprocal(){
    if (numerator ==0) {throw new ArithmeticException("Cannot take the reciprocal of zero.");}
    return new FractionImpl(denominator, numerator);
  }

  @Override
  public Fraction add(Fraction other){
    // a/b + c/d = (a*d + b*c) / (b*d)
    int newNumerator = (this.getNumerator() * other.getDenominator()) + (other.getNumerator()*this.getDenominator());
    int newDenominator = (this.getDenominator() * other.getDenominator());
    return new FractionImpl(newNumerator, newDenominator);
  }

  @Override
  public int compareTo(Fraction other){
    long left = (long)this.getNumerator() * other.getDenominator();
    long right = (long)other.getNumerator() * this.getDenominator();
    return Long.compare(left,right);
  }

}
