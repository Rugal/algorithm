package ga.rugal.amazon.minimumdifficultyofajobschedule;

/**
 * https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int minDifficulty(int[] jobDifficulty, int d) {
    if (d > jobDifficulty.length) {
      return -1;
    }

    final int[][] dp = new int[d][jobDifficulty.length];

    // Initialize dp for single day
    for (int j = 0, max = -1; j < jobDifficulty.length; j++) {
      dp[0][j] = max = Math.max(max, jobDifficulty[j]);
    }

    // For each day
    for (int day = 1; day < d; day++) {

      // For each job
      for (int job = day; job < jobDifficulty.length; job++) {

        // init day max difficulty to current job.
        int max = jobDifficulty[job];
        // init min cost to previous day job j-1 + dayMax
        int min = dp[day - 1][job - 1] + max;

        // Travel backwards over the jobs, updating dayMax and recalculating the minCost
        for (int i = job - 1; i >= day; i--) {

          // update max difficulty if jobs j where k <= j < n
          max = Math.max(max, jobDifficulty[i]);
          // update minCost of dayMax plus previous day of jobs j s.t. k < j
          min = Math.min(min, dp[day - 1][i - 1] + max);
        }

        // Set minCost of day i for all jobs up to j
        dp[day][job] = min;
      }
    }
    // return final minCost of all jobs at last day
    return dp[d - 1][jobDifficulty.length - 1];
  }
}
