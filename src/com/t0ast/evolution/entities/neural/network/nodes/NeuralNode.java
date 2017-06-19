/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.entities.neural.network.nodes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T0astBread
 */
public abstract class NeuralNode
{
    protected List<NeuralNode> in, out;
    protected double value;

    public NeuralNode()
    {
        this.in = new ArrayList<>();
        this.out = new ArrayList<>();
    }
    
    public abstract int getMaxInPorts();
    public abstract int getMaxOutPorts();
    
    public boolean addInput(NeuralNode in)
    {
        return isInputsFull() ? false : this.in.add(in);
    }
    
    public boolean addOutput(NeuralNode out)
    {
        return isOutputsFull() ? false : this.out.add(out);
    }
    
    public boolean setInput(int index, NeuralNode in)
    {
        return setInPorts(this.in, index, in);
    }
    
    public boolean setOutput(int index, NeuralNode out)
    {
        return setInPorts(this.out, index, out);
    }
    
    private boolean setInPorts(List<NeuralNode> ports, int index, NeuralNode node)
    {
        if(index >= ports.size()) return false;
        ports.set(index, node);
        return true;
    }
    
    public boolean isInputsFull()
    {
        return this.in.size() >= getMaxInPorts();
    }
    
    public boolean isOutputsFull()
    {
        return this.out.size() >= getMaxOutPorts();
    }

    public List<NeuralNode> getIn()
    {
        return in;
    }

    public List<NeuralNode> getOut()
    {
        return out;
    }
}
