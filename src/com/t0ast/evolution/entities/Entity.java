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
public abstract class Entity
{
    private float fitness;

    public float getFitness()
    {
        return this.fitness;
    }

    public void setFitness(float fitness)
    {
        this.fitness = fitness;
    }
}
