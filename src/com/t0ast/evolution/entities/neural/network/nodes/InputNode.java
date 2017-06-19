/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.entities.neural.network.nodes;

/**
 *
 * @author T0astBread
 */
public class InputNode extends NeuralNode
{
    @Override
    public int getMaxInPorts()
    {
        return 0;
    }

    @Override
    public int getMaxOutPorts()
    {
        return Integer.MAX_VALUE;
    }
}
