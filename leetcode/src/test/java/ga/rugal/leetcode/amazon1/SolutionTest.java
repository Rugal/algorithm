package ga.rugal.leetcode.amazon1;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
      {new int[]{1, 0, 0, 0, 0, 1, 0, 0}, 1, new int[]{0, 1, 0, 0, 1, 0, 1, 0}},
      {new int[]{1, 1, 1, 0, 1, 1, 1, 1}, 2, new int[]{0, 0, 0, 0, 0, 1, 1, 0}}});
  }

  @Parameterized.Parameter(0)
  public int[] states;

  @Parameterized.Parameter(1)
  public int day;

  @Parameterized.Parameter(2)
  public int[] expected;

  @Test
  public void testCellCompete() {
    final List<Integer> result = this.solution.cellCompete(this.states, this.day);
    for (int i = 0; i < expected.length; ++i) {
      Assert.assertTrue(this.expected[i] == result.get(i));
    }
  }
}
