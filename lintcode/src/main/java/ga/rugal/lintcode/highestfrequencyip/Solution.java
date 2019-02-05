package ga.rugal.lintcode.highestfrequencyip;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * @param ipLines: ip address
   *
   * @return
   *
   * @return: return highestFrequency ip address
   */
  public String highestFrequency(String[] ipLines) {
    // Write your code here
    final Map<String, Integer> map = new HashMap<>();
    for (String ipLine : ipLines) {
      map.put(ipLine, map.getOrDefault(ipLine, 0) + 1);
    }
    int max = -1;
    String current = null;
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (max < entry.getValue()) {
        max = entry.getValue();
        current = entry.getKey();
      }
    }

    return current;
  }
}
