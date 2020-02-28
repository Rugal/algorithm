package ga.rugal.heap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author rugal
 */
public class ArrayBasedHeapTest {

  private final Heap<Integer> heap = new ArrayBasedHeap<>();

  @Before
  public void setUp() {
    this.heap.add(2);
    this.heap.add(4);
    this.heap.add(8);
  }

  @Test
  public void peek() {
    Assert.assertEquals(8, (int) this.heap.peek());
  }

  @Test
  public void add() {
    this.heap.add(1);
    Assert.assertEquals(8, (int) this.heap.peek());
    this.heap.add(9);
    Assert.assertEquals(9, (int) this.heap.peek());
  }

  @Test
  public void pop() {
    Assert.assertEquals(8, (int) this.heap.peek());
    this.heap.pop();
    Assert.assertEquals(4, (int) this.heap.peek());
  }

  @Test
  public void size() {
    Assert.assertEquals(3, this.heap.size());
  }

  @Test
  public void isEmpty() {
    Assert.assertFalse(this.heap.isEmpty());
    this.heap.pop();
    Assert.assertFalse(this.heap.isEmpty());
    this.heap.pop();
    Assert.assertFalse(this.heap.isEmpty());
    this.heap.pop();
    Assert.assertTrue(this.heap.isEmpty());
  }
}
