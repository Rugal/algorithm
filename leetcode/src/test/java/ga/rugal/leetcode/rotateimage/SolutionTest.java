package ga.rugal.leetcode.rotateimage;

import ga.rugal.leetcode.rotateimage.Solution;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rugal Bernstein
 */
public class SolutionTest {

  private final Solution solution = new Solution();

  private int[][] matrix;

  private int[][] expected;

  @Before
  public void setUp() {
    this.matrix = new int[][]{
      new int[]{1, 2, 3, 4},
      new int[]{5, 6, 7, 8},
      new int[]{9, 10, 11, 12},
      new int[]{13, 14, 15, 16},};

    this.expected = new int[][]{
      new int[]{13, 9, 5, 1},
      new int[]{14, 10, 6, 2},
      new int[]{15, 11, 7, 3},
      new int[]{16, 12, 8, 4},};
  }

  @Test
  public void testRotate() {
    this.solution.rotate(this.matrix);
    for (int i = 0; i < this.matrix.length; ++i) {
      Assert.assertArrayEquals(this.expected[i], this.matrix[i]);
    }
  }

  @Test
  public void testSwapRight_0() {
    this.solution.swapRight(this.matrix, this.matrix.length, 0);
    Assert.assertArrayEquals(new int[]{4, 8, 12, 1}, this.matrix[0]);
  }

  @Test
  public void testSwapRight_1() {
    this.solution.swapRight(this.matrix, this.matrix.length - 2, 1);
    Assert.assertArrayEquals(new int[]{5, 7, 6, 8}, this.matrix[1]);
  }

  @Test
  public void testSwapDown_0() {
    this.solution.swapDown(this.matrix, this.matrix.length, 0);
    Assert.assertArrayEquals(new int[]{16, 15, 14, 4}, this.matrix[0]);
    Assert.assertArrayEquals(new int[]{13, 3, 2, 1}, this.matrix[matrix.length - 1]);
  }

  @Test
  public void testSwapDown_1() {
    this.solution.swapDown(this.matrix, this.matrix.length - 2, 1);
    Assert.assertArrayEquals(new int[]{5, 11, 7, 8}, this.matrix[1]);
    Assert.assertArrayEquals(new int[]{9, 10, 6, 12}, this.matrix[matrix.length - 2]);
  }

  @Test
  public void testSwapLeft_0() {
    this.solution.swapLeft(this.matrix, this.matrix.length, 0);
    Assert.assertArrayEquals(new int[]{13, 9, 5, 4}, this.matrix[0]);
  }

  @Test
  public void testSwapLeft_1() {
    this.solution.swapLeft(this.matrix, this.matrix.length - 2, 1);
    Assert.assertArrayEquals(new int[]{5, 10, 7, 8}, this.matrix[1]);
    Assert.assertArrayEquals(new int[]{9, 6, 11, 12}, this.matrix[matrix.length - 2]);
  }
}
