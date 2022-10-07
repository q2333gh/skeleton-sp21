package deque;

/**
 * @author q2333
 * @date 2022/10/07 10:08
 **/
public class Node<T> {

  public T item;
  public Node<T> pred;
  public Node<T> succ;


  public Node(T item) {
    this.item = item;
  }

  public Node() {
  }
}
