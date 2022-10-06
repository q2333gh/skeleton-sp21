package game2048.study;

/**
 * @author q2333
 * @date 2022/10/05 16:56
 **/
public class IntList {
  IntListNode node;

  public IntList(int[]a) {
    for (int i = 0; i < a.length; i++) {
      IntListNode n= new IntListNode(a[i]) ;
      n.next=new IntListNode(a[i+1]);
    }
  }

  public int size(){
    if (node.next==null){
      return 1;
    }
    return 1+size();
  }

}
