package ga.rugal.leetcode.numberofislands;

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
      {new char[][]{
        new char[]{'1', '1', '1', '1', '0'},
        new char[]{'1', '1', '0', '1', '0'},
        new char[]{'1', '1', '0', '0', '0'},
        new char[]{'0', '0', '0', '0', '0'},}, 1},
      {new char[][]{
        new char[]{'1', '1', '0', '0', '0'},
        new char[]{'1', '1', '0', '0', '0'},
        new char[]{'0', '0', '1', '0', '0'},
        new char[]{'0', '0', '0', '1', '1'},}, 3}
    });
  }

  @Parameterized.Parameter(0)
  public char[][] input;

  @Parameterized.Parameter(1)
  public int expected;

  @Test
  public void testNumIslands() {
    Assert.assertEquals(this.expected, this.solution.numIslands(this.input));
  }
}
