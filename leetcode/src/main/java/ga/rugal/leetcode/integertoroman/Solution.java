package ga.rugal.leetcode.integertoroman;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private static final int[] ARRAY = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

  public String intToRoman(int num) {
    final StringBuilder sb = new StringBuilder();
    while (num != 0) {
      for (int i : ARRAY) {
        if (num / i > 0) {
          sb.append(this.getChar(i));
          num -= i;
          break;
        }
      }
    }

    return sb.toString();
  }

  private String getChar(int c) {
    switch (c) {
      case 1:
        return "I";
      case 4:
        return "IV";
      case 5:
        return "V";
      case 9:
        return "IX";
      case 10:
        return "X";
      case 40:
        return "XL";
      case 50:
        return "L";
      case 90:
        return "XC";
      case 100:
        return "C";
      case 400:
        return "CD";
      case 500:
        return "D";
      case 900:
        return "CM";
      case 1000:
        return "M";
      default:
        return "";
    }
  }
}
