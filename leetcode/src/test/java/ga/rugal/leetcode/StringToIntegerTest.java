/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga.rugal.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author yxy8uw9
 */
public class StringToIntegerTest {

  private final StringToInteger instance = new StringToInteger();

  /**
   * Test of myAtoi method, of class StringToInteger.
   */
  @Test
  public void testMyAtoi() {

    Assert.assertEquals(-2147483647, this.instance.myAtoi("-2147483647"));
  }
}
