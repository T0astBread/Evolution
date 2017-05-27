/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.training.trainers;

import com.t0ast.evolution.entities.Entity;
import com.t0ast.evolution.training.FitnessRater;
import com.t0ast.evolution.training.TrainingResults;
import java.util.List;
import com.t0ast.evolution.training.trainers.environments.IndividualTrainingEnvironment;

/**
 * Trains one entity and the moves to the next
 * @author T0astBread
 */
public class IndividualTrainer<E extends Entity, R extends TrainingResults> implements Trainer<E>
{
    private IndividualTrainingEnvironment<E, R> environment;
    private FitnessRater<R> rater;

    public IndividualTrainer(IndividualTrainingEnvironment<E, R> environment, FitnessRater<R> rater)
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
    
    @Override
    public void trainGeneration(List<E> entities)
    {
        entities.forEach(this::train);
    }
}
