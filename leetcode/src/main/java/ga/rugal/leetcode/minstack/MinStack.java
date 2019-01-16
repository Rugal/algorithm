package ga.rugal.leetcode.minstack;

import java.util.Stack;

/**
 *
 * @author Rugal Bernstein
 */
public class MinStack {

  private final Stack<Long> diff = new Stack<>();

  private long minimum = 0;

  /**
   * initialize your data structure here.
   */
  public MinStack() {
  }

  public void push(int x) {
    if (this.diff.isEmpty()) {
      this.minimum = x;
      this.diff.push(0L);
      return;
    }
    this.diff.push(x - this.minimum);
    if (x < this.minimum) {
      this.minimum = x;
    }
  }

  public void pop() {
    if (this.diff.isEmpty()) {
      return;
    }
    final long top = this.diff.pop();
    if (top < 0) {
      this.minimum -= top;
    }
  }

  public int top() {
    final long top = this.diff.peek();
    return (int) (this.minimum + (top > 0 ? top : 0));
  }

  public int getMin() {
    return (int) this.minimum;
  }
}
