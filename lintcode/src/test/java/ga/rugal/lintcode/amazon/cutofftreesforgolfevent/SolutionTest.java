package ga.rugal.lintcode.amazon.cutofftreesforgolfevent;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author rugalbernstein
 */
@RunWith(Parameterized.class)
public class SolutionTest {

  private final Solution solution = new Solution();

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      {Lists.newArrayList(Lists.newArrayList(1, 2, 3),
                          Lists.newArrayList(0, 0, 4),
                          Lists.newArrayList(7, 6, 5)),
       6},});
  }

  @Parameterized.Parameter(0)
  public List<List<Integer>> input;

  @Parameterized.Parameter(1)
  public int expected;

  @Test
  public void testCutOffTree() {
    Assert.assertEquals(this.expected, this.solution.cutOffTree(input));
  }
}
