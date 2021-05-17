package ga.rugal.leetcode.accountsmerge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/accounts-merge/
 *
 * @author rugalbernstein
 */
public class Solution {

  public List<List<String>> accountsMerge(final List<List<String>> accounts) {
    final DSU dsu = new DSU();
    final Map<String, String> emailToName = new HashMap<>();
    final Map<String, Integer> emailToID = new HashMap<>();
    int id = 0;
    for (List<String> account : accounts) {
      String name = "";
      for (String email : account) {
        if (name.equals("")) {
          name = email;
          continue;
        }
        emailToName.put(email, name);
        if (!emailToID.containsKey(email)) {
          emailToID.put(email, id++);
        }
        dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
      }
    }

    final Map<Integer, List<String>> ans = new HashMap();
    for (String email : emailToName.keySet()) {
      int index = dsu.find(emailToID.get(email));
      ans.computeIfAbsent(index, x -> new ArrayList<>()).add(email);
    }
    for (List<String> component : ans.values()) {
      Collections.sort(component);
      component.add(0, emailToName.get(component.get(0)));
    }
    return new ArrayList<>(ans.values());
  }

  static class DSU {

    int[] parent;

    public DSU() {
      parent = new int[10001];
      for (int i = 0; i <= 10000; ++i) {
        parent[i] = i;
      }
    }

    public int find(int x) {
      if (parent[x] != x) {
        parent[x] = find(parent[x]);
      }
      return parent[x];
    }

    public void union(int x, int y) {
      parent[find(x)] = find(y);
    }
  }
}
