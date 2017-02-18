package ga.rugal.hacker;

/**
 *
 * @author Rugal Bernstein
 */
public class TrapWater
{

    int findWater(int[] tower, int n)
    {

        int[] left = new int[n];
        int[] right = new int[n];
        //The left largest tower
        left[1] = tower[0];
        for (int i = 2; i < n - 1; i++)
        {
            left[i] = Math.max(left[i - 1], tower[i - 1]);
        }
        //The right largest tower
        right[n - 2] = tower[n - 1];
        for (int i = n - 3; i > 0; i--)
        {
            right[i] = Math.max(right[i + 1], tower[i + 1]);
        }
        //
        int water = 0;
        for (int i = 1; i < n - 1; i++)
        {
            //The water that could be held within this tower area
            int tmp = Math.min(right[i], left[i]) - tower[i];
            if (tmp > 0)
            {
                water = water + tmp;
            }
        }
        return water;
    }
}
