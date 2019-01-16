package ga.rugal.leetcode.minstack;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Rugal Bernstein
 */
public class MinStackTest {

  private final MinStack stack = new MinStack();

  @Test
  public void test_0() {
    this.stack.push(-1);
    Assert.assertEquals(-1, this.stack.top());
    Assert.assertEquals(-1, this.stack.getMin());
  }
}
