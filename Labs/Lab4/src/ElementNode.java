/**
 * This class represents the ElementNode in a list of books
 * It holds a Book and a reference to the rest of the list forming a recursive list
 */
public class ElementNode implements IListOfBooks{
  private Book book;
  private IListOfBooks rest;

  /**
   * Construct an ElementNode with a given book and rest of list
   * @param book
   * @param rest
   */

  public ElementNode(Book book, IListOfBooks rest){
    this.book = book;
    this.rest = rest;
  }

  /**
   *
   * @return Count of total number of books stored.
   */

  @Override
  public int count(){
    return 1 + this.rest.count();
  }

  /**
   *
   * @return Total Price of the books Stored.
   */

  @Override
  public float totalPrice(){
    return this.book.getPrice() + this.rest.totalPrice();
  }

  /**
   *
   * @param year the year before which all the returned books are published
   * @return All books that were published before the year year
   */

  @Override
  public IListOfBooks allBefore(int year){
    if (this.book.before(year)) {
      return new ElementNode(this.book, this.rest.allBefore(year));
    } else {
      return this.rest.allBefore(year);
    }
  }

  /**
   * Add the book at the end of the list  (empty node)
   * @param book an instance of Class Book
   * @return returns a new list with the given book added at the end
   */

  @Override
  public IListOfBooks addAtEnd(Book book){
    return new ElementNode(this.book, this.rest.addAtEnd(book));
  }

  /**
   *
   * @return list of books stored.
   */

  @Override
  public String toString(){
    String restString = this.rest.toString();
    if (restString.isEmpty()){
      return this.book.toString();
    }
    return this.book.toString() + "\n" + restString;
  }

}
