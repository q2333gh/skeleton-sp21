package deque;


import java.util.Iterator;

/**
 * @author q2333
 * @date 2022/10/07 10:08
 **/
public class LinkedListDeque<T> implements Deque<T> {

  private final Node<T> headSentinel;//invariant
  private final Node<T> tailSentinel;//invariant
  private int size;

  public LinkedListDeque() {
    headSentinel = new Node<>();
    tailSentinel = new Node<>();
    headSentinel.succ = tailSentinel;
    tailSentinel.pred = headSentinel;
    size = 0;
  }


  private Node<T> getFirst() {
    return headSentinel.succ;
  }

  private Node<T> getLast() {
    return tailSentinel.pred;
  }

  @Override
  public void addFirst(T item) {
    Node<T> node = new Node<>(item);
    Node<T> oldFirst = getFirst();

    getFirst().pred = node;
    headSentinel.succ = node;

    node.succ = oldFirst;
    node.pred = headSentinel;
    size++;
  }

  @Override
  public void addLast(T item) {
    Node<T> node = new Node<>(item);
    Node<T> oldLast = getLast();

    tailSentinel.pred = node;
    oldLast.succ = node;

    node.succ = tailSentinel;
    node.pred = oldLast;
    size++;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void printDeque() {
    Node<T> p = getFirst();
    for (int i = 0; i < size; i++) {
      System.out.print(p.item + " ");
      p = p.succ;
    }
    System.out.println();
  }

  @Override
  public T removeFirst() {//确保没有指针指向oldFirst了,不行啊!返回值就要用它,错!
    //返回的是oldFirst.item!!!
    if (size == 0) {
      return null;
    }
    T item = getFirst().item;
    Node<T> workP = getFirst();
    Node<T> oldFist = getFirst();
    headSentinel.succ = workP.succ;
    workP.succ.pred = headSentinel;
    //上面只动了2个指针,.3个元素中间,一共是4个指针
    oldFist.succ = null;
    oldFist.pred = null;

    size--;
    return item;
  }

  @Override
  public T removeLast() {
    if (size == 0) {
      return null;
    }

    T item = getLast().item;
    Node<T> workP = getLast();
    Node<T> oldLast = getLast();

    tailSentinel.pred = workP.pred;
    workP.pred.succ = tailSentinel;
    oldLast.pred = null;
    oldLast.succ = null;

    size--;
    return item;
  }

  @Override
  public Node<T> get(int index) {
    //在读取T[index]的时候如何只读?
    Node<T> p = getFirst();
    for (int i = 0; i < index; i++) {
      p = p.succ;
    }
    return p;
  }


  /*
判断2个Deque实例是否内部item一一对应相等
 */
  @Override //重写(指定执行这个函数)
  public boolean equals(Object o) {
    return false;
  }

  public T getRecursive(int index) {
    if (index < 0 || index > size - 1) {
      return null;
    }
    return getRecursiveHelper(index, headSentinel.succ);
  }

  private T getRecursiveHelper(int index, Node<T> currentNode) {
    if (index == 0) {
      return currentNode.item;
    }
    return getRecursiveHelper(index - 1, currentNode.succ);
  }

  public Iterator<T> iterator() {
    return new LLD_Iterator();
  }

  /*
  LLD的嵌套类,实现迭代器(迭代实例)
   */
  private class LLD_Iterator implements Iterator<T> {

    private int p;
    private Node<T> cur;

    public LLD_Iterator() {
      cur = headSentinel.succ;
    }

    @Override
    public boolean hasNext() {
      return p < size;
    }

    /**
     * 输入:上层类实例的指针, 输出:节点的next 目前有问题.只能从头迭代 如果指定i位置迭代,指定失败
     */
    @Override
    public T next() {
      T returnItem = cur.item;
      cur = cur.succ;
      p++;
      return returnItem;
    }
  }
}


