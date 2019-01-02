package ga.rugal.leetcode.medianoftwosortedarrays;

import java.util.PriorityQueue;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    MedianArray array = new MedianArray();
    for (int i : nums1) {
      array.add(i);
    }
    for (int i : nums2) {
      array.add(i);
    }
    return array.getMedian();
  }

  public double test(int[] num1, int[] num2) {
    int m = num1.length;
    int n = num2.length;
    if (m > n) { // to ensure m<=n
      int[] temp = num1;
      num1 = num2;
      num2 = temp;
      int tmp = m;
      m = n;
      n = tmp;
    }
    int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
    while (iMin <= iMax) {
      int i = (iMin + iMax) / 2;
      int j = halfLen - i;
      if (i < iMax && num2[j - 1] > num1[i]) {
        iMin = i + 1; // i is too small
        continue;
      }
      if (i > iMin && num1[i - 1] > num2[j]) {
        iMax = i - 1; // i is too big
        continue;
      }  // i is perfect
      int maxLeft = 0;
      if (i == 0) {
        maxLeft = num2[j - 1];
      } else if (j == 0) {
        maxLeft = num1[i - 1];
      } else {
        maxLeft = Math.max(num1[i - 1], num2[j - 1]);
      }
      if ((m + n) % 2 == 1) {
        return maxLeft;
      }

      int minRight = 0;
      if (i == m) {
        minRight = num2[j];
      } else if (j == n) {
        minRight = num1[i];
      } else {
        minRight = Math.min(num2[j], num1[i]);
      }

      return (maxLeft + minRight) / 2.0;
    }
    return 0.0;
  }

  public static class MedianArray {

    //primary, low part
    private final PriorityQueue<Integer> desc = new PriorityQueue<>((a, b) -> b - a);

    //secondary, high part
    private final PriorityQueue<Integer> asc = new PriorityQueue<>((a, b) -> a - b);

    public void add(final Integer data) {
      if (this.desc.isEmpty()) {
        this.desc.add(data);
        return;
      }
      if (this.asc.isEmpty()) {
        if (data > this.desc.peek()) {
          this.asc.add(data);
          return;
        }
        this.asc.add(this.desc.poll());
        this.desc.add(data);
        return;
      }
      if (data > this.asc.peek()) {
        this.asc.add(data);
        if (this.desc.size() < this.asc.size()) {
          this.desc.add(this.asc.poll());
        }
        return;
      }
      this.desc.add(data);
      if (this.desc.size() > this.asc.size() + 1) {
        this.asc.add(this.desc.poll());
      }
    }

    public double getMedian() {
      if (this.size() % 2 == 1) {
        return this.desc.peek();
      }
      return (this.desc.peek() + this.asc.peek()) / 2.0;
    }

    public int size() {
      return this.desc.size() + this.asc.size();
    }
  }
}
