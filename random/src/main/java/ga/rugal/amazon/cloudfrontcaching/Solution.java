package ga.rugal.amazon.cloudfrontcaching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/discuss/interview-question/1061306/Amazon-or-OA-(SDE-experienced)-Canada-or-Cloud-Front-Caching
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private Map<Integer, List<Integer>> g;

  private boolean[] visited;

  private int doBFS(int start) {
    final Queue<Integer> q = new LinkedList<>();
    q.offer(start);
    this.visited[start] = true;
    int cnt = 0;
    while (!q.isEmpty()) {
      int cur = q.poll();
      cnt++;
      if (!g.containsKey(cur)) {
        continue;
      }
      for (int next : g.get(cur)) {
        if (!this.visited[next]) {
          q.offer(next);
          this.visited[next] = true;
        }
      }
    }
    return (int) (Math.ceil(Math.sqrt(cnt)));
  }

  public int getEfficiencyOfCloudFrontCaching(int N, int[][] edges) {
    this.g = new HashMap<>();
    this.visited = new boolean[N];
    for (int i = 0; i < edges.length; ++i) {
      int src = edges[i][0] - 1, dest = edges[i][1] - 1;
      if (!g.containsKey(src)) {
        g.put(src, new ArrayList<>());
      }
      if (!g.containsKey(dest)) {
        g.put(dest, new ArrayList<>());
      }
      g.get(src).add(dest);
      g.get(dest).add(src);
    }

    int res = 0;
    for (int i = 0; i < N; ++i) {
      if (!visited[i]) {
        res += doBFS(i);
      }
    }
    return res;
  }
}
