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

import java.util.List;

/**
 *
 * @author rugal
 */
public class Question1 {

  private static int move(int a, int b) {
    int count = 0;
    while (a != 0) {
      final int ra = a % 10;
      final int rb = b % 10;
      count += Math.abs(ra - rb);
      a /= 10;
      b /= 10;
    }
    return count;
  }

  /**
   * Complete the 'minimumMoves' function below.The function is expected to return an INTEGER.The
   * function accepts following parameters: 1.INTEGER_ARRAY a 2.
   *
   * INTEGER_ARRAY m
   *
   * @param a
   * @param m
   *
   * @return
   */
  public static int minimumMoves(List<Integer> a, List<Integer> m) {
    int count = 0;
    for (int i = 0; i < a.size(); ++i) {
      count += move(a.get(i), m.get(i));
    }
    return count;
  }
}
