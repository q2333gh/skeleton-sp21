package IntList;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquarePrimesTest {

  /**
   * Here is a test for isPrime method. Try running it. It passes, but the starter code
   * implementation of isPrime is broken. Write your own JUnit Test to try to uncover the bug!
   *
   * 任务:
   * 自己写unit test 检测潜在bug
   */
  @Test
  public void testSquarePrimesSimple() {
    IntList lst = IntList.of(14, 15, 16, 17, 18);
    boolean changed = IntListExercises.squarePrimes(lst);
    assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
    assertTrue(changed);
  }
  @Test
  public void testSquarePrimesSimple2() {
    IntList lst = IntList.of(14, 15, 16, 17, 18);
    Primes p=new Primes();
    p.isPrime(5);
    for (int i = 10 ; i < 30; i++) {
      System.out.print(" "+i+"");
      if (p.isPrime(i)){
        System.out.print("-P");
      }
    }
  }
  @Test
  public void addFirstTest(){
    IntList list=new IntList();
    list.addFirst(0);
    list.addFirst(-1);
    list.addFirst(-2);
    IntList p=list;
    while (list.rest!=null){
      if (p==null){
        break;
      }
      System.out.println(p.first+" ");
      p=p.rest;
    }
  }

}
