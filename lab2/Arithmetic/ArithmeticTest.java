package Arithmetic;

import static org.junit.Assert.*;

import org.junit.Test;

//junit:
// a kind of unit test:
//      对指定小,中,大的代码段进行运行和验证.保证中大型工程的运行稳定性
//      即没有运行整个工程就检查了其中的组件是否按照预期工作了.
public class ArithmeticTest {

  /**
   * Performs a few arbitrary tests to see if the product method is correct
   */
  @Test
  public void testProduct() {
        /* assertEquals for comparison of ints takes two arguments:
        assertEquals(expected, actual).
        if it is false, then the assertion will be false,
        and this test will fail.
        */

    assertEquals(30, Arithmetic.product(5, 6));
    assertEquals(-30, Arithmetic.product(5, -6));
    assertEquals(0, Arithmetic.product(0, -6));
  }

  /**
   * Performs a few arbitrary tests to see if the sum method is correct
   */
  @Test
  public void testSum() {

    assertEquals(11, Arithmetic.sum(5, 6));
    assertEquals(-1, Arithmetic.sum(5, -6));
    assertEquals(-6, Arithmetic.sum(0, -6));
    assertEquals(0, Arithmetic.sum(6, -6));
  }
}
