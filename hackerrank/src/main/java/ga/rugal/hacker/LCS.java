package ga.rugal.hacker;

/**
 *
 * @author Rugal Bernstein
 */
public class LCS
{

    public int search(String a, String b)
    {
        int[][] match = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++)
        {
            for (int j = 1; j <= b.length(); j++)
            {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                {//from last matching character
                    match[i][j] = match[i - 1][j - 1] + 1;
                } else
                {//from spreading matching
                    match[i][j] = Math.max(match[i - 1][j], match[i][j - 1]);
                }
            }
        }
        return match[a.length()][b.length()];
    }
}
