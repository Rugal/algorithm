package ga.rugal.wish.cheapestflightswithinkstops;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    // costs[i] = minimum cost from src to city i within k stops;
    int[] costs = new int[n];
    Arrays.fill(costs, Integer.MAX_VALUE);
    costs[src] = 0;

    //build graph
    int[][] graph = new int[n][n];
    for (int[] flight : flights) {
      int from = flight[0];
      int to = flight[1];
      int cost = flight[2];
      graph[from][to] = cost;
    }

    Deque<City> q = new ArrayDeque<>();
    q.add(new City(src, 0));

    while (!q.isEmpty() && k-- >= 0) {
      int size = q.size();
      while (size-- > 0) {
        City cur = q.poll();
        int curCity = cur.city;
        int curCost = cur.costFromSrc;

        int[] costToNextCities = graph[curCity];
        for (int nextCity = 0; nextCity < n; nextCity++) {
          int costToNext = costToNextCities[nextCity];

          if (costToNext == 0) //meaning no flights from curCity to nextCity
          {
            continue;
          }

          int costFromSrc = curCost + costToNext;

          //Add nextCity ONLY IF the total cost is the lowest from src to nextCity seen so far;
          if (costFromSrc <= costs[nextCity]) {
            costs[nextCity] = costFromSrc;
            q.add(new City(nextCity, costs[nextCity]));
          }
        }
      }
    }

    return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
  }
}

class City {

  int city;

  int costFromSrc;

  public City(int city, int costFromSrc) {
    this.city = city;
    this.costFromSrc = costFromSrc;
  }
}
