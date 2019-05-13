/*
 * Copyright 2019 rugalbernstein.
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
package ga.rugal.amazon.encodeanddecodetinyurl;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 *
 * @author rugalbernstein
 */
public class Codec {

  Map<Integer, String> map = new HashMap<>();

  int i = 0;

  public String encode(String longUrl) {
    map.put(i, longUrl);
    return "http://tinyurl.com/" + i++;
  }

  public String decode(String shortUrl) {
    return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
  }
}
