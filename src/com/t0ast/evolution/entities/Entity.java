/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.entities;

/**
 *
 * @author T0astBread
 */
public abstract class Entity implements Comparable<Entity>, Cloneable
{
    private float fitness;
    private boolean tested;

    public float getFitness()
    {
        return this.fitness;
    }

    public void setFitness(float fitness)
    {
        this.fitness = fitness;
    }

    public boolean isTested()
    {
        return tested;
    }

    public void setTested(boolean tested)
    {
        this.tested = tested;
    }

    @Override
    public int compareTo(Entity o)
    {
        return Float.compare(this.fitness, o.fitness);
    }
    
    public Object clone()
    {
        try
        {
            return super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            return null;
        }
    }
}
