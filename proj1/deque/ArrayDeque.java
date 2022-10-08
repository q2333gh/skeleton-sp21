package deque;

import java.util.Iterator;

/**
 * @author q2333
 * @date 2022/10/07 16:00
 **/
public class ArrayDeque<T> implements Deque<T> {

  //use Circular to impl ArrayDeque !
  //very good idea!
  private T[] container;
  private int size;
  private int capacity = 8;
  private final int startPos = 4;
  private int nextFirst;
  private int nextLast;
  //  private int shrinkBuffer=capacity/2;
  private int shrinkBuffer = 0;//测试用

  public ArrayDeque() {
    container = (T[]) new Object[capacity];
    nextFirst = startPos;
    nextLast = startPos + 1;
    size = 0;
  }

  private void CheckIfNeedRecapacity() {
    if (size == capacity) {
      expand();
    }
//    if (size == (capacity / 2)-shrinkBuffer) {
    if (size == (capacity / 2)) {//测试用
//      shrink();
    }
  }


  private void moveInsideContainer(int count, int from, int to) {
    for (int i = 0; i < count; i++) {
      container[to + i] = container[from + i];
      container[from + i] = null;//测试用
    }
  }

  private void expand() {
    //***如何改写nextfirst和nextlast指针?以及如何移动数据等等...
    int oldCapa = capacity;
    int copyStart = oldCapa / 2;//可以简写,但是这样逻辑更清晰.可能这就是为什么为了优化性能会难以读懂一些工业代码??
    capacity *= 2;
    T newContainer[] = (T[]) new Object[capacity];
    for (int i = 0; i < oldCapa; i++) {
      newContainer[copyStart + i] = container[i];
    }
    container = newContainer;    //GC回收无指向的原container
    if (nextLast > oldCapa / 2) {
      moveInsideContainer(oldCapa / 2, copyStart, copyStart + oldCapa);
      moveInsideContainer(nextLast - oldCapa / 2, copyStart + oldCapa / 2, 0);
      nextLast = nextLast - oldCapa / 2;
      nextFirst = nextFirst + oldCapa / 2;
    } else {
      moveInsideContainer(nextLast, copyStart, copyStart + oldCapa);
      nextLast = nextLast + (copyStart + oldCapa);
      nextFirst = nextFirst + oldCapa / 2;
    }
//    System.out.println("expand capa to " + capacity);
  }

  private void shrink() {
    int oldCapa = capacity;
    capacity /= 2;
    int copyStart = 0;//缩小的capa的起始处
    T newContainer[] = (T[]) new Object[capacity];
    for (int i = 0; i < size; i++) {
      newContainer[copyStart + i] = container[nextFirst];
    }
    container = newContainer;
    //GC回收无指向的原container
    System.out.println("shrink capa to " + capacity);
  }


  @Override
  public void addFirst(T item) {
    CheckIfNeedRecapacity();
    container[nextFirst] = item;
    firstGoLeft();
    size++;
  }

  @Override
  public void addLast(T item) {
    container[nextLast] = item;
    lastGoRight();
    size++;
    CheckIfNeedRecapacity();
  }

  @Override
  public T removeFirst() {//确保没有指针指向oldFirst了,不行啊!返回值就要用它
    // 错!返回的是指针解引用的那个东西
    //所以还是考虑是否要清除指针
    CheckIfNeedRecapacity();
    T item = container[nextFirst + 1];
    container[nextFirst + 1] = null;//测试用
    firstGoLeft();
    size--;
    return item;
    //是否可以写一个nextFirst的move函数,自动判断是否在边界??
  }

//  private void moveFirst() {
//    if (nextFirst == capacity) {
//      nextFirst = 0;
//    } else {
//      nextFirst++;
//    }
//  }

  @Override
  public T removeLast() {
    CheckIfNeedRecapacity();
    if (nextLast==0) {
      T item = container[capacity-1];
      container[nextLast - 1] = null;//测试用
      size--;
      return item;
    }
    else {
      T item = container[nextLast - 1];
      container[nextLast - 1] = null;//测试用
      size--;
      return item;
    }
  }

  private void lastGoLeft() {
    if (nextLast == capacity) {
      nextLast = 0;
    } else {
      nextLast--;
    }
  }

  private void lastGoRight() {

  }

  private void firstGoLeft() {
    if (nextFirst == 0) {
      nextFirst = capacity - 1;
    } else {
      nextFirst--;
    }
  }

  private void firstGoRight() {
    if (nextFirst == (capacity - 1)) {
      nextFirst = 0;
    } else {
      nextFirst++;
    }
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  @Override
  public void printDeque() {
    for (int i = 0; i < nextFirst; i++) {
//      System.out.print(container[]+" ");
    }
    System.out.println();
  }

  @Override
  public Node<T> get(int index) {
    //在读取T[index]的时候如何只读?
    return null;
  }

  @Override
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
