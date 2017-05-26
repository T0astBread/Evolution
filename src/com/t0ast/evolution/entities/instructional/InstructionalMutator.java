/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.entities.instructional;

import com.t0ast.evolution.entities.Mutator;
import com.t0ast.evolution.misc.ListElementSelector;
import com.t0ast.evolution.misc.Utils;

/**
 *
 * @author T0astBread
 */
public class InstructionalMutator<E extends InstructionalEntity> implements Mutator<E>
{
    static final float SINGLE_ENTITY_MUTATION_SIZE = .2f;
    
    private InstructionGenerator generator;
    private ListElementSelector selector;
    
    @Override
    public E mutate(E entity)
    {
        entity = (E) entity.clone();
        int inst = entity.getInstructionSize(), newInstructionSize = Utils.clamp(inst + getDeltaInstructionSize(inst), entity.getMaxAmountOfInstructions(), 0);
        while(entity.getInstructionSize() != newInstructionSize) //Remove or add new instructions
        {
            int randIndex = this.selector.selectIndex(entity.getInstructions());
            if(entity.getInstructionSize() < newInstructionSize)
            {
                entity.getInstructions().add(randIndex, this.generator.getRandomInstruction());
            }
            else
            {
                entity.getInstructions().remove(randIndex);
            }
        }
        while(Math.random() < .75f && entity.getInstructionSize() > 0) //Change existing instructions
        {
            int randIndex = this.selector.selectIndex(entity.getInstructions());
            entity.getInstructions().remove(randIndex);
            entity.getInstructions().add(randIndex, this.generator.getRandomInstruction());
        }
        return entity;
    }
    
    private int getDeltaInstructionSize(int origInstructionSize)
    {
        return (int) (Math.random() * SINGLE_ENTITY_MUTATION_SIZE * origInstructionSize * Math.random() > .5f ? -1 : 1);
    }

    @Override
    public E mutate(E parent1, E parent2)
    {
        throw new UnsupportedOperationException(); //TODO: Implement double parent mutation for instructional entities
    }
}
