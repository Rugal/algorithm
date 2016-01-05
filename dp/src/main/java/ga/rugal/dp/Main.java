package ga.rugal.dp;

/**
 *
 * @author Administrator
 */
public class Main
{

    /**
     * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
     *
     * @param data
     *
     * @return
     */
    public int longestIncreaseSequence(int[] data)
    {
        int[] length = new int[data.length];
        for (int i = 0; i < length.length; length[i++] = 1);
        for (int i = 1; i < data.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (data[j] < data[i] && length[j] >= length[i])
                {
                    length[i] = length[j] + 1;
                }
            }
        }
        int max = -1;
        for (int i = 0; i < length.length; i++)
        {
            if (max < length[i])
            {
                max = length[i];
            }
        }
        return max;
    }

    /**
     * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
     *
     * @param first
     * @param second
     *
     * @return
     */
    public int longestCommonSubsequence(char[] first, char[] second)
    {
        int[][] length = new int[first.length + 1][second.length + 1];
        for (int i = 0; i <= first.length; i++)
        {
            for (int j = 0; j <= second.length; j++)
            {
                if (i == 0 || j == 0)
                {
                    length[i][j] = 0;
                } else
                {
                    if (first[i - 1] == second[j - 1])
                    {
                        length[i][j] = length[i - 1][j - 1] + 1;
                    } else
                    {
                        length[i][j] = Math.max(length[i - 1][j], length[i][j - 1]);
                    }
                }
            }
        }
        return length[first.length][second.length];
    }

    public int editDist(char[] first, char[] second)
    {
        // Create a table to store results of subproblems
        int[][] dp = new int[first.length + 1][second.length + 1];

        // If first string is empty, the only option is to insert all characters of second string
        for (int i = 0; i <= first.length; i++)
        {
            // minimum operations is j
            dp[i][0] = i;
        }
        // If second string is empty, only option is to  remove all characters of second string
        for (int i = 0; i <= second.length; i++)
        {
            // minimum operations is i
            dp[0][i] = i;
        }
        // Fill d[][] in bottom up manner
        for (int i = 1; i <= first.length; i++)
        {
            for (int j = 1; j <= second.length; j++)
            {
                // If last characters are same, ignore last char and recur for remaining string
                if (first[i - 1] == second[j - 1])
                {
                    dp[i][j] = dp[i - 1][j - 1];
                } else
                {
                    // If last character are different, consider all possibilities and find minimum
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1],// Insert
                                                     dp[i - 1][j]),// Remove
                                            dp[i - 1][j - 1]); // Replace
                }

            }
        }
        return dp[first.length][second.length];
    }
}
