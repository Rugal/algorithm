package ga.rugal.leetcode.kmp;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int[] buildNextTable(final String data) {
    final int[] result = new int[data.length()];
    for (int slow = 0, fast = 1; fast < data.length(); ++fast) {
      while (data.charAt(slow) != data.charAt(fast) && slow > 0) {
        slow = result[slow - 1];
      }

      if (data.charAt(slow) == data.charAt(fast)) {
        result[fast] = ++slow;
      }
    }
    return result;
  }
}
