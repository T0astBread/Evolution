/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.entities.instructional;

import com.t0ast.evolution.entities.Entity;
import com.t0ast.evolution.entities.EntityGenerator;

/**
 *
 * @author T0astBread
 */
public class InstructionalEntityGenerator implements EntityGenerator
{
    private InstructionGenerator instructionGenerator;

    @Override
    public Entity generateRandomEntity()
    {
        InstructionalEntity entity = new InstructionalEntity();
        int amountOfInstructions = (int) (Math.random() * entity.getMaxAmountOfInstructions());
        for(int i = 0; i < amountOfInstructions; i++)
        {
            try
            {
                entity.getInstructions().add(this.instructionGenerator.getRandomInstruction());
            }
            catch(ReflectiveOperationException ex)
            {
                throw new RuntimeException(ex);
            }
        }
        return entity;
    }
    
}
