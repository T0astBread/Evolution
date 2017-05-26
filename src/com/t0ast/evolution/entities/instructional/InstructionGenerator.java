/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.entities.instructional;

import com.t0ast.evolution.entities.instructional.instructions.Instruction;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public Instruction getRandomInstruction()
    {
        try
        {
            return getRandomClass().newInstance().randomizeValue();
        }
        catch(ReflectiveOperationException ex)
        {
            Logger.getLogger(InstructionGenerator.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
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
