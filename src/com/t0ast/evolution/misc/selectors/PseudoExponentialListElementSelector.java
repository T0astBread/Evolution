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
public class PseudoExponentialListElementSelector implements ListElementSelector{
    private double base = 1.1 ; // The percent chance base for the first element. Must be higher than 1;
    // Make default bae value be determined by list length to avoid values over 100 percent / 100 promille

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
        while (true){
        for (int i = 0; i < list.size(); i++) {
           if (Math.pow(base,i)>=(int)(Math.random()*100))
                   {
                       return i;
                   }
            
        }
        }

    }
    
}
