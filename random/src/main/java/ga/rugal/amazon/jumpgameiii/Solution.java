package ga.rugal.amazon.jumpgameiii;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/jump-game-iii/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public boolean canReach(final int[] data, final int start) {
    return this.canReach_bfs(data, start);
  }

  public boolean canReach_bfs(final int[] data, final int start) {
    final Queue<Integer> q = new ArrayDeque<>();
    q.offer(start);

    final boolean[] visited = new boolean[data.length];
    while (!q.isEmpty()) {
      final var poll = q.poll();
      if (0 == data[poll]) {
        return true;
      }
      visited[poll] = true;

      if (poll + data[poll] < data.length && !visited[poll + data[poll]]) {
        q.offer(poll + data[poll]);
      }
      if (poll - data[poll] >= 0 && !visited[poll - data[poll]]) {
        q.offer(poll - data[poll]);
      }
    }

    return false;
  }

  public boolean canReach_dfs(int[] arr, int start) {
    return dfs(arr, start, new boolean[arr.length]);
  }

  public boolean dfs(int[] arr, int index, boolean[] visited) {
    //check boudary
    if (index < 0 || index >= arr.length) {
      return false;
    }

    //check index is visited
    if (visited[index]) {
      return false;
    }

    //found return true
    if (arr[index] == 0) {
      return true;
    }

    //mark as visited
    visited[index] = true;

    //+ve direction
    //if reach through +ve direction
    //just return from here
    //no need to explore -ve direction
    if (dfs(arr, index + arr[index], visited)) {
      return true;
    }
    //-ve direction
    //if reach through -ve direction
    //just return from here

    return dfs(arr, index - arr[index], visited);
  }
}
