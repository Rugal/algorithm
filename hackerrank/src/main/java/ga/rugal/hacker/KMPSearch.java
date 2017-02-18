package ga.rugal.hacker;

/**
 * https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm#Worked_example_of_the_search_algorithm
 *
 * @author Rugal Bernstein
 */
public class KMPSearch
{

    /**
     * c o c a c o l a <BR> 0 0 1 0 1 2 0 0
     *
     * @param pattern
     *
     * @return
     */
    int[] analyze(String pattern)
    {
        int[] prefix = new int[pattern.length()];
        prefix[0] = 0; // lps[0] is always 0
        // the loop calculates lps[i] for i = 1 to M-1
        for (int i = 1, len = 0; i < pattern.length();)// length of the previous longest prefix suffix
        {
            if (pattern.charAt(i) == pattern.charAt(len))
            {
                prefix[i++] = ++len;
            } else
            {
                // (pat[i] != pat[len])
                if (len != 0)
                {
                    // This is tricky. Consider the example: AAACAAAA and i = 7.
                    len = prefix[len - 1];
                    // Also, note that we do not increment i here
                } else
                {
                    prefix[i++] = 0;
                }
            }
        }
        return prefix;
    }

    public int search(String source, String pattern)
    {
        int[] prefix = analyze(pattern);
        for (int current = 0, indexOfPattern = 0; current < source.length();)
        {
            if (pattern.charAt(indexOfPattern) == source.charAt(current))
            {
                indexOfPattern++;
                current++;
            }
            //matched
            if (indexOfPattern == pattern.length())
            {
                return current - indexOfPattern;
//                indexOfPattern = prefix[indexOfPattern - 1];
            } else
            {// mismatch after j matches
                if (current < source.length() && pattern.charAt(indexOfPattern) != source.charAt(current))
                {
                    // Do not match lps[0..lps[j-1]] characters, they will match anyway
                    if (indexOfPattern != 0)
                    {
                        indexOfPattern = prefix[indexOfPattern - 1];
                    } else
                    {
                        current++;
                    }
                }
            }
        }
        return -1;
    }
}
