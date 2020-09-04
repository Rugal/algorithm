package ga.rugal.reuters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author u6105440
 */
@RunWith(Parameterized.class)
public class Question5Test {

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      {List.of(0, 1, 5, 5, 1, 1, 2, 1, 8, 6), 7, 3},
      {List.of(0, 1, 5, 5, 45, 1, 2, 1, 2, 6), 7, -1},
      {List.of(5, 3, 1, 4, 9), 4, 1},
    });
  }

  @Parameterized.Parameter(0)
  public List<Integer> nums;

  @Parameterized.Parameter(1)
  public int target;

  @Parameterized.Parameter(2)
  public int expected;

  @Test
  public void consecutiveSumExists() {
    Assert.assertEquals(this.expected, Question5.ConsecutiveSumExists(this.nums, this.target));
  }
}
