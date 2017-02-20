/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ga.rugal.leetcode;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author rugal
 */
public class TeemoAttackingTest {

    private final TeemoAttacking instance = new TeemoAttacking();

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testFindPoisonedDuration() {
        System.out.println("findPoisonedDuration");
        int[] input = new int[]{1, 2};
        int durationInput = 2;
        int expResult = 3;
        int result = instance.findPoisonedDuration(input, durationInput);
        Assert.assertEquals(expResult, result);
    }

}
