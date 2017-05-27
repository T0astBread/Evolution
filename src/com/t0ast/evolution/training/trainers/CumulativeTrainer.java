/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.training.trainers;

import com.t0ast.evolution.entities.Entity;
import com.t0ast.evolution.training.FitnessRater;
import com.t0ast.evolution.training.TrainingResults;
import com.t0ast.evolution.training.trainers.environments.CumulativeTrainingEnvironment;
import java.util.List;

/**
 * Trains all entities at once
 * @author T0astBread
 */
public class CumulativeTrainer<E extends Entity, R extends TrainingResults> implements Trainer<E>
{
    private CumulativeTrainingEnvironment<E, R> environment;
    private FitnessRater<R> rater;

    public CumulativeTrainer(CumulativeTrainingEnvironment<E, R> environment, FitnessRater<R> rater)
    {
        this.environment = environment;
        this.rater = rater;
    }

    @Override
    public void trainGeneration(List<E> entities)
    {
        R[] results = this.environment.train(entities);
        if(results.length != entities.size()) throw new RuntimeException("The amount of results must match the amount of entities!");
        int i = 0;
        for(E entity : entities)
        {
            entity.setFitness(this.rater.rate(results[i++]));
        }
    }
}
