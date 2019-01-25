package ga.rugal.leetcode.partitionlabels;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-labels/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public List<Integer> partitionLabels(final String S) {
    final int[] array = new int[26];
    for (int i = 0; i < S.length(); ++i) {
      //last appearance of a character
      array[S.charAt(i) - 'a'] = i;
    }

    final List<Integer> result = new ArrayList<>();
    int length = 0, boundary = 0;
    for (int i = 0; i < S.length(); ++i) {
      //by far the highest boundary that should reach
      boundary = Math.max(boundary, array[S.charAt(i) - 'a']);
      length++;
      //if reaches the highest boundary
      //means all characters within thin boundary won't appear outside of this boundary
      if (boundary == i) {
        result.add(length);
        length = 0;
      }
    }
    return result;
  }
}
