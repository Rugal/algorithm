package ga.rugal.leetcode.kthlargestelementinanarray;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SolutionTest {

  private final Solution solution = new Solution();

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      {new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 2, 5},
      {new int[]{3, 2, 1, 5, 6, 4}, 2, 5}
    });
  }

  @Parameterized.Parameter(0)
  public int[] input;

  @Parameterized.Parameter(1)
  public int k;

  @Parameterized.Parameter(2)
  public int expected;

  @Test
  public void testFindKthLargest() {
    Assert.assertEquals(this.expected, this.solution.findKthLargest(this.input, this.k));
  }
}
