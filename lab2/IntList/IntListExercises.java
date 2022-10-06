package IntList;

public class IntListExercises {

  /**
   * Part A: (Buggy) mutative method that adds a constant C to each element of an IntList
   *
   * @param list IntList from Lecture
   */
  public static void addConstant(IntList list, int c) {
    IntList p = list;
    while (p.rest != null) {
      p.first += c;
      p = p.rest;
    }
    p.first += c;
  }

  /**
   * Part B: Buggy method that sets node.
   * <p>
   * function: first to zero if the max value in the list starting at node has the same first and
   * last digit, for every node in L 1.找max 2.返回max的每个位 3.遍历表 4.各个节点和
   *
   * @param L IntList from Lecture
   */
  public static void setToZeroIfMaxFEL(IntList L) {
    IntList p = L;
    while (p != null) {
      if (firstDigitEqualsLastDigit(max(p))) {
        p.first = 0;
      }
      p = p.rest;
    }
  }

  /**
   * Returns the max value in the IntList starting at L.
   */
  public static int max(IntList L) {
    int max = L.first;
    IntList p = L.rest;
    while (p != null) {
      if (p.first > max) {
        max = p.first;
      }
      p = p.rest;
    }
    return max;
  }

  /**
   * Returns true if the last digit of x is equal to the first digit of x.
   */
  public static boolean firstDigitEqualsLastDigit(int x) {
    if (ifSingleDigit(x)) {
      return true;
    }
    String s = String.valueOf(x);//转int为字符串
    char digits[] = s.toCharArray();//转字符串为字符数组
    if (digits[0] == digits[digits.length - 1]) {
      return true;//对比首尾:即 d[0]和d[len-1]
    }
    return false;
  }

  public static boolean ifSingleDigit(int x) {
    return (x >= -9) && (x <= 9);
  }

  /**
   * Part C: (Buggy) mutative method that squares each prime element of the IntList.
   *
   * @param lst IntList from Lecture
   * @return True if there was an update to the list
   */
  public static boolean squarePrimes(IntList lst) {
    // Base Case: we have reached the end of the list
    int count=0;
    IntList p = lst;
    Primes primes=new Primes();
    while (p != null) {
      if ( Primes.isPrime(p.first)) {
        p.first=p.first* p.first;
        count++;
      }
      p=p.rest;
    }
    if (count>0){
      return true;
    }
    return  false;
  }
}
