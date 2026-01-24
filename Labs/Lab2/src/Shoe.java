/**
 * Represents a shoe with it's kind, color, brand and size
 */
public class Shoe {
  private Kind kind;
  private Color color;
  private Brand brand;
  private double size;

  /**
   * Constructor for new Shoe with specified attributes
   *
   * @param kind the type of shoe available. (e.g Sneaker, Dress)
   * @param color the colors the shoe is available in. (e.g Red, Black)
   * @param brand the brand of shoe available. (e.g Nike, Adidas)
   * @param size the size of the shoes available.
   * @throws IllegalArgumentException if Brand is Nike and kind is Dress
   *                                  Since Nike does not sell Dress Shoes
   */

  public Shoe(Kind kind, Color color, Brand brand, double size){
    if (brand == Brand.NIKE && kind == Kind.DRESS){
      throw new IllegalArgumentException("Nike does not sell dress shoes.");
    }
    this.kind = kind;
    this.color = color;
    this.brand = brand;
    this.size = size;
  }

  /**
   * Return the kind of shoe
   *
   * @return the Kind enum value representing the shoe's style
   */
  public Kind getKind(){
    return this.kind;
  }

  /**
   * Return the color of the shoe
   *
   * @return the Color enum value representing the shoe's color
   */
  public Color getColor(){
    return this.color;
  }

  /**
   * Return the Brand of the shoe
   *
   * @return the Brand enum value representing the shoe's brand
   */
  public Brand getBrand(){
    return this.brand;
  }

  /**
   * Return the size of the shoe
   *
   * @return the Size enum value representing the shoe size
   */
  public double getSize(){
    return this.size;
  }

  /**
   * Returns the string representation of this shoe incl all four attributes
   *
   * @return a formatted String summarizing the shoe's attributes
   */
  @Override
  public String toString(){
    String kindStr;
    switch (kind){
      case SNEAKER:
        kindStr = "Sneaker";
        break;
      case DRESS:
        kindStr = "Dress";
        break;
      case SANDAL:
        kindStr = "Sandal";
        break;
      case SLIPPER:
        kindStr = "Slipper";
        break;
      default:
        kindStr = "Unknown Style";
        break;
    }
    String colorStr;
    switch (color){
      case WHITE:
        colorStr = "White";
        break;
      case RED:
        colorStr = "Red";
        break;
      case BLACK:
        colorStr = "Black";
        break;
      case BLUE:
        colorStr = "Blue";
        break;
      default:
        colorStr = "Neutral";
        break;
    }

    String brandStr;
    switch (brand){
      case NIKE:
        brandStr = "Nike";
        break;
      case ADIDAS:
        brandStr = "Adidas";
        break;
      case TIMBERLAND:
        brandStr = "Timberland";
        break;
      case CLARKS:
        brandStr = "Clarks";
        break;
      default:
        brandStr = "Unknown Brand";
        break;
    }

    return brandStr + " " + colorStr + " " + kindStr + " " + ", Size: " + size;

  }

}
