/*
 * Copyright 2020 u6105440.
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
 * @author Rugal
 */
public class Question6 {

  private static final List<Character> VOWEL = List.of('a', 'e', 'i', 'o', 'u');

  private static boolean isValid(final int index, final char c) {
    return c == VOWEL.get(index) || (index + 1 < VOWEL.size() && c == VOWEL.get(index + 1));
  }

  public static int longestVowelSubsequence(final String input) {
    int max = 0;
    int length = 0;
    int index = 0;
    for (int i = 0; i < input.length(); ++i) {
      final char c = input.charAt(i);
      if (isValid(index, c)) {
        length++; //matched somehow
        if (c != VOWEL.get(index)) {
          //if mismatch the current one
          //which means it matches the next one
          ++index;
        }
        continue;
      }
      if (max < length && index + 1 == VOWEL.size()) {
        //only if it has all vowels
        max = length;
      }
      length = 0;
      index = 0;
    }
    return max;
  }
}
