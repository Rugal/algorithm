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
package ga.rugal.google.readncharactersgivenread4iicallmultipletimes;

import ga.rugal.google.Reader4;

/**
 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
 *
 * @author rugal
 */
public class Solution extends Reader4 {

  private static final int SIZE = 4;

  private char[] rest = null;

  /**
   * @param buf Destination buffer
   * @param n   Number of characters to read
   *
   * @return The number of actual characters read
   */
  public int read(char[] buf, int n) {
    int read = 0;
    if (null != this.rest) {
      read += this.rest.length;
      for (int i = 0; i < Integer.min(n, this.rest.length); ++i) {
        buf[i] = this.rest[i];
      }
      if (n <= this.rest.length) {
        final char[] temp = new char[this.rest.length - n];
        for (int i = 0; i < this.rest.length - n; ++i) {
          temp[i] = this.rest[n + i];
        }
        this.rest = temp;
        return n;
      }
      this.rest = null;
    }
    final char[] temp = new char[SIZE];
    int remain = 0;
    int i = 0;
    while (read < n) {
      final int currentRead = this.read4(temp);// <= SIZE
      final int canWrite = Integer.min(n - read, currentRead);
      for (i = 0; i < canWrite; ++i) {
        buf[read + i] = temp[i];
      }
      read += canWrite;
      remain = currentRead - canWrite;
      if (canWrite < SIZE) {
        //the last call doesn't return enough data
        break;
      }
    }
    if (remain > 0) {
      this.rest = new char[remain];
      for (int j = 0; j < remain; ++j) {
        this.rest[j] = temp[i + j];
      }
    }
    return read;
  }
}
