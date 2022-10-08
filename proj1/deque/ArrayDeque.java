package deque;

import java.util.Iterator;

/**
 * @author q2333
 * @date 2022/10/07 16:00
 **/
public class ArrayDeque<T> {

  private T[] container;
  private int size;
  private int capacity = 8;
  private int first;
  private int last;



  public ArrayDeque(T item) {
    container = (T[]) new Object[capacity];
    container[0] = item;
    first =0;
    last =capacity;
    size = 1;
  }


  private void CheckIfNeedRecapacity() {
    if (size == capacity) {
      expand();
    }
    if (size < capacity / 2) {
      shrink();
    }
  }

  private void expand() {
    capacity *= 2;
    T newContainer[] = (T[]) new Object[capacity];
    for (int i = 0; i < size; i++) {
      newContainer[i] = container[i];
    }
    container = newContainer;
    //GC回收无指向的原container
    System.out.println("expand capa to " + capacity);
  }

  private void shrink() {
    if (capacity == 8) {
      return;
    }
    capacity /= 2;
    T newContainer[] = (T[]) new Object[capacity];
    for (int i = 0; i < size; i++) {
      newContainer[i] = container[i];
    }
    container = newContainer;
    //GC回收无指向的原container
    System.out.println("shrink capa to " + capacity);
  }

  private T getFirst() {

    return container[first] ;

  }

  private T getLast() {
    return container[last] ;
  }


  public void addFirst(T item) {
    CheckIfNeedRecapacity();
    container[first+1]=item;
    first++;
    size++;
  }

  public void addLast(T item) {
    CheckIfNeedRecapacity();
    container[last-1]=item;
    last--;
    size++;
  }

  public T removeFirst() {//确保没有指针指向oldFirst了,不行啊!返回值就要用它,错!
    CheckIfNeedRecapacity();
    first--;
    size--;
    return container[first];
  }

  public T removeLast() {
    CheckIfNeedRecapacity();
    last++;
    size--;
    return container[last];
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  public void printDeque() {
    for (int i = 0; i < first; i++) {
//      System.out.print(container[]+" ");
    }
    System.out.println();
  }


  public Node<T> get(int index) {
    //在读取T[index]的时候如何只读?
    return null;
  }

  public Iterator<T> iterator() {
    return null;
  }

  /*
判断2个Deque实例是否内部item一一对应相等
 */
  @Override //重写(指定执行这个函数)
  public boolean equals(Object o) {
    return false;
  }


}
