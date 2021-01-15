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
          // end at day because we must do 1 job per day

          /*
           * find max value between job-1 => day in decreasing order.
           *
           * 0 ... day day+1 day+2 ... job-2 job-1
           *
           * find best cut between day<=>job-1 that minimize the cost between 0<=>job-1
           */
          max = Math.max(max, jobDifficulty[i]);
          // cut on i-1, group i<=>job-1 together, 0<=>i-1 is another big group
          min = Math.min(min, dp[day - 1][i - 1] + max);
        }

        // Set minCost of day i
        dp[day][job] = min;
      }
    }
    // return final minCost of all jobs at last day
    return dp[d - 1][jobDifficulty.length - 1];
  }
}
