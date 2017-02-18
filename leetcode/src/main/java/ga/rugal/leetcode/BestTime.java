package ga.rugal.leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author Rugal Bernstein
 */
public class BestTime
{

    public int maxProfit(int[] prices)
    {
        if (2 > prices.length)
        {
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++)
        {
            //update the minimum found this till point
            if (prices[i] < min)
            {
                min = prices[i];
            }
            //calculate profit based on minimum found yet
            if (max < prices[i] - min)
            {
                max = prices[i] - min;
            }
        }
        return max;
    }
}
