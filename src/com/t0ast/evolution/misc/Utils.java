/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.evolution.misc;

/**
 *
 * @author T0astBread
 */
public class Utils
{
    public static int clamp(int n, int max, int min)
    {
        if(n > max) n = max;
        else if(n < min) n = min;
        return n;
    }
}
