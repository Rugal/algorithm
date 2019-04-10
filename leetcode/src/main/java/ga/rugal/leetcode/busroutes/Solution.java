/*
 * Copyright 2019 rugal.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ga.rugal.leetcode.busroutes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/bus-routes/
 *
 * @author rugal
 */
public class Solution {

  private Map<Integer, List<Integer>> build(final int[][] routes) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < routes.length; i++) {
      int[] route = routes[i];
      for (int j = 0; j < route.length; j++) {
        if (!map.containsKey(route[j])) {
          map.put(route[j], new ArrayList<>());
        }
        map.get(route[j]).add(i);
      }
    }
    return map;
  }

  private int bfs(final Map<Integer, List<Integer>> map, int[][] routes, int S, int T) {
    final Queue<Turn> q = new LinkedList<>();
    q.offer(new Turn(S, 0));
    final Set<Integer> visitedRoute = new HashSet<>();
    final Set<Integer> visitedStop = new HashSet<>();
    visitedStop.add(S);
    while (!q.isEmpty()) {
      final Turn poll = q.poll();
      if (poll.station == T) {
        return poll.distance;
      }

      for (int route : map.get(poll.station)) {
        if (visitedRoute.contains(route)) {
          //if we have visited this bus route before
          continue;
        }
        for (int stop : routes[route]) {
          if (visitedStop.contains(stop)) {
            //if we have taken this bus before
            continue;
          }
          visitedStop.add(stop);
          q.offer(new Turn(stop, poll.distance + 1));
        }
        visitedRoute.add(route);
      }
    }

    return -1;
  }

  public int numBusesToDestination(int[][] routes, int S, int T) {
    return this.bfs(this.build(routes), routes, S, T);
  }

  class Turn {

    public int station;

    public int distance;

    public Turn(int station, int distance) {
      this.station = station;
      this.distance = distance;
    }
  }
}
