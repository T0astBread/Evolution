/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.entities.instructional;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author T0astBread
 */
public class InstructionGenerator
{
    public Set<Class<? extends Instruction>> instructionClasses;

    public InstructionGenerator()
    {
        this.instructionClasses = new HashSet<>();
    }
    
    public <T extends Instruction> void registerInstruction(Class<T> clazz)
    {
        this.instructionClasses.add(clazz);
    }
    
    public Instruction getRandomInstruction() throws ReflectiveOperationException
    {
        return getRandomClass().newInstance().randomizeValue();
    }
    
    private Class<? extends Instruction> getRandomClass()
    {
        int index = (int) (Math.random() * this.instructionClasses.size()), i = 0;
        for(Class<? extends Instruction> clazz : instructionClasses)
        {
            if(i == index) return clazz;
            i++;
        }
        return null;
    }
}
