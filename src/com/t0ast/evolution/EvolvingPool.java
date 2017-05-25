/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution;

import com.t0ast.evolution.entities.Entity;
import com.t0ast.evolution.entities.Mutator;
import com.t0ast.evolution.misc.ListElementSelector;
import com.t0ast.evolution.training.Trainer;
import com.t0ast.evolution.training.TrainingResults;
import java.util.List;

/**
 *
 * @author T0astBread
 */
public class EvolvingPool<E extends Entity, R extends TrainingResults>
{
    private List<E> entities;
    private Trainer<E, R> trainer;
    private Mutator mutator;
    private int entitiesInGeneration, deathsPerGeneration;
    private ListElementSelector selector;
    
    public void nextGen()
    {
        this.trainer.trainGeneration(this.entities);
        this.entities.sort(null);
        for(int i = 0; i < this.deathsPerGeneration; i++)
        {
            this.entities.remove(this.selector.selectIndex(this.entities));
        }
        while(this.entities.size() < this.entitiesInGeneration)
        {
            this.entities.add(null); //Add randomly generated entity here
        }
    }
}
