package ga.rugal.leetcode.graycode;

import ga.rugal.leetcode.graycode.Solution;

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
      {2, new int[]{0, 1, 3, 2}},});
  }

  @Parameterized.Parameter(0)
  public int input;

  @Parameterized.Parameter(1)
  public int[] expected;

  @Test
  public void testGrayCode() {
    final int[] toArray = this.solution.grayCode(this.input).stream()
      .mapToInt(i -> i)
      .toArray();
    Assert.assertArrayEquals(this.expected, toArray);
  }
}
