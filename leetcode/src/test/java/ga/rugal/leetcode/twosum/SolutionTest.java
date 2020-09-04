package ga.rugal.leetcode.twosum;

import ga.rugal.leetcode.twosum.Solution;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Rugal Bernstein
 */
@RunWith(Parameterized.class)
public class SolutionTest {

  private final Solution solution = new Solution();

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      {new int[]{1, 3, 5, 7}, 12, new int[]{2, 3}},
      {new int[]{3, 3}, 6, new int[]{0, 1}},
      {new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}},});
  }

  @Parameter(0)
  public int[] array;

  @Parameter(1)
  public int target;

  @Parameter(2)
  public int[] expected;

  @Test
  public void testTwoSum() {
    Assert.assertArrayEquals(this.expected, this.solution.twoSum(this.array, this.target));
  }
}
