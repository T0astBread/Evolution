/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.entities.instructional;

import com.t0ast.evolution.entities.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T0astBread
 */
public class InstructionalEntity extends Entity
{
    private List<Instruction> instructions;
    private int maxAmountOfInstructions;

    public InstructionalEntity()
    {
        this.instructions = new ArrayList<>();
    }

    public List<Instruction> getInstructions()
    {
        return instructions;
    }
    
    public int getInstructionSize()
    {
        return this.instructions.size();
    }

    public int getMaxAmountOfInstructions()
    {
        return maxAmountOfInstructions;
    }

    public void setMaxAmountOfInstructions(int maxAmountOfInstructions)
    {
        this.maxAmountOfInstructions = maxAmountOfInstructions;
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder(super.toString());
        this.instructions.forEach(i ->
        {
            s.append(i.getInstructionString()).append("\n");
        });
        return s.toString();
    }
}
