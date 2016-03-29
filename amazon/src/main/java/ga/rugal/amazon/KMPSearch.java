package ga.rugal.amazon;

/**
 * https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm#Worked_example_of_the_search_algorithm
 *
 * @author Rugal Bernstein
 */
public class KMPSearch
{

    int[] analyze(String pattern)
    {
        int[] prefix = new int[pattern.length()];
        prefix[0] = 0; // lps[0] is always 0
        // the loop calculates lps[i] for i = 1 to M-1
        for (int i = 1, len = 0; i < pattern.length();)// length of the previous longest prefix suffix
        {
            if (pattern.charAt(i) == pattern.charAt(len))
            {
                prefix[i] = ++len;
                i++;
            } else // (pat[i] != pat[len])
            {
                if (len != 0)
                {
                    // This is tricky. Consider the example: AAACAAAA and i = 7.
                    len = prefix[len - 1];
                    // Also, note that we do not increment i here
                } else
                {
                    prefix[i] = 0;
                    i++;
                }
            }
        }
        return prefix;
    }

    public int search(String source, String pattern)
    {
        int i = 0, m = 0, prefix[] = analyze(pattern);
        while (m + i < source.length())
        {
            if (pattern.charAt(i) == source.charAt(m + i))
            {
                if (i != pattern.length() - 1)
                {
                    i++;
                }
                return m;
            } else
            {
                if (prefix[i] > -1)
                {
                    m = m + i - prefix[i];
                    i = prefix[i];
                } else
                {
                    i = 0;
                    m++;
                }
            }
        }
        return -1;
    }
}
