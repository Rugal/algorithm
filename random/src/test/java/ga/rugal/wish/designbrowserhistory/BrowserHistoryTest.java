package ga.rugal.wish.designbrowserhistory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BrowserHistoryTest {

  @Test
  public void visit_1() {
    final var history = new BrowserHistory("leetcode.com");
    history.visit("google.com");
    history.visit("facebook.com");
    history.visit("youtube.com");
    Assertions.assertEquals("facebook.com", history.back(1));
    Assertions.assertEquals("google.com", history.back(1));
    Assertions.assertEquals("facebook.com", history.forward(1));
    history.visit("linkedin.com");
    Assertions.assertEquals("linkedin.com", history.forward(2));
    Assertions.assertEquals("google.com", history.back(2));
    Assertions.assertEquals("leetcode.com", history.back(7));
  }
  //["forward",   "visit","back","visit","visit","forward"]
  //[[5],         ["uun.com"],[10],["hci.com"],["whula.com"],[10]]
  //["iybch.com", null,"esgriv.com",null,null,"whula.com"]

  @Test
  public void visit_2() {
    final var history = new BrowserHistory("esgriv.com");
    history.visit("cgrt.com");
    history.visit("tip.com");
    Assertions.assertEquals("esgriv.com", history.back(9));
    history.visit("kttzxgh.com");

    Assertions.assertEquals("kttzxgh.com", history.forward(7));
    history.visit("crqje.com");
    history.visit("iybch.com");

    Assertions.assertEquals("iybch.com", history.forward(5));
  }
}
