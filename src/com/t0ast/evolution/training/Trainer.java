/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.training;

import com.t0ast.evolution.entities.Entity;

/**
 *
 * @author T0astBread
 */
public class Trainer<E extends Entity, R extends TrainingResults>
{
    private TrainingEnvironment<E, R> environment;
}
