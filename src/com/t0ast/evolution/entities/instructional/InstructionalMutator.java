/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.entities.instructional;

import com.t0ast.evolution.entities.Mutator;
import com.t0ast.evolution.entities.instructional.instructions.Instruction;
import com.t0ast.evolution.misc.selectors.ListElementSelector;
import com.t0ast.evolution.misc.Utils;
import java.util.List;

/**
 *
 * @author T0astBread
 */
public class InstructionalMutator<E extends InstructionalEntity> implements Mutator<E>
{
    static final float SINGLE_ENTITY_MUTATION_SIZE = .2f;
    
    private InstructionGenerator generator;
    private ListElementSelector selector;
    
    // Mutate with 2 parents
    private final double weightA = 6;
    private final double weightB = 3;
    private final double weightRandom = 1;
    private final double disturbance = 2; // The value by which each weight could be changed by  + or - ;
    private final double instructionSizeDisturbance = 0.2; // By how much the instruction size is disturbed 0.2 = 20 %
    private final boolean absolute = true; // If absolutely x percent are taken from paren y, or  by chance
    private final boolean maintainSequence = true; // If original seqeuence in parent is maintained

    public InstructionalMutator(InstructionGenerator generator, ListElementSelector selector)
    {
        this.generator = generator;
        this.selector = selector;
    }
    
    
    @Override
    public E mutate(E entity)
    {
        entity = (E) entity.duplicate();
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
    

    @Override // a:b:r = 6:3:1 +-2
    public E mutate(E parent1, E parent2) // 70/30 split Instruction size von p1 * 0,3 *math.random  = removed instructions ->  (p1*0,7+p2*0,3)*2*math.random
    {
        System.out.println("Start");
        double a=weightA-disturbance+disturbance*Math.random()*2;
        double b=weightB-disturbance+disturbance*Math.random()*2;
        double r=weightRandom-disturbance+disturbance*Math.random()*2;
        if(a<0)a=0;if(b<0)b=0;if(r<0)r=0;
        if(Math.random()>0.5) // Each parent has 50 % chance to have weight a or b, respectively
        {
            double temp = a;
            a = b;
            b=temp;
        }
        
        int instructionSize = (parent1.getInstructionSize()+parent2.getInstructionSize())/2;
        instructionSize+=-instructionSize*instructionSizeDisturbance+instructionSize*instructionSizeDisturbance*2*Math.random();
        
        double sumWeight = a+b+r;
        int instrA =(int) (instructionSize*a/sumWeight); // How many instruction total a has 
        int instrB =(int) (instructionSize*b/sumWeight);
        int instrR =(int) (instructionSize*r/sumWeight);
        
        E entity = (E)parent1.duplicate();
        
        entity.getInstructions().clear();
        
       if(absolute&&maintainSequence)
       {
       List<Instruction> list= entity.getInstructions();
       List<Instruction> from=parent1.getInstructions();
           System.out.println("From A:"+from.size());
           System.out.println("To :"+list.size());
       
        for (int i = 0; i < instrA; i++) {
                    
            System.out.println("not stuck a");
            list.add(from.get(i%from.size()));     
        } 
        for (int i = instrA; i < (instrA+instrR); i++) {
            System.out.println("not stuck r");
            list.add(generator.getRandomInstruction());
        }
        from=parent2.getInstructions();
        System.out.println("From B:"+from.size());
        System.out.println("To :"+list.size());
        for (int i = instrA+instrR; i < (instrA+instrB+instrR); i++) {
                 
            System.out.println("not stuck b");
            list.add(from.get(i%from.size()));
        }
       }
       if(!absolute&&!maintainSequence)
       {
           
       }
        System.out.println("End");
        
        return entity;
    }
}
