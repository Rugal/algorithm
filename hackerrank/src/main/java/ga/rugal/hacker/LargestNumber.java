package ga.rugal.hacker;

/**
 *
 * @author Rugal Bernstein
 */
public class LargestNumber
{

    public int[] get(int[] input)
    {
        int[] data = new int[input.length];
        data[input.length - 1] = -1;
        for (int i = input.length - 2; i >= 0; i--)
        {
            data[i] = Math.max(input[i + 1], data[i + 1]);
        }
        return data;
    }
}
