/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.training.trainers;

import com.t0ast.evolution.entities.Entity;
import java.util.List;

/**
 *
 * @author T0astBread
 */
public interface Trainer<E extends Entity>
{
    void trainGeneration(List<E> entities);
}
