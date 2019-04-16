package ga.rugal.leetcode.stringtointegeratoi;

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
      {"42", 42},
      {"-1", -1},
      {"-91283472332", -2147483648},
      {"4193 with words", 4193},
      {"words and 987", 0},
      {"+1", 1}});
  }

  @Parameterized.Parameter(0)
  public String input;

  @Parameterized.Parameter(1)
  public int target;

  @Test
  public void testMyAtoi() {
    Assert.assertEquals(this.target, this.solution.myAtoi2(this.input));
  }
}
