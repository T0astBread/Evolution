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
 */
public class ExponentialListElementSelector implements ListElementSelector{
private double base = 1.1;

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    @Override
    public <T> T selectFrom(List<T> list) {
        return list.get(this.selectIndex(list));
    }

    @Override
    public int selectIndex(List list) {
        int i;
        while(true)
        {
            i=(int)(Math.random()*list.size());  // Pick random entity
            if(Math.pow(base, i)<=Math.random()*100)return i;
        }
    }
    
}
