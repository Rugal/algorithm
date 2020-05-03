package ga.rugal.leetcode.ransomnote;

/**
 * https://leetcode.com/problems/ransom-note/
 *
 * @author rugal
 */
public class Solution {

  public boolean canConstruct(final String ransomNote, final String magazine) {
    final int[] chars = new int[26];
    char[] a = magazine.toCharArray();
    for (int i = 0; i < a.length; ++i) {
      chars[a[i] - 'a']++;
    }

    char[] b = ransomNote.toCharArray();
    for (int i = 0; i < b.length; ++i) {
      if (chars[b[i] - 'a']-- <= 0) {
        return false;
      }
    }
    return true;
  }
}
