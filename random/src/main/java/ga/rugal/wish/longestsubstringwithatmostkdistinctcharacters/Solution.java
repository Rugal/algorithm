package ga.rugal.wish.longestsubstringwithatmostkdistinctcharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int longestSubString(final String input, final int k) {

    if (input.isEmpty() || k == 0) {

      return 0;

    }

    final Map<Character, Integer> map = new HashMap<>();

// initialization
    map.put(input.charAt(0), 1);

    int max = 1;

    for (int left = 0, right = 1; right < input.length();) {

// the current substring is invalid
      if (map.size() > k) {

        int l = map.get(input.charAt(left));

        if (--l > 0) {

          map.put(input.charAt(left), l);

        } else {

          map.remove(input.charAt(left));

        }

        ++left;

        continue;

      }

      final char current = input.charAt(right);

      final int count = map.getOrDefault(current, 0);

      map.put(current, count + 1);

// it is valid after adding one character
      if (map.size() <= k) {

        max = Math.max(max, right - left + 1);

        ++right;

        continue;

      }

      int l = map.get(input.charAt(left));

      if (--l > 0) {

        map.put(input.charAt(left), l);

      } else {

        map.remove(input.charAt(left));

      }

      ++left;

    }

    return max;

  }

  public static void main(String[] args) {

    final var s = new Solution();

    System.out.println(s.longestSubString("eceba", 2));

    System.out.println(s.longestSubString("aa", 1));

    System.out.println(s.longestSubString("aaaaaaa", 2));

    System.out.println(s.longestSubString("ecebaaaa", 2));

    System.out.println(s.longestSubString("deeccbbbba", 3));

  }
}
