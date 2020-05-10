package ga.rugal.leetcode.findthetownjudge;

/**
 * https://leetcode.com/problems/find-the-town-judge/
 *
 * @author rugal
 */
public class Solution {

  public int findJudge(int N, int[][] trust) {
    final int[] in = new int[N + 1], out = new int[N + 1];
    for (int[] input : trust) {
      // person trust others
      out[input[0]]++;
      // person trusted by others
      in[input[1]]++;
    }
    int result = -1;
    for (int i = 1; i <= N; ++i) {
      if (out[i] != 0 || in[i] != N - 1) {
        // trust no one
        // trusted by all the others
        continue;
      }
      if (result == -1) {
        // only one exists
        result = i;
      } else {
        // multiple judge
        return -1;
      }
    }
    return result;
  }
}
