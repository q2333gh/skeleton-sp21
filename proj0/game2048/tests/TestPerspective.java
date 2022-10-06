package game2048.tests;

import game2048.Board;
import game2048.Model;
import game2048.Side;
import org.junit.Test;

import static game2048.Model.atLeastOneMoveExists;
import static game2048.Model.oneRowMovExists;
import static game2048.Model.printBoard;
import static org.junit.Assert.*;

/**
 * Tests the atLeastOneMoveExists() static method of Model.
 * <p>
 * You shouldn't expect to pass these tests until you're passing all the tests in TestEmptySpace.
 *
 * @author Omar Khan
 */
public class TestPerspective {

  static Board b;

  @Test
  public void testP1() {
    int[][] rawVals = new int[][]{
        {0, 1, 2, 3},
        {5, 6, 7, 8},
        {1, 7, 2, 4},
        {8, 6, 4, 2},
    };
    b = new Board(rawVals, 0);
    Model m = new Model(rawVals, 0, 2048, false);
    b.setViewingPerspective(Side.NORTH);
    Model.printBoard(b);
  }

  @Test
  public void testP2() {
    int[][] rawVals = new int[][]{
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {1, 7, 2, 4},
        {8, 6, 4, 2},
    };

    b = new Board(rawVals, 0);
    Model m = new Model(rawVals, 0, 2048, false);
    b.setViewingPerspective(Side.WEST);
    Model.printBoard(b);
  }

  @Test
  public void test3() {
    int[][] a = new int[][]{
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16},
    };
    for (int row = 0; row < 4; row++) {
      for (int col = 0; col < 4; col++) {
        System.out.print(a[row][col] + "  ");
      }
      System.out.println();
    }
  }

  @Test
  public void test4() {
    int[][] a = new int[][]{
        {1, 2, 2, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16},
    };
    Model m = new Model(0);
    Board b = new Board(a, 1);
    b.setViewingPerspective(Side.EAST);
    Model.printBoard(b);
    assertTrue(oneRowMovExists(b, 0));
  }

  @Test
  public void t2() {
    int[] tmp = {1, 2, 3, 4};
    for (int i = 0; i < tmp.length - 1; i++) {
      System.out.println(tmp[i] + " " + tmp[i + 1]);
    }
  }
}

  /* old scan algo
    //scan right
    int row = 0;
    int col = 0;

    for (int i = 0; i < b.size(); i++) {
      for (int j = 0; j < b.size() - 1; j++) {
        Tile t1 = b.tile(col, row);
        Tile t2 = b.tile(col, ++row);
        if (t1.value() == t2.value()) {
          return true;
        }
        //iterate: like 2 pointer,滑动窗口
        t1 = t2;
        t2 = b.tile(col, t2.row() + 1);
      }
      col++;
    }
    //scan down
    col = 0;
    row = 0;
    for (int i = 0; i < b.size(); i++) {
      for (int j = 0; j < b.size() - 1; j++) {
        Tile t1 = b.tile(col, row);
        Tile t2 = b.tile(++col, row);
        if (t1.value() == t2.value()) {
          return true;
        }
        //iterate: like 2 pointer,滑动窗口
        t1 = t2;
        t2 = b.tile(t2.col() + 1, row);
      }
      row++;
    }

   */




