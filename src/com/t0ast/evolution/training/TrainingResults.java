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
public abstract class TrainingResults
{
    private Entity entity;

    public TrainingResults(Entity entity)
    {
        this.entity = entity;
    }

    public Entity getEntity()
    {
        return entity;
    }
}
