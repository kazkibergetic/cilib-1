/*
 * EpistaticMichalewicz.java
 *
 * Created on June 4, 2003, 5:14 PM
 *
 * 
 * Copyright (C) 2003, 2004 - CIRG@UP 
 * Computational Intelligence Research Group (CIRG@UP)
 * Department of Computer Science 
 * University of Pretoria
 * South Africa
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA 
 *   
 */

package net.sourceforge.cilib.Functions;

import net.sourceforge.cilib.Problem.Domain;

/**
 *
 * @author  engel
 */
public class EpistaticMichalewicz extends Function {
    
    public static final int DEFAULT_DIMENSION = 10;
    public static final Domain DEFAULT_DOMAIN = new Domain(0,Math.PI);
    
    /** Creates a new instance of EpistaticMichalewicz */
    public EpistaticMichalewicz() {
        // what is the minimum of this function?
        super(DEFAULT_DIMENSION, DEFAULT_DOMAIN, -Double.MAX_VALUE, Double.MAX_VALUE); 
        m = 10;
    }
    
    /** Each function must provide an implementation which returns the function value
     * at the given position. The length of the position array should be the same
     * as the function dimension.
     *
     * @param x The position
     *
     */
    public double evaluate(double[] x) {
        double sum = 0;
        
        double cosTerm = Math.cos(Math.PI/6);
        double sinTerm = Math.sin(Math.PI/6);
        
        for (int i = 0; i < dimension; ++i) {
            double y;
            if ( (i % 2) == 0) {
                y = x[i] * cosTerm - x[i+1] * sinTerm;
            }
            else if (i  == (dimension - 1)) {
                y = x[dimension - 1];                
            }
            else {
                y = x[i-1] * sinTerm + x[i] * cosTerm;
            }
            sum += Math.sin(y) * Math.pow(Math.sin((i+1) * y * y / Math.PI), 2 * m);
        }
        return -sum;               
    }
    
    public int getM() {
        return m;
    }
    
    public void setM(int m) {
        this.m = m;
    }
    
    private int m;
}
