package ga.rugal.amazon.typeahead;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://www.lintcode.com/problem/231/
 *
 * @author Rugal Bernstein
 */
public class Typeahead {

  private final Map<String, Set<String>> map = new HashMap<>();

  /**
   * @param dict: A dictionary of words dict
   */
  public Typeahead(final Set<String> dict) {
    // do intialization if necessary
    for (String s : dict) {
      for (int i = 0; i < s.length(); ++i) {
        for (int j = i + 1; j <= s.length(); ++j) {
          final String key = s.substring(i, j);
          final Set<String> d = this.map.getOrDefault(key, new HashSet<>());
          d.add(s);
          this.map.put(key, d);
        }
      }
    }
  }

  /**
   * @param str: a string @return: a list of words
   *
   * @return
   */
  public List<String> search(final String str) {
    return new ArrayList<>(this.map.getOrDefault(str, new HashSet<>()));
  }
}
