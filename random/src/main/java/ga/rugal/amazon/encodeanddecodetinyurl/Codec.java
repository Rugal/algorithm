package ga.rugal.amazon.encodeanddecodetinyurl;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 *
 * @author rugalbernstein
 */
public class Codec {

  private static final String URL = "http://tinyurl.com/";

  private final Map<Integer, String> map = new HashMap<>();

  private int i = 0;

  public String encode(final String longUrl) {
    this.map.put(i, longUrl);
    return URL + i++;
  }

  public String decode(final String shortUrl) {
    return this.map.get(Integer.parseInt(shortUrl.replace(URL, "")));
  }
}
