package deque;


import java.util.Iterator;

/**
 * @author q2333
 * @date 2022/10/07 10:08
 **/
public class LinkedListDeque<T> {

  private Node<T> headSentinel;//invariant
  private Node<T> tailSentinel;//invariant
  private int size;

  public LinkedListDeque() {
    headSentinel = new Node<>();
    tailSentinel = new Node<>();
    headSentinel.succ = tailSentinel;
    tailSentinel.pred = headSentinel;
    size = 0;
  }

  public Node<T> getFirst() {
    return headSentinel.succ;
  }

  public Node<T> getLast() {
    return tailSentinel.pred;
  }


  public void addFirst(T item) {
    Node<T> node = new Node<T>(item);
    Node<T> oldFirst = getFirst();

    getFirst().pred = node;
    headSentinel.succ = node;

    node.succ = oldFirst;
    node.pred = headSentinel;
    size++;
  }

  public void addLast(T item) {
    Node<T> node = new Node<T>(item);
    Node<T> oldLast = getLast();

    tailSentinel.pred=node;
    oldLast.succ=node;

    node.succ=tailSentinel;
    node.pred=oldLast;

  }

  public int size() {
    return 0;
  }

  public boolean isEmpty() {
    if (size==0){
      return true;
    }
    return false;
  }

  public void printDeque() {

  }

  public T removeFirst() {
    return null;
  }

  public T removeLast() {
    return null;
  }

  public T get(int index) {
    //在读取T[index]的时候如何只读?
    return null;
  }

  public Iterator<T> iterator() {
    return null;
  }

  /*
判断2个Deque实例是否内部item一一对应相等
 */
  @Override //指定,重写
  public boolean equals(Object o) {
    return false;
  }

  public T getRecursive(int index) {
    return null;
  }

}
