package ga.rugal.amazon.shoppingoption;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/discuss/interview-question/1023609/amazon-oa-shopping-options
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private List<Integer> construct(final List<Integer> A,
                                  final List<Integer> B,
                                  final int target) {
    final List<Integer> list = new ArrayList<>();
    // convert n^4 into n^2
    for (int a : A) {
      for (int d : B) {
        final int s = a + d;
        if (s < target) {
          list.add(s);
        }
      }
    }

    list.sort((a, b) -> a - b);
    return list;
  }

  /**
   * Find the right most index that {@code list[index] <= target}<BR>
   * <ul>
   * <li>{@code all(val <= x for val in a[lo:i])} for the left side </li>
   * <li>{@code all(val > x for val in a[i:hi])} for the right side.</li>
   * </ul>
   *
   * @param list
   * @param target
   *
   * @return The returned insertion point i partitions the array a into two halves so that
   */
  private int binarySearch(final List< Integer> l, final int target) {
    int low = 0;
    int high = l.size() - 1;

    while (low <= high) {
      final int mid = (low + high) >>> 1;
      final int cmp = l.get(mid) - target;

      if (0 == cmp) {
        return mid; // key found
      }

      if (cmp < 0) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;  // key not found
  }

  public long getNumberOfOptions(final List<Integer> priceOfJeans,
                                 final List<Integer> priceOfShoes,
                                 final List<Integer> priceOfSkirts,
                                 final List<Integer> priceOfTops,
                                 final int dollars) {
    final var a = this.construct(priceOfJeans, priceOfShoes, dollars);
    final var b = this.construct(priceOfSkirts, priceOfTops, dollars);

    int result = 0;

    for (var value : a) {
      result += this.binarySearch(b, dollars - value);
    }
    return result;
  }
}
