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
  
      private boolean match(String str, String target) {
        if (str.length() < target.length()) {
            return false;
        }
        int[] pi = this.buildNextTable(target);
        int p = -1;
        for (int i = 0; i < str.length(); i++) {
            while (p > -1 && str.charAt(i) != target.charAt(p + 1)) {
                p = pi[p];
            }
            if (target.charAt(p + 1) == str.charAt(i)) {
                p++;
            }
            if (p == target.length() - 1) {
                return true;
            }
        }
        return false;
    }
}
