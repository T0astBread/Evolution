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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T0astBread
 */
public class EvolvingPool<E extends Entity, R extends TrainingResults>
{
    private List<E> entities;
    private Trainer<E, R> trainer;
    private Mutator<E> mutator;
    private int entitiesInGeneration, deathsPerGeneration;
    private ListElementSelector killSelector, breedingSelector;
    private MutationType mutationType;
    
    public void nextGen()
    {
        this.trainer.trainGeneration(this.entities);
        this.entities.sort(null);
        for(int i = 0; i < this.deathsPerGeneration; i++)
        {
            this.entities.remove(this.killSelector.selectIndex(this.entities));
        }
        
        List<E> newEntitiesTemp = new ArrayList<>();
        for(int i = this.entities.size(); i < this.entitiesInGeneration; i++)
        {
            if(this.mutationType == MutationType.SINGLE_PARENT)
                newEntitiesTemp.add(this.mutator.mutate(selectForBreeding()));
            else if(this.mutationType == MutationType.DOUBLE_PARENT)
                newEntitiesTemp.add(this.mutator.mutate(selectForBreeding(), selectForBreeding()));
        }
        this.entities.addAll(newEntitiesTemp);
    }
    
    private E selectForBreeding()
    {
        return this.breedingSelector.selectFrom(this.entities);
    }
    
    public static enum MutationType
    {
        SINGLE_PARENT, DOUBLE_PARENT
    }
}
