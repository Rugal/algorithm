package ga.rugal.leetcode.uniqueemailaddresses;

import ga.rugal.leetcode.uniqueemailaddresses.Solution;

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
      {new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}, 2},});
  }

  @Parameterized.Parameter(0)
  public String[] input;

  @Parameterized.Parameter(1)
  public int expected;

  @Test
  public void testNumUniqueEmails() {
    Assert.assertEquals(this.expected, this.solution.numUniqueEmails(this.input));
  }
}
