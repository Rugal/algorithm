package ga.rugal.reuters;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rugal
 */
public class Question4Test {

  @Before
  public void setUp() {
  }

  @Test
  public void maximumOccurringCharacter() {
    Assert.assertEquals('l', Question4.maximumOccurringCharacter("helloworld"));
    Assert.assertEquals('a', Question4.maximumOccurringCharacter("bbbaaaa"));
    Assert.assertEquals('b', Question4.maximumOccurringCharacter("bbbaaa"));
    Assert.assertEquals('a', Question4.maximumOccurringCharacter("a"));
    Assert.assertEquals('c', Question4.maximumOccurringCharacter("abcc"));
    Assert.assertEquals('a', Question4.maximumOccurringCharacter("abc"));
    Assert.assertEquals('b', Question4.maximumOccurringCharacter("abbc"));
  }
}
