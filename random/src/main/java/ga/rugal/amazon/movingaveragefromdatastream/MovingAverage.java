package ga.rugal.amazon.movingaveragefromdatastream;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.lintcode.com/problem/642/
 */
public class MovingAverage {

  private final int size;

  private final Deque<Integer> queue;

  private double sum = 0;

  /*
   * @param size: An integer
   */
  public MovingAverage(final int size) {
    // do intialization if necessary
    this.size = size;
    this.queue = new LinkedList<>();
  }

  /*
   * @param val: An integer
   * @return:
   */
  public double next(final int val) {
    this.queue.add(val);
    this.sum += this.queue.getLast();
    if (this.queue.size() > this.size) {
      this.sum -= this.queue.poll();
    }
    return this.sum / this.queue.size();
  }
}