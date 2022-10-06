package DebugExercise;

/**
 * Exercise for learning how the debug, breakpoint, and step-into feature work.
 */
public class DebugExercise1 {

  public static int divideThenRound(int top, int bottom) {
    float quotient = (float)top / (float) bottom;
//    int quotient = (int)top / (int) bottom; 整数除法丢掉所有小数
    int result = Math.round(quotient);
    return result;
  }

  public static void main(String[] args) {
    int t = 10;
    int b = 2;
    int result = divideThenRound(t, b);
    System.out.println("round(" + t + "/" + b + ")=" + result);

    int t2 = 9;
    int b2 = 4;
    //
    int result2 = divideThenRound(t2, b2);
    System.out.println("round(" + t2 + "/" + b2 + ")=" + result2);

    System.out.println(Math.round(0.5));
    System.out.println(Math.round(0.4));
    System.out.println(Math.round(-0.5));
    System.out.println(Math.round(-0.4));
    System.out.println(Math.round(-0.1));
    System.out.println(Math.round(-0.9));
    System.out.println("-1.1 :"+Math.round(-1.1));
    System.out.println("-1.4 :"+Math.round(-1.4));
    System.out.println("-1.5 :"+Math.round(-1.5));
    System.out.println("0.75 :"+Math.round(0.75));

    int t3 = 3;
    int b3 = 4;
    int result3 = divideThenRound(t3, b3);
    System.out.println("round(" + t3 + "/" + b3 + ")=" + result3);

  }
}
