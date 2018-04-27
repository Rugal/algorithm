package ga.rugal.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rugal Bernstein
 */
public class MinPathSumTest {

  private final MinPathSum instance = new MinPathSum();

  private final int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

  @Before
  public void setUp() {
  }

  @Test
  public void minPathSum() {
    int expResult = 7;
    int result = this.instance.minPathSum(this.grid);
    Assert.assertEquals(expResult, result);
  }
}
