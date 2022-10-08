package deque;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Performs some basic linked list tests.
 */
public class ArrayDequeTest {

  @Test

  public void testAddLast() {
    ArrayDeque<Integer> ad=new ArrayDeque<>();
    ad.addLast(5);
    ad.addLast(6);
    ad.addLast(7);
    ad.addLast(0);
    ad.addLast(1);
    ad.addLast(2);
    ad.addLast(3);
    ad.addLast(4);
  }


  @Test
  public void testCopy() {
    ArrayDeque<Integer> ad=new ArrayDeque<>();
    ad.addLast(5);
    ad.addLast(6);
    ad.addLast(7);
    ad.addLast(0);
    ad.addLast(1);
    ad.addLast(2);
    ad.addLast(3);
    ad.addLast(4);
//    ad.expand();
    System.out.println();

  }

  @Test
  public void testMove() {
    ArrayDeque<Integer> ad=new ArrayDeque<>();
    ad.addLast(5);
    ad.addLast(6);
    ad.addLast(7);
    ad.addLast(0);
    ad.addLast(1);
    ad.addLast(2);
    ad.addLast(3);
    ad.addLast(4);
//    ad.expand();
    System.out.println();

  }
  @Test
  public void testExpand() {
    ArrayDeque<Integer> ad=new ArrayDeque<>();

    for (int i = 0; i < 17; i++) {
      ad.addLast(i);
    }
    for (int i = 0; i < 10; i++) {
      ad.addFirst(i+100);
    }
//    ad.expand();
    System.out.println();

  }


}
