/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.training;

import com.t0ast.evolution.training.TrainingResults;

/**
 *
 * @author T0astBread
 * @param <R> the type of results to rate
 */
public interface FitnessRater<R extends TrainingResults>
{
    float rate(R results);
}
