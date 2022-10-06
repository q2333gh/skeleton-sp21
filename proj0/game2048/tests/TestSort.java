package game2048.tests;


import org.junit.Test;

import static game2048.tests.SelectSort.findSmallestIndex;
import static game2048.tests.SelectSort.printArray;
import static game2048.tests.SelectSort.selectSort;
import static game2048.tests.SelectSort.swap;
import static org.junit.Assert.*;

/**
 * @author q2333
 * @date 2022/10/05 14:35
 **/
public class TestSort {



  @Test
  public void test1() {
    int[] a = {7, 2, 5, 6};
    assertEquals(1, findSmallestIndex(a, 0));

    int[] c = {7, 2, 1, 6};
    assertEquals(2, findSmallestIndex(c, 0));
    int[] d = {0, 2, 1, 6};
    assertEquals(0, findSmallestIndex(d, 0));

  }

  @Test
  public void test2() {
    int[] b = {7, 5, 3, 1};
    assertEquals(3, findSmallestIndex(b, 0));
  }

  @Test
  public void test3() {
    int[] e = {7, 2, 1, -1};
    assertEquals(3, findSmallestIndex(e, 0));
  }

  @Test
  public void testFrom() {
    int[] e = {0, 2, 1, 9};
    assertEquals(2, findSmallestIndex(e, 1));
  }

  @Test
  public void testFrom2() {
    int[] e = {0, 2, 1, 9, -1};
    assertEquals(4, findSmallestIndex(e, 1));
  }

  @Test
  public void testFrom3() {
    int[] e = {0, 2, 1, 9, -1};
    assertEquals(4, findSmallestIndex(e, 2));
  }

  @Test
  public void testFrom4() {
    int[] e = {0, 2, 1, 9, -1, 80, 0, 5};
    assertEquals(4, findSmallestIndex(e, 4));
  }


  @Test
  public void test4() {
    int[] e = {7, 2, 1, 9, 10, 50};
    int[] es = {50, 2, 1, 9, 10, 7};
    swap(e, 0, e.length - 1);
    assertEquals(e[0], es[0]);
    assertEquals(e[es.length - 1], es[es.length - 1]);
  }


  @Test
  public void testSO() {
    int[] a = {7, 2, 1, 9, 10, 50};
    selectSort(a);
   printArray(a);
  }

  @Test
  public void testSO1() {
    int[] a = {7, 2, 1, 9, 10, 50,-1,-5,23,63,76,0,0,0};
    selectSort(a);
    printArray(a);
  }

}
