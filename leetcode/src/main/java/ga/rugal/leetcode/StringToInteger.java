package ga.rugal.leetcode;

/**
 *
 * @author Rugal Bernstein
 */
public class StringToInteger {

  public static final String MAX = Integer.toString(Integer.MAX_VALUE);

  public static final String MIN = Integer.toString(Integer.MIN_VALUE);

  private boolean isOutOfRange(String numberText, String limit) {
    return numberText.length() > limit.length()
           || numberText.length() == limit.length() && numberText.compareTo(limit) >= 0;
  }

  public int myAtoi(String str) {
    str = str.trim();

    int lastDigit = 0;
    for (; lastDigit < str.length(); lastDigit++) {
      char c = str.charAt(lastDigit);
      if (((c == '-' || c == '+') && lastDigit == 0) || Character.isDigit(c)) {
      } else {
        break;
      }
    }

    String numberText = str.substring(0, lastDigit).replace("+", "");
    if (numberText.isEmpty() || numberText.equals("-")) {
      return 0;
    }
    if ('-' == numberText.charAt(0) && numberText.length() >= MIN.length()) {
      if (this.isOutOfRange(numberText, MIN)) {
        return Integer.MIN_VALUE;
      }
    }

    if ('-' != numberText.charAt(0) && numberText.length() >= MAX.length()) {
      if (this.isOutOfRange(numberText, MAX)) {
        return Integer.MAX_VALUE;
      }
    }

    return Integer.parseInt(numberText);
  }
}
