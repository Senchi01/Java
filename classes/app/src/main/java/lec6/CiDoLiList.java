package lec6;

public class CiDoLiList {
	public static class Node {
    private Node next;
    private Node prev;
    private String text;

    public Node (String text) {
      this.text = text;
      this.next = this;
      this.prev = this;
    }
    public Node (String text, Node prev, Node next) {
      this.text = text;
      this.next = next;
      this.prev = prev;
      next.prev = this;
      prev.next = this;
    }
    public String getText() {
      return text;
    }
    public Node getNext() {
      return next;
    }
    public Node getPrev() {
      return prev;
    }
  }

  public Node head;

  public void insertFirst(String text) {
    if (head == null) {
      head = new Node(text);
    } else {
      head = new Node(text, head, head.getPrev());
    }
  }

  public void insertLast(String text) {
    if (head == null) {
      head = new Node(text);
    } else {
      new Node(text, head, head.getPrev());
    }
  }

  public void print() {
    Node currentNode = head;
    if (currentNode != null) {
      StringBuilder sb = new StringBuilder();
      do {
        sb.append(currentNode.getNext());
        sb.append(" ");
        currentNode = currentNode.getNext();
    } while (currentNode != head);
      System.out.println(sb);

  }
  }
  public static void main(String[] args) {
    CiDoLiList list = new CiDoLiList();

    list.insertFirst("alla");
    list.insertFirst("Akbar");
    list.insertFirst("la");
    list.insertLast("ilah");
    list.insertLast("ila");
    list.insertLast("alla");

    list.print();
    
  }
}
