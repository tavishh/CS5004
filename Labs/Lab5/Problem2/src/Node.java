public class Node {
  private String value;
  private Node nextNode;

  // Constructor
  public Node(String value, Node nextNode){
    this.value = value;
    this.nextNode = nextNode;
  }

  // Accessors
  public String getValue(){
    return value;
  }
  public Node getNextNode(){
    return nextNode;
  }

  // Mutator
  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
  }
}
