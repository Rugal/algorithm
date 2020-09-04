package ga.rugal.leetcode.longestsubstringwithoutrepeatingcharacters;

import ga.rugal.leetcode.longestsubstringwithoutrepeatingcharacters.Solution;

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
      {"abba", 2},
      {"dvdf", 3},
      {"", 0},
      {"bbbbb", 1},
      {"pwwkew", 3}
    });
  }

  @Parameterized.Parameter(0)
  public String s;

  @Parameterized.Parameter(1)
  public int expected;

  @Test
  public void testLengthOfLongestSubstring() {
    Assert.assertEquals(this.expected, this.solution.lengthOfLongestSubstring(this.s));
  }
}
