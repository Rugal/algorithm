package ga.rugal.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rugal Bernstein
 */
public class UniquePath2Test {

  private final int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

  private final UniquePath2 instance = new UniquePath2();

  @Before
  public void setUp() {
  }

  @Test
  public void uniquePathsWithObstacles() {
    Assert.assertEquals(2, this.instance.uniquePathsWithObstacles(this.obstacleGrid));
  }
}
