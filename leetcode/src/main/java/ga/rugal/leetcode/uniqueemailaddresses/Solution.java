package ga.rugal.leetcode.uniqueemailaddresses;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-email-addresses/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private String translate(final String email) {
    final String[] split = email.split("@");
    return String.format("%s@%s",
                         split[0].split("\\+")[0].replace(".", ""),
                         split[1]);
  }

  public int numUniqueEmails(final String[] emails) {
    final Set<String> set = new HashSet<>();

    for (String email : emails) {
      set.add(this.translate(email));
    }
    return set.size();
  }
}
