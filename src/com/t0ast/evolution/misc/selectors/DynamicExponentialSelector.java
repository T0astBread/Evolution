/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.misc.selectors;

import java.util.List;

/**
 *
 * @author buchj
 * This use a dynamic base,  it takes the % chances for the first and last entry, and makes a exponential formula for the chance to be picked;
 */
public class DynamicExponentialSelector implements ListElementSelector{// f(index)= base*factor^index
    private double baseChance;// The chance for the first entity of the list; Also. the base for the formula 
    private double maxChance;// The chance for the last entity of the list; Also needed to calculate the factor of the formula
    private double factor;
    

    public DynamicExponentialSelector(double firstChance, double lastChance, int listsize) {
        this.baseChance = firstChance;
        this.maxChance = lastChance;
        factor = getFactor(listsize);
    }
    private double getFactor(int size)  // f(biggestIndex)=base*factor^biggestIndex = maxChance;
    {                                   // factor = Wurzel[maxChance/base] 
        double f = Math.pow(maxChance/baseChance,1/size);
        return f;
    }

    @Override
    public <T> T selectFrom(List<T> list) {
        return list.get(selectIndex(list));
    }

    @Override
    public int selectIndex(List list) {
        int i;
        while(true)
        {
            i = (int)Math.random()*list.size();
            if((baseChance*Math.pow(factor, i))<=Math.random()*100)return i;
        }
    }
    
}
