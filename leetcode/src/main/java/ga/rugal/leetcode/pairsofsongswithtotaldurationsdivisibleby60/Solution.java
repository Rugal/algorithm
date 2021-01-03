package ga.rugal.leetcode.pairsofsongswithtotaldurationsdivisibleby60;

/**
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 *
 * @author rugal
 */
public class Solution {

  /**
   * O(n)<BR>
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
    final int[] storage = new int[60];
    // count the number of modulo
    for (int t : time) {
      storage[t % 60]++;
    }
    // nC2 for 0 and 30
    int count = (storage[0] * (storage[0] - 1)) / 2 + (storage[30] * (storage[30] - 1)) / 2;
    // calculate combination of factor and remainder
    for (int i = 1; i < 30; i++) {
      count += storage[i] * storage[60 - i];
    }
    return count;
  }
}
