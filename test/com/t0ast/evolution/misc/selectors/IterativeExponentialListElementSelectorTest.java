/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.misc.selectors;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 *
 * @author T0astBread
 */
public class IterativeExponentialListElementSelectorTest
{

    /**
     * Test of selectIndex method, of class IterativeExponentialListElementSelector.
     */
    @Test
    public void testSelectIndex()
    {
        List<Integer> l = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        ListElementSelector s = new IterativeExponentialListElementSelector(.9, .2);
        for(int i = 0; i < 100; i++)
        {
            System.out.println(s.selectIndex(l));
        }
    }
    
}
