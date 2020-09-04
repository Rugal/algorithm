package ga.rugal.leetcode.threesumclosest;

import ga.rugal.leetcode.threesumclosest.Solution;

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
      {new int[]{0, 1, 2}, 3, 3},
      {new int[]{1, 1, 1, 0}, -100, 2},
      {new int[]{0, 0, 0}, 1, 0},
      {new int[]{-1, 2, 1, -4}, 1, 2},});
  }

  @Parameterized.Parameter(0)
  public int[] array;

  @Parameterized.Parameter(1)
  public int target;

  @Parameterized.Parameter(2)
  public int expected;

  @Test
  public void testThreeSumClosest() {
    Assert.assertEquals(this.expected, this.solution.threeSumClosest(this.array, target));
  }
}
