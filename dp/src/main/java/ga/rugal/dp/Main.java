package ga.rugal.dp;

/**
 *
 * @author Rugal Bernstein
 */
public class Main
{

    /**
     * Minimum of three
     *
     * @param a
     * @param b
     * @param c
     *
     * @return
     */
    private int min(int a, int b, int c)
    {
        return Math.min(Math.min(a, b), c);
    }

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
        for (int i = 0; i < length.length; i++)
        {
            length[i] = 1;
        }
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

    /**
     * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
     *
     * @param first
     * @param second
     *
     * @return
     */
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
                    dp[i][j] = 1 + this.min(dp[i][j - 1],// Insert
                                            dp[i - 1][j],// Remove
                                            dp[i - 1][j - 1]); // Replace
                }

            }
        }
        return dp[first.length][second.length];
    }

    /**
     * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
     *
     *
     * @param cost
     *
     * @return
     */
    public int minCostPath(int[][] cost)
    {
        int column = cost[0].length;
        int row = cost.length;
        int[][] total = new int[row][column];
        total[0][0] = cost[0][0];
        for (int i = 1; i < row; i++)
        {
            total[i][0] = cost[i][0] + total[i - 1][0];
        }
        for (int i = 1; i < column; i++)
        {
            total[0][i] = cost[0][i] + total[0][i - 1];
        }
        for (int i = 1; i < row; i++)
        {
            for (int j = 1; j < column; j++)
            {
                total[i][j] = cost[i][j] + this.min(total[i - 1][j],
                                                    total[i - 1][j - 1],
                                                    total[i][j - 1]);
            }
        }
        return total[row - 1][column - 1];
    }

    /**
     * http://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
     *
     * @param coins
     * @param V
     *
     * @return
     */
    public int minCoins(int coins[], int V)
    {
        // table[i] will be storing the minimum number of coins
        // required for i value.  So table[V] will have result
        int[] table = new int[V + 1];

        // Base case (If given value V is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i = 1; i <= V; i++)
        {
            table[i] = Integer.MAX_VALUE;
        }
        // Compute minimum coins required for all
        // values from 1 to V
        for (int i = 1; i <= V; i++)
        {
            // Go through all coins smaller than i
            for (int j = 0; j < coins.length; j++)
            {
                //if this value is changable
                if (coins[j] <= i)
                {
                    int sub_res = table[i - coins[j]];//Get result of subproblem
                    //The subproblem will be ignored if it is bigger than current choice
                    //or it is not initialized
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                    {
                        //only update under the condition that current choice is guarantee to be better
                        table[i] = sub_res + 1;
                    }
                }
            }
        }
        return table[V];
    }

    /**
     * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
     *
     * @param data
     * @param value
     *
     * @return
     */
    public int count(int[] data, int value)
    {
        // We need n+1 rows as the table is consturcted in bottom up manner using
        // the base case 0 value case (n = 0)
        int[][] table = new int[value + 1][data.length];

        // Fill the entries for 0 value case (n = 0)
        for (int i = 0; i < data.length; i++)
        {
            table[0][i] = 1;
        }
        // Fill rest of the table enteries in bottom up manner
        for (int i = 1; i < value + 1; i++)
        {
            for (int j = 0; j < data.length; j++)
            {
                // Count of solutions including S[j]
                int x = (i - data[j] >= 0) ? table[i - data[j]][j] : 0;

                // Count of solutions excluding S[j]
                int y = (j >= 1) ? table[i][j - 1] : 0;

                // total count
                table[i][j] = x + y;
            }
        }
        return table[value][data.length - 1];
    }

}
