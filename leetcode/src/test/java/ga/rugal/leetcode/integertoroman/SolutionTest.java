package ga.rugal.leetcode.integertoroman;

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
      {3, "III"},
      {4, "IV"},
      {9, "IX"},
      {58, "LVIII"},
      {1994, "MCMXCIV"}});
  }

  @Parameterized.Parameter(0)
  public int input;

  @Parameterized.Parameter(1)
  public String expected;

  @Test
  public void testIntToRoman() {
    Assert.assertEquals(this.expected, this.solution.intToRoman(input));
  }
}
