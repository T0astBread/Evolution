/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.misc.selectors;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 *
 * @author T0astBread
 */
public class ExponentialDistributionListElementSelectorTest
{
    @Test
    public void testNextRandom()
    {
        List l = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        ExponentialDistributionListElementSelector sel = new ExponentialDistributionListElementSelector();
        Random r = new Random();
        for(int i = 0; i < 1000; i++)
        {
            System.out.println(sel.nextRandom());
        }
    }
}
