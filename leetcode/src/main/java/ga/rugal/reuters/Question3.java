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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rugal
 */
public class Question3 {

  private static int getDifference(final String a, final String b) {
    if (a.length() != b.length()) {
      return -1;
    }
    final Map<Character, Integer> map = new HashMap();
    for (char c : a.toCharArray()) {
      final int in = map.getOrDefault(c, 0);
      map.put(c, in + 1);
    }
    int count = 0;
    for (char c : b.toCharArray()) {
      final int in = map.getOrDefault(c, 0);
      if (in > 0) {
        map.put(c, in - 1);
      } else {
        map.remove(c);
        count++;
      }
    }
    return count;
  }

  /**
   * Complete the 'getMinimumDifference' function below.The function is expected to return an
   * INTEGER_ARRAY.The function accepts following parameters: 1.STRING_ARRAY a 2.
   *
   * STRING_ARRAY b
   *
   * @param a
   * @param b
   *
   * @return
   */
  public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < a.size(); i++) {
      result.add(getDifference(a.get(i), b.get(i)));
    }
    return result;
  }
}
