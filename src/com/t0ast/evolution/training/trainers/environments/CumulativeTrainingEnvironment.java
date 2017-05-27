/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.training.trainers.environments;

import com.t0ast.evolution.entities.Entity;
import com.t0ast.evolution.training.TrainingResults;
import java.util.List;

/**
 *
 * @author T0astBread
 */
public interface CumulativeTrainingEnvironment<E extends Entity, R extends TrainingResults>
{
    R[] train(List<E> entities);
}
