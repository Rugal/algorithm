package ga.rugal.heap;

import java.util.Comparator;

/**
 *
 * @author rugal
 * @param <T>
 */
public class ArrayBasedHeap<T extends Comparable> implements Heap<T> {

  private static final int DEFAULT_CAPACITY = 8;

  private final Comparator com;

  private Object[] array = new Object[DEFAULT_CAPACITY];

  private int size = 0;

  public ArrayBasedHeap() {
    this(null);
  }

  public ArrayBasedHeap(final Comparator com) {
    this.com = com;
  }

  private int left(final int n) {
    return 2 * n + 1;
  }

  private int right(final int n) {
    return 2 * n + 2;
  }

  private int parent(final int n) {
    return (n - 1) / 2;
  }

  private void swap(final int a, final int b) {
    final T temp = (T) this.array[a];
    this.array[a] = this.array[b];
    this.array[b] = temp;
  }

  private int compare(final int a, final int b) {
    final T left = (T) this.array[a];
    final T right = (T) this.array[b];
    if (null == left) {
      return -1;
    }
    if (null == right) {
      return 1;
    }
    return this.com == null
           ? left.compareTo(right)
           : this.com.compare(left, right);
  }

  private void bubbleUp() {
    for (int current = this.size - 1, p = this.parent(current);
         this.compare(current, p) > 0;
         current = p, p = this.parent(p)) {
      this.swap(p, current);
    }
  }

  private void bubbleDown() {
    for (int current = 0, l = this.left(current), r = this.right(current);
         this.compare(current, l) < 0 || this.compare(current, r) < 0;
         l = this.left(current), r = this.right(current)) {
      final int target = ((T) this.array[l]).compareTo((T) this.array[r]) > 0 ? l : r;
      this.swap(current, target);
      current = target;
    }
  }

  @Override
  public T peek() {
    if (this.isEmpty()) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return (T) this.array[0];
  }

  @Override
  public void add(final T d) {
    // extend
    if (this.size >= this.array.length) {
      final Object[] t = new Object[2 * this.size];
      System.arraycopy(this.array, 0, t, 0, this.size);
      this.array = t;
    }
    // add
    this.array[this.size++] = d;
    this.bubbleUp();
  }

  /**
   * Remove the max value from heap.
   *
   * @return
   */
  @Override
  public T pop() {
    if (this.isEmpty()) {
      throw new ArrayIndexOutOfBoundsException();
    }
    final T top = (T) this.array[0];
    this.array[0] = this.array[--this.size];
    this.bubbleDown();
    return top;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }
}
