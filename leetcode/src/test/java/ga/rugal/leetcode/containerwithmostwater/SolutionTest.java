package ga.rugal.leetcode.containerwithmostwater;

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
      {new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49},});
  }

  @Parameterized.Parameter(0)
  public int[] input;

  @Parameterized.Parameter(1)
  public int expected;

  @Test
  public void testMaxArea() {
    Assert.assertEquals(this.expected, this.solution.maxArea(this.input));
  }
}
