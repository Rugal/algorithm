package ga.rugal.hacker;

/**
 * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 *
 * @author Rugal Bernstein
 */
public class MinimumJump
{

    public int minJump(int[] data)
    {
        int[] step = new int[data.length];
        step[0] = 0;

        for (int i = 1; i < data.length; i++)
        {
            step[i] = -1;
            for (int j = 0; j < i; j++)
            {
                if (j + data[j] >= i && -1 != step[i] && step[i] > step[j] + 1)
                {
                    step[i] = step[j] + 1;
                }
            }
        }
        return 0;
    }
}
