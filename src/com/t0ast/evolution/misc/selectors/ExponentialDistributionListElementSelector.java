/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.misc.selectors;

import java.util.List;
import java.util.Random;

/**
 * NOT working yet - The values are not bound
 * @author T0astBread
 */
public class ExponentialDistributionListElementSelector implements ListElementSelector
{
    private float lambda;
    private Random random;

    public ExponentialDistributionListElementSelector()
    {
        this(.5f);
    }

    public ExponentialDistributionListElementSelector(float lambda)
    {
        this.lambda = lambda;
        this.random = new Random();
    }

    public double nextRandom()
    {
        return Math.log(1 - this.random.nextDouble())/(-this.lambda);
    }

    @Override
    public <T> T selectFrom(List<T> list)
    {
        return list.get(selectIndex(list));
    }

    @Override
    public int selectIndex(List list)
    {
        return (int) (nextRandom() * list.size());
    }
    
    
}
