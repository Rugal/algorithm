package ga.rugal.amazon.pairsofsongswithtotaldurationsdivisibleby60;

/**
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 *
 * @author rugal
 */
public class Solution {

  private int sum(int n) {
    return n * (n - 1) / 2;
  }

  /**
   * We are storing the song with modulo 60 to its specific storage array. <BR>
   * Such that we can combine: 1 + 59, 2 + 58, 3 + 57,........., 29 + 31 <BR>
   * But we cannot do the same for songs with time 60, 120, 180 and similarly 30, 150, 210 <BR>
   * because the same song cannot be combined with itself hence we will count nC2 for them, <BR>
   * i.e., n * (n-1)/2
   *
   * @param time
   *
   * @return
   */
  public int numPairsDivisibleBy60(final int[] time) {
    final var count = new int[60];
    for (int i : time) {
      ++count[i % 60];
    }
    int result = 0;
    result += this.sum(count[0]) + this.sum(count[30]);
    for (int i = 1; i < 30; ++i) {
      result += count[i] * count[60 - i];
    }
    return result;
  }
}
