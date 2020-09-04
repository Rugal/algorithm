package ga.rugal.leetcode.kmp;

import ga.rugal.leetcode.kmp.Solution;

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
      {"aabaabaaa", new int[]{0, 1, 0, 1, 2, 3, 4, 5, 2}},
      {"abcdabca", new int[]{0, 0, 0, 0, 1, 2, 3, 1}}
    });
  }

  @Parameterized.Parameter(0)
  public String s;

  @Parameterized.Parameter(1)
  public int[] expected;

  @Test
  public void testBuildNextTable() {
    Assert.assertArrayEquals(this.expected, this.solution.buildNextTable(this.s));
  }
}
