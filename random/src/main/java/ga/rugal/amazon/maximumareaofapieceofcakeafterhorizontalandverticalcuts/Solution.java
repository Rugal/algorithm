package ga.rugal.amazon.maximumareaofapieceofcakeafterhorizontalandverticalcuts;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private long max(final int length, final int[] cuts) {
    Arrays.sort(cuts);
    // the initial cut
    int max = cuts[0];
    for (int i = 1; i < cuts.length; ++i) {
      max = Math.max(max, cuts[i] - cuts[i - 1]);
    }
    // compare the very last cut
    return Math.max(max, length - cuts[cuts.length - 1]);
  }

  public int maxArea(final int h,
                     final int w,
                     final int[] horizontalCuts,
                     final int[] verticalCuts) {
    // don't forget to modulo this special number as the result can be huge
    return (int) ((this.max(h, horizontalCuts) * this.max(w, verticalCuts)) % 1000000007);
  }
}
