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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author rugal
 */
public class Question2 {

  private static final Map<Character, Character> MAP = new HashMap<>();

  static {
    MAP.put('(', ')');
    MAP.put('{', '}');
    MAP.put('[', ']');
  }

  public static boolean isValid(final String s) {
    final Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); ++i) {
      final char c = s.charAt(i);
      if (MAP.containsKey(c)) {
        stack.push(c);
        continue;
      }
      if (stack.isEmpty()
          || MAP.get(stack.peek()) != c) {
        return false;
      }
      stack.pop();
    }
    return stack.isEmpty();
  }

  /**
   * Complete the braces function below.
   *
   * @param values
   *
   * @return
   */
  public static String[] braces(String[] values) {
    return Arrays.asList(values).stream()
      .map(v -> isValid(v) ? "YES" : "NO")
      .toArray(String[]::new);
  }
}
