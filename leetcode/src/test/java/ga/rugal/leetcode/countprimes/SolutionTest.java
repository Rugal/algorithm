package ga.rugal.leetcode.countprimes;

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
      {10, 4},
      {2, 0},});
  }

  @Parameterized.Parameter(0)
  public int n;

  @Parameterized.Parameter(1)
  public int expected;

  @Test
  public void testCountPrimes() {
    Assert.assertEquals(this.expected, this.solution.countPrimes(n));
  }
}
