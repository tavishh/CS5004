public class LinkedListOfStrings implements ListOfStrings{
  private Node head;

  public LinkedListOfStrings(){


  }
  @Override
  public boolean isEmpty(){
    return head == null;
  }

  @Override
  public int size() {
    Node current = head;
    int count = 0;
    while (current != null){
      count++;
      current = current.getNextNode();
    }
    return count;
  }

  @Override
  public boolean contains(String str) {
    Node current = head;
    while (current != null){
      if (current.getValue().equals(str)){
        return true;
      }
      current = current.getNextNode();
    }
    return false;

  }

  @Override
  public boolean containsAll(ListOfStrings list) {
    LinkedListOfStrings other = (LinkedListOfStrings) list;
    Node current = other.head;

    while(current != null){
      if (!contains(current.getValue())){
        return false;
      }
      current = current.getNextNode();
    }
    return true;
  }

  public void add(String value){
    Node newNode = new Node(value, null);
    if (this.isEmpty()){
      head = newNode;
    } else{
      Node current = head;
      while (current.getNextNode() != null){
        current = current.getNextNode();
      }
      current.setNextNode(newNode);
    }

  }

  @Override
  public ListOfStrings filterLargerThan(int maxLength) {
    if (maxLength < 0) {
      throw new IllegalArgumentException("Max length cannot be negative!");
    }
    LinkedListOfStrings newList = new LinkedListOfStrings();
    Node current = head;
    while (current != null){
      if (current.getValue().length() <= maxLength){
        newList.add(current.getValue());
      }
      current = current.getNextNode();
    }
    return newList;
  }

  @Override
  public boolean hasDuplicates() {
    Node current = head;
    while(current != null){
      Node runner = current.getNextNode();
      while (runner != null) {
        if (current.getValue().equals(runner.getValue())) {
          return true;
        }
        runner = runner.getNextNode();
      }
      current = current.getNextNode();
    }
    return false;

  }

  @Override
  public ListOfStrings removeDuplicates() {
    LinkedListOfStrings newList = new LinkedListOfStrings();
    Node current = head;
    while (current != null) {
      if (!newList.contains(current.getValue())) {  // only add if not already in new list
        newList.add(current.getValue());
      }
      current = current.getNextNode();
    }
    return newList;

    }

  }

