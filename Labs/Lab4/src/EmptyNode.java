/**
 * This class represents the Empty Node in a list of books
 * It is the base case for the recursive list
 */
public class EmptyNode implements IListOfBooks {

  @Override
  public int count(){
    return 0;
  }

  @Override
  public float totalPrice(){
    return 0;
  }

  @Override
  public IListOfBooks allBefore(int year){
    return new EmptyNode();
  }

  @Override
  public IListOfBooks addAtEnd(Book book){
    return new ElementNode(book, new EmptyNode());
  }

  @Override
  public String toString(){
    return "";
  }

}
