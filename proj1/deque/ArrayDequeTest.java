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
  /** Adds a few things to the list, checking isEmpty() and size() are correct,
   * finally printing the results.
   *
   * && is the "and" operation. */
  public void addIsEmptySizeTest() {

    LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

    assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
    lld1.addFirst("front");
    assertFalse(lld1.isEmpty());
//    assertEquals("front", lld1.getFirst().item);

    // The && operator is the same as "and" in Python.
    // It's a binary operator that returns true if both arguments true, and false otherwise.
    assertEquals(1, lld1.size());
    assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

    lld1.addLast("middle");
    assertEquals(2, lld1.size());

    lld1.addLast("back");
    assertEquals(3, lld1.size());

    System.out.println("Printing out deque: ");
    lld1.printDeque();
    /**/
  }

  @Test
  /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
  public void addRemoveTest() {

    LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
    // should be empty
    assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

    lld1.addFirst(10);
    // should not be empty
    assertFalse("lld1 should contain 1 item", lld1.isEmpty());

    lld1.removeFirst();
    // should be empty
    assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    /**/
  }

  @Test
  /* Tests removing from an empty deque */
  public void removeEmptyTest() {

    LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
    lld1.addFirst(3);

    int a = lld1.removeLast();
    System.out.println(a);
    lld1.removeFirst();
    lld1.removeLast();
    lld1.removeFirst();

    int size = lld1.size();
    String errorMsg = "  Bad size returned when removing from empty deque.\n";
    errorMsg += "  student size() returned " + size + "\n";
    errorMsg += "  actual size() returned 0\n";

    assertEquals(errorMsg, 0, size);
    /**/
  }

  @Test
  public void removeSomeTest() {

    LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();

    for (int i = 0; i < 20; i++) {
      lld1.addFirst(i);
    }
    for (int i = 0; i < 20; i++) {
      System.out.print(lld1.removeLast() + " ");
    }
    System.out.println();
    for (int i = 0; i < 20; i++) {
      lld1.addFirst(i);
    }
    for (int i = 0; i < 20; i++) {
      System.out.print(lld1.removeFirst() + " ");
    }
    System.out.println(lld1.removeFirst());
    /**/
  }

  @Test
  public void getTest() {

    LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();

    for (int i = 0; i < 20; i++) {
      lld1.addLast(i);
    }
    System.out.println(lld1.get(5).item);
  }

  @Test
  /* Check if you can create LinkedListDeques with different parameterized types*/
  public void multipleParamTest() {

    LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
    LinkedListDeque<Double> lld2 = new LinkedListDeque<Double>();
    LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

    lld1.addFirst("string");
    lld2.addFirst(3.14159);
    lld3.addFirst(true);

    String s = lld1.removeFirst();
    double d = lld2.removeFirst();
    boolean b = lld3.removeFirst();
    lld1.equals(lld2);
    /* */
  }

  @Test
  /* check if null is return when removing from an empty LinkedListDeque. */
  public void emptyNullReturnTest() {

    LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

    boolean passed1 = false;
    boolean passed2 = false;
    assertEquals("Should return null when removeFirst is called on an empty LinkedListDeque,", null,
        lld1.removeFirst());
    assertEquals("Should return null when removeLast is called on an empty LinkedListDeque,", null,
        lld1.removeLast());

    /* */
  }

  @Test
  /* Add large number of elements to deque; check if order is correct. */
  public void bigLLDequeTest() {

    LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
    for (int i = 0; i < 1000000; i++) {//100w
      lld1.addLast(i);
    }

    for (double i = 0; i < 500000; i++) {
      assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
    }

    for (double i = 999999; i > 500000; i--) {
      assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
    }

    /* */
  }

  @Test
  public void iteratorTest() {

    LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
    for (int i = 0; i < 10; i++) {//100w
      lld1.addLast(i);
    }
    Iterator<Integer> it = lld1.iterator();
    while (it.hasNext()) {
      int i = it.next();
      System.out.print(i + " ");
    }

    for (Object i:lld1){
      System.out.println(i);
    }

    /* */
  }

  @Test
  public void ArrayListContainTest() {
    ArrayList<Integer> al=new ArrayList<>();
    al.add(5);
    al.add(7);
    al.add(12);
    System.out.println(al.contains(5));
    /* */
  }


}
