/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.entities.instructional;

import com.t0ast.evolution.entities.EntityGenerator;

/**
 *
 * @author T0astBread
 */
public class InstructionalEntityGenerator<E extends InstructionalEntity> implements EntityGenerator<E>
{

    private final E emptyEntity;
    private InstructionGenerator instructionGenerator;

    /**
     *
     * @param emptyEntity
     * @param instructionGenerator
     */
    public InstructionalEntityGenerator(E emptyEntity, InstructionGenerator instructionGenerator)
    {
        this.emptyEntity = emptyEntity;
        this.emptyEntity.getInstructions().clear();
        this.instructionGenerator = instructionGenerator;
    }

    @Override
    public E generateRandomEntity()
    {
        E entity = (E) this.emptyEntity.duplicate();
        int amountOfInstructions = (int) (Math.random() * entity.getMaxAmountOfInstructions());
        for(int i = 0; i < amountOfInstructions; i++)
        {
            entity.getInstructions().add(this.instructionGenerator.getRandomInstruction());
        }
        return entity;
    }

}
