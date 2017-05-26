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
public interface Instruction
{

    /**
     *
     * @return itself for method chaining
     */
    Instruction randomizeValue();
    
    /**
     * Returns this instruction's name (f.ex. "MOVE")
     * @return 
     */
    String getInstructionName();
    
    /**
     * Returns a String representation of this instruction (f.ex. "MOVE 3")
     * @return 
     */
    String getInstructionString();
}
