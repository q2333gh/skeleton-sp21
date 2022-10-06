package IntList;

import static org.junit.Assert.*;

import org.junit.Test;

public class SetToZeroIfMaxFELTest {

  @Test
  public void testZeroOutFELMaxes1() {
    IntList L = IntList.of(1, 22, 15);
    IntListExercises.setToZeroIfMaxFEL(L);
    assertEquals("0 -> 0 -> 15", L.toString());
  }

  @Test
  public void testZeroOutFELMaxes2() {
    IntList L = IntList.of(55, 22, 45, 44, 5);
    IntListExercises.setToZeroIfMaxFEL(L);
    assertEquals("0 -> 22 -> 45 -> 0 -> 0", L.toString());
  }

  @Test
  public void testZeroOutFELMaxes3() {
    IntList L = IntList.of(5, 535, 35, 11, 10, 0);
    IntListExercises.setToZeroIfMaxFEL(L);
    assertEquals("0 -> 0 -> 35 -> 0 -> 10 -> 0", L.toString());
  }

  @Test
  public void testSingleDigit() {
    IntList L = IntList.of(5, 535, 35, 11, 10, 0);
    IntListExercises.setToZeroIfMaxFEL(L);
    System.out.println(IntListExercises.ifSingleDigit(10));
    System.out.println(IntListExercises.ifSingleDigit(-10));
    System.out.println(IntListExercises.ifSingleDigit(9));
    System.out.println(IntListExercises.ifSingleDigit(-9));
    System.out.println(IntListExercises.ifSingleDigit(5));
    System.out.println(IntListExercises.ifSingleDigit(-1));



  }
  @Test
  public void testTen() {
    IntList L = IntList.of(5, 535, 35, 11, 10, 0);
    boolean b= IntListExercises.firstDigitEqualsLastDigit(10);
    System.out.println(b);
    char[] charArray2=new char[3];
    charArray2[2]='c';
    System.out.println(charArray2[2]);





  }



}
