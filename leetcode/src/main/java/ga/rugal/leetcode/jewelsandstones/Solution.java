package ga.rugal.leetcode.jewelsandstones;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int numJewelsInStones(String J, String S) {
    Set<Character> set = new HashSet();
    for (char j : J.toCharArray()) {
      set.add(j);
    }

    int ans = 0;
    for (char s : S.toCharArray()) {
      if (set.contains(s)) {
        ans++;
      }
    }
    return ans;
  }
}
