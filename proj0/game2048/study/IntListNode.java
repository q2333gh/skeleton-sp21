package game2048.study;

/**
 * @author q2333
 * @date 2022/10/05 16:45
 **/
public class IntListNode {
  public int val;
  public IntListNode next;

  public IntListNode(int val, IntListNode next) {
    this.val = val;
    this.next = next;
  }

  public IntListNode() {
  }

  public IntListNode(int val) {
    this.val = val;
  }
}
