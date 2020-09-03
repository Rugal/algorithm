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
package ga.rugal.reuters;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author rugal
 */
public class Question4 {

  private static class PairComparator implements Comparator<Map.Entry<Character, Pair>> {

    @Override
    public int compare(Map.Entry<Character, Pair> o1, Map.Entry<Character, Pair> o2) {
      return o1.getValue().compareTo(o2.getValue());
    }
  }

  private static class Pair implements Comparable<Pair> {

    int index;

    int count;

    public Pair(final int index) {
      this.index = index;
      this.count = 0;
    }

    @Override
    public int compareTo(final Pair o) {
      return this.count != o.count
             ? o.count - this.count
             : this.index - o.index;
    }
  }

  /*
   * Complete the 'maximumOccurringCharacter' function below.
   *
   * The function is expected to return a CHARACTER. The function accepts STRING text as parameter.
   */
  public static char maximumOccurringCharacter(final String text) {
    final TreeMap<Character, Pair> map = new TreeMap<>();
    for (int i = 0; i < text.length(); ++i) {
      final char c = text.charAt(i);
      final Pair p = map.getOrDefault(c, new Pair(i));
      p.count++;
      map.put(c, p);
    }

    return Collections.min(map.entrySet(), new PairComparator()).getKey();
  }
}
