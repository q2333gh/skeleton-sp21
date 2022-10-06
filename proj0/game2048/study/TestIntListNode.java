package game2048.study;

/**
 * @author q2333
 * @date 2022/10/05 16:46
 **/

import org.junit.Test;

public class TestIntListNode {

  @Test
  public void test1() {
    IntListNode n1 = new IntListNode();
    IntListNode n2 = new IntListNode();
    IntListNode n3 = new IntListNode();
    n1.val = 5;
    n1.next = n2;
    n2.val = 10;
    n2.next = n3;
    n3.val = 15;
    IntListNode n4 = new IntListNode();
  }
}
