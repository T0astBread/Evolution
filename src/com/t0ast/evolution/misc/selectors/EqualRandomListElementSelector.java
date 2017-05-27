/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.misc.selectors;

import java.util.List;

/**
 *
 * @author T0astBread
 */
public class EqualRandomListElementSelector implements ListElementSelector
{
    @Override
    public <T> T selectFrom(List<T> list)
    {
        return list.get(selectIndex(list));
    }

    @Override
    public int selectIndex(List list)
    {
        return (int) (Math.random() * list.size());
    }
}
