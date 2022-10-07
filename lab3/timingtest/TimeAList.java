package timingtest;

import edu.princeton.cs.algs4.Stopwatch;
// The first column N gives the size of the data structure (how many elements it contains).
// The second column time (s) gives the time required to complete all operations.
// The third column # ops gives the number of calls to addLast made during the timing experiment.
// fourth column microsec/op gives the number of microseconds it took on average to complete each call to addLast.
// Note that for this experiment, N and # ops is redundant,
// since the result of making 128,000 calls to addLast will result in an N of 128,000.

/**
 * Created by hug.
 */
public class TimeAList {

  private static void printTimingTable(AList<Integer> Ns, AList<Double> times,
      AList<Integer> opCounts) {
    System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
    System.out.print("------------------------------------------------------------\n");
    for (int i = 0; i < Ns.size(); i += 1) {
      int N = Ns.get(i);
      double time = times.get(i);
      int opCount = opCounts.get(i);
      double timePerOp = time / opCount * 1e6;
      System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
    }
  }

  public static void main(String[] args) {
    timeAListConstruction();
  }

  public static void timeAListConstruction() {
    //(AList<Integer> Ns, AList<Double> times,AList<Integer> opCounts)
    AList<Integer> Ns = new AList<>();
    AList<Double> times = new AList<>();
    AList<Integer> opCounts = new AList<>();
    int startN = 1000;
    for (int i = 0; i < 7; i++) {
      AList<Integer> testAList = new AList<>();
      Stopwatch sw = new Stopwatch();//开始计时
      for (int j = 0; j < startN; j++) {
        testAList.addLast(10);
      }
      double et = sw.elapsedTime();//stop timing
      Ns.addLast(startN);
      times.addLast(et);
      opCounts.addLast(startN);
      startN = startN * 2;
    }
    printTimingTable(Ns, times, opCounts);
  }
}
