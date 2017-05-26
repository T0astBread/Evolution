/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.training;

import com.t0ast.evolution.entities.Entity;
import java.util.List;

/**
 *
 * @author T0astBread
 */
public class Trainer<E extends Entity, R extends TrainingResults>
{
    private TrainingEnvironment<E, R> environment;
    private FitnessRater<R> rater;

    public Trainer(TrainingEnvironment<E, R> environment, FitnessRater<R> rater)
    {
        this.environment = environment;
        this.rater = rater;
    }
    
    public void train(E entity)
    {
        if(entity.isTested()) return;
        R result = this.environment.train(entity);
        float fitness = this.rater.rate(result);
        entity.setFitness(fitness);
        entity.setTested(true);
    }
    
    public void trainGeneration(List<E> entities)
    {
        entities.forEach(this::train);
    }
}
