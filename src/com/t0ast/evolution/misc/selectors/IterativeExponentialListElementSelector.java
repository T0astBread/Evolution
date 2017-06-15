/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.misc.selectors;

import java.util.List;

/**
 *
 * @author buchj This use a dynamic base, it takes the % chances for the first
 * and last entry, and makes a exponential formula for the chance to be picked;
 */
public class IterativeExponentialListElementSelector implements ListElementSelector
{// f(index)= base*factor^index

    private double baseChance;// The chance for the first entity of the list; Also. the base for the formula 
    private double maxChance;// The chance for the last entity of the list; Also needed to calculate the factor of the formula
    private double factor;

    public IterativeExponentialListElementSelector(double firstChance, double lastChance)
    {
        this.baseChance = firstChance;
        this.maxChance = lastChance;
        while(baseChance > 1 || maxChance > 1)
        {
            baseChance *= 0.1;
            maxChance *= 0.1;
        }
    }

    private double getFactor(int size)  // f(biggestIndex)=base*factor^biggestIndex = maxChance;
    {                                   // factor = Wurzel[maxChance/base] 
        double dsize = size;

        double d = maxChance / baseChance;
        double root = 1.0 / dsize;
        double f = Math.pow(d, root);
        return f;
    }

    @Override
    public <T> T selectFrom(List<T> list)
    {
        return list.get(selectIndex(list));
    }

    @Override
    public int selectIndex(List list)
    {
        factor = getFactor(list.size());
        int i;
        while(true)
        {
            i = (int) (Math.random() * (list.size() - 1));
            double chance = baseChance * Math.pow(factor, i);
            double check = Math.random();

            if(chance >= check)
            {
                return i;
            }
        }
    }

}
