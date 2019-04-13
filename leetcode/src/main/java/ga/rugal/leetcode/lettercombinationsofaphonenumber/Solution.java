package ga.rugal.leetcode.lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private static final String[] ARRAY = new String[]{
    "",
    "",
    "abc",
    "def",
    "ghi",
    "jkl",
    "mno",
    "pqrs",
    "tuv",
    "wxyz"};

  public List<String> letterCombinations(final String digits) {
    List<String> result = new ArrayList<>();
    if (digits.isEmpty()) {
      return result;
    }

    result.add("");
    for (int i = 0; i < digits.length(); i++) {
      final List<String> temp = new ArrayList<>();
      final String chars = ARRAY[digits.charAt(i) - '0'];

      //append one new character for every existing result
      for (int c = 0; c < chars.length(); c++) {
        for (int j = 0; j < result.size(); j++) {
          temp.add(result.get(j) + chars.charAt(c));
        }
      }
      result = temp;
    }
    return result;
  }
}
