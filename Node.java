public class Node {
  private String data;
  private Node next,prev;

  public Node(String value) {
    data = value;
  }

  public void setNext(Node x) {
    next = x;
  }

  public Node getNext() {
    return next;
  }

  public void setPrev(Node x) {
    prev = x;
  }

  public void getPrev() {
    return prev;
  }

}
