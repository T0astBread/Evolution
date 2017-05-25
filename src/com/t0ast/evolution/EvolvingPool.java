/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution;

import com.t0ast.evolution.entities.Entity;
import com.t0ast.evolution.entities.Mutator;
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
    
    public void nextGen()
    {
        
    }
}
