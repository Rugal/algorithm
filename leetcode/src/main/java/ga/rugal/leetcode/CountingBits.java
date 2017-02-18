package ga.rugal.leetcode;

/**
 * https://leetcode.com/problems/counting-bits/
 *
 * @author Rugal Bernstein
 */
public class CountingBits
{

    public int[] countBits(int num)
    {
        int[] data = new int[num + 1];
        for (int i = 1; i <= num;)
        {
            data[i] = 1;
            i *= 2;
        }
        int last = 1;
        for (int i = 2; i <= num; i++)
        {
            if (data[i] == 1)
            {
                last = i;
                continue;
            }
            data[i] = data[last] + data[i - last];
        }
        return data;
    }
}
