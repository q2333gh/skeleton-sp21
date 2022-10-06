package game2048.tests;

import game2048.Board;
import game2048.Model;
import org.junit.Test;

import static game2048.Model.atLeastOneMoveExists;
import static game2048.Model.printBoard;
import static org.junit.Assert.*;

/**
 * Tests the atLeastOneMoveExists() static method of Model.
 * <p>
 * You shouldn't expect to pass these tests until you're passing all the tests in TestEmptySpace.
 *
 * @author Omar Khan
 */
public class TestAtLeastOneMoveExists {

  /**
   * The Board that we'll be testing on.
   */
  static Board b;
  static Model m;


  @Test
  /** Tests a board with some empty space.
   *
   *  Note that this isn't a comprehensive test for empty space. For that,
   * see the TestEmptySpace class. */
  public void testEmptySpace() {
    int[][] rawVals = new int[][]{
        {0, 0, 4, 0},
        {0, 0, 0, 0},
        {0, 2, 0, 0},
        {0, 0, 0, 0},
    };

    b = new Board(rawVals, 0);
    assertTrue("A tilt in any direction will change the board "
            + "(there is empty space on the board)\n" + b,
        atLeastOneMoveExists(b));
  }

  @Test
  /** Tests a board where a tilt in any direction would cause a change. */
  public void testAnyDir() {
    int[][] rawVals = new int[][]{
        {2, 4, 2, 2},
        {4, 2, 4, 2},
        {2, 4, 2, 4},
        {4, 2, 4, 2},
    };

    b = new Board(rawVals, 0);
    assertTrue("A tilt in any direction will change the board\n"
            + b,
        atLeastOneMoveExists(b));
  }

  @Test
  /** Tests a board where a tilt left or right would cause a change. */
  public void testLeftOrRight() {
    int[][] rawVals = new int[][]{
        {2, 4, 2, 4},
        {4, 8, 4, 2},
        {2, 2, 2, 4},
        {4, 8, 4, 2},
    };

    b = new Board(rawVals, 0);
    assertTrue("A tilt left or right will change the board\n" + b,
        atLeastOneMoveExists(b));
  }

  @Test
  /** Tests a board where a tilt up or down would cause a change. */
  public void testUpOrDown() {
    int[][] rawVals = new int[][]{
        {2, 4, 2, 4},
        {4, 8, 4, 2},
        {2, 16, 4, 8},
        {4, 8, 4, 2},
    };

    b = new Board(rawVals, 0);
    assertTrue("A tilt up or down will change the board\n" + b,
        atLeastOneMoveExists(b));
  }

  @Test
  /** Tests a board where some move exists (max tile is on the board).
   *
   * While having the max tile on the board does mean the game is over, it
   * should not be handled in this method. */
  public void testMoveExistsMaxPiece() {
    int[][] rawVals = new int[][]{
        {2, 4, 2, 4},
        {4, 2, 4, 2},
        {2, 2, 2, 4},
        {4, 2, 4, 2048},
    };

    b = new Board(rawVals, 0);
    assertTrue("A tilt in any direction will change the board\n"
            + b,
        atLeastOneMoveExists(b));
  }

  @Test
  /** Tests a board where no move exists. */
  public void testNoMoveExists1() {
    int[][] rawVals = new int[][]{
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {1, 7, 2, 4},
        {8, 6, 4, 2},
    };
    b = new Board(rawVals, 0);
    Model m = new Model(rawVals, 0, 2048, false);
    m.printBoard(b);
    assertFalse("No move exists\n" + b,
        Model.atLeastOneMoveExists(b));
  }

  @Test
  /** Tests a board where no move exists. */
  public void testNoMoveExists2() {
    int[][] rawVals = new int[][]{
        {2, 1024, 2, 4},
        {4, 2, 4, 2},
        {2, 8, 16, 4},
        {512, 2, 4, 2},
    };
    b = new Board(rawVals, 0);

    assertFalse("No move exists\n" + b,
        atLeastOneMoveExists(b));
  }

  @Test
  /** Tests a board where no move exists. */
  public void testNoMoveExists3() {
    int[][] rawVals = new int[][]{
        {8, 4, 2, 32},
        {32, 2, 4, 2},
        {2, 8, 2, 4},
        {4, 64, 4, 64},
    };

    b = new Board(rawVals, 0);
    assertFalse("No move exists\n" + b,
        atLeastOneMoveExists(b));
  }

  @Test
  /** Tests a board where no move exists. */
  public void testNoMoveExists4() {
    int[][] rawVals = new int[][]{
        {2, 4, 2, 32},
        {32, 2, 4, 2},
        {2, 128, 2, 4},
        {4, 2, 4, 2},
    };

    b = new Board(rawVals, 0);
    assertFalse("No move exists\n" + b,
        atLeastOneMoveExists(b));
  }

  @Test
  /** Tests a board where no move exists. */
  public void testNoMoveExists5() {
    int[][] rawVals = new int[][]{
        {8, 16, 2, 32},
        {32, 2, 64, 2},
        {2, 256, 128, 256},
        {1024, 8, 4, 2},
    };

    b = new Board(rawVals, 0);
    assertFalse("No move exists\n" + b,
        atLeastOneMoveExists(b));
  }
}
