package ga.rugal.leetcode;

/**
 *
 * @author Rugal Bernstein
 */
public class ClimbingStairs
{

    public int climbStairs(int n)
    {
        if (n <= 2)
        {
            return n;
        }
        int step1 = 1, step2 = 2;
        for (int i = 3; i < n + 1; i++)
        {
            //iterate
            step1 = step1 + step2;
            //swap
            step1 = step1 ^ step2 ^ (step2 = step1);
        }
        return step2;
    }
}
