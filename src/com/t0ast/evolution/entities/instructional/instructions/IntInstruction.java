/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.entities.instructional.instructions;

/**
 *
 * @author T0astBread
 */
public abstract class IntInstruction implements Instruction
{
    private final int MAX_VALUE;
    private final String INSTRUCTION_NAME;
    private int value;

    public IntInstruction(int MAX_VALUE, String INSTRUCTION_NAME)
    {
        this.MAX_VALUE = MAX_VALUE;
        this.INSTRUCTION_NAME = INSTRUCTION_NAME;
    }

    @Override
    public Instruction randomizeValue()
    {
        this.value = (int) (Math.random() * this.MAX_VALUE);
        return this;
    }

    public int getValue()
    {
        return value;
    }

    @Override
    public String getInstructionName()
    {
        return this.INSTRUCTION_NAME;
    }

    @Override
    public String getInstructionString()
    {
        return this.INSTRUCTION_NAME + " " + this.value;
    }
}
