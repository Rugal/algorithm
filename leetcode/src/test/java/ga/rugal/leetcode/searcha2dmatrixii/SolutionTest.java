package ga.rugal.leetcode.searcha2dmatrixii;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Rugal Bernstein
 */
@RunWith(Parameterized.class)
public class SolutionTest {

  private final Solution solution = new Solution();

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      {new int[][]{new int[]{1, 4, 7, 11, 15},
                   new int[]{2, 5, 8, 12, 19},
                   new int[]{3, 6, 9, 16, 22},
                   new int[]{10, 13, 14, 17, 24},
                   new int[]{18, 21, 23, 26, 30}}, 5, true},
      {new int[][]{new int[]{1, 2, 3, 4, 5},
                   new int[]{6, 7, 8, 9, 10},
                   new int[]{11, 12, 13, 14, 15},
                   new int[]{16, 17, 18, 19, 20},
                   new int[]{21, 22, 23, 24, 25}}, 25, true},});
  }

  @Parameterized.Parameter(0)
  public int[][] input;

  @Parameterized.Parameter(1)
  public int target;

  @Parameterized.Parameter(2)
  public boolean expected;

  @Test
  public void testSearchMatrix() {
    Assert.assertEquals(this.expected, this.solution.searchMatrix(this.input, this.target));
  }
}
