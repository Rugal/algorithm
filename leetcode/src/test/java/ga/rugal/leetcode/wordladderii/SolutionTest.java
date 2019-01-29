package ga.rugal.leetcode.wordladderii;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Rugal Bernstein
 */
@RunWith(Parameterized.class)
public class SolutionTest {

  private final Solution solution = new Solution();

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      //      {"hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}, 5},
      {"hot", "dog", new String[]{"hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot"}, 5},});
  }

  @Parameterized.Parameter(0)
  public String start;

  @Parameterized.Parameter(1)
  public String end;

  @Parameterized.Parameter(2)
  public String[] wordList;

  @Parameterized.Parameter(3)
  public int expected;

  @Test
  public void testLadderLength() {

    this.solution.findLadders(this.start,
                              this.end,
                              Arrays.asList(this.wordList));
  }
}
