package ga.rugal.leetcode.validparentheses;

import ga.rugal.leetcode.validparentheses.Solution;

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
      {"()", true},
      {")(", false},
      {"([][]}{([()])}", false},
      {"{{()}}[]", true},});
  }

  @Parameterized.Parameter(0)
  public String input;

  @Parameterized.Parameter(1)
  public boolean expected;

  @Test
  public void testIsValid() {
    Assert.assertEquals(this.expected, this.solution.isValid(input));
  }
}
