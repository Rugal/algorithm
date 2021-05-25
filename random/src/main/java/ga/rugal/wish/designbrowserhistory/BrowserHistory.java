package ga.rugal.wish.designbrowserhistory;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/design-browser-history/
 *
 * @author Rugal Bernstein
 */
public class BrowserHistory {

  private final List<String> history = new ArrayList<>();

  private int current;

  private int top;

  public BrowserHistory(String homepage) {
    this.history.add(homepage);
    this.current = 0;
    this.top = 0;
  }

  public void visit(final String url) {
    if (this.top > this.current || this.history.size() > this.top + 1) {
      this.history.set(++this.current, url);
    } else {
      this.history.add(url);
      ++this.current;
    }

    this.top = this.current;
  }

  public String back(final int steps) {
    this.current -= (this.current < steps)
                    ? this.current
                    : steps;
    return this.history.get(this.current);
  }

  public String forward(final int steps) {
    if (this.current + steps > this.top) {
      this.current = this.top;
    } else {
      this.current += steps;
    }

    return this.history.get(this.current);
  }
}
