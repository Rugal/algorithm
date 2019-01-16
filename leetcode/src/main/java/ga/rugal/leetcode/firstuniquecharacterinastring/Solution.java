package ga.rugal.leetcode.firstuniquecharacterinastring;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int firstUniqChar(String s) {
    int[] count = new int[26];
    for (int i = 0; i < s.length(); ++i) {
      count[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < s.length(); ++i) {
      final int key = s.charAt(i) - 'a';
      if (count[key] == 1) {
        return i;
      }
    }
    return -1;
  }
}
