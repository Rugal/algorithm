package ga.rugal.leetcode;

/**
 *
 * @author Rugal Bernstein
 */
public class HouseRobber
{

    public int rob(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }
        if (nums.length == 1)
        {
            return nums[0];
        }
        if (nums.length == 2)
        {
            return Math.max(nums[0], nums[1]);
        }
        int[] total = new int[nums.length];
        //rob only the first one
        total[0] = nums[0];
        //rob from the first two houses
        total[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < total.length; i++)
        {
            /*
            For robbery to i house, we could have 2 choices, under the condition that we could not trigger alarm.
            1. rob it if we could get more money by doing so
            2. skip if we would rather rob the i-1 house
             */

            total[i] = Math.max(total[i - 1], total[i - 2] + nums[i]);
        }
        return total[nums.length - 1];

    }
}
