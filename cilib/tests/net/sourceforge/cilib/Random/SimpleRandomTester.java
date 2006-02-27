/*
 * SimpleRandomTester.java
 *
 * Created on January 21, 2003, 6:45 PM
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

package net.sourceforge.cilib.Random;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * TODO: This random number tester is extremely primitive. We need to implement something like the die-hard test suite to test for simulation quality. 
 * 
 * @author  espeer
 */
public class SimpleRandomTester implements RandomTester {
    
    /** Creates a new instance of SimpleRandomTester */
    public SimpleRandomTester() {
        samples = new ArrayList();
    }
    
    public boolean hasRandomSamples() {
        int l = 1;
        int n1 = 0;
        int n2 = 0;
        
        Iterator i = samples.iterator();
        double previous = ((Double) i.next()).doubleValue();
        if (previous >= 0.5) {
            ++n1;
        }
        else {
            ++n2;
        }
        double current;
        while (i.hasNext()) {
            current = ((Double) i.next()).doubleValue();
            if (current >= 0.5) {
                ++n1;
                if (previous < 0.5) {
                    ++l;
                }
            }
            else {
                ++n2;
                if (previous >= 0.5) {
                    ++l;
                }
            }
            previous = current;
        }
        
        if (n1 == 0 || n2 == 0) {
            return false;
        }
        
        double u = ((double) 2 * n1 * n2) / ((double) n1 + n2) + 1;
        double s = ((double) 2 * n1 * n2 * (2 * n1 * n2 - n1 - n2))
                 / ((double) (n1 + n2) * (n1 + n2) * (n1 + n2 - 1));
        double z = ((double) l - u) / s;
        
        if (z <= -2.5796 || z >= 2.5796) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public void addSample(double number) {
        samples.add(new Double(number));
    }

    private ArrayList samples;
}
