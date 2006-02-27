/*
 * MaximumDeratingFunction1.java
 *
 * Created on June 24, 2003, 2:09 PM
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

public class MaximumDeratingFunction1 extends Function {
    private double radius = 0.25;
    private double alpha = 2.0;
    public static final int DEFAULT_DIMENSION = 1;
    public static final Domain DEFAULT_DOMAIN =
        new Domain(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);

    public MaximumDeratingFunction1() {
        super(DEFAULT_DIMENSION, DEFAULT_DOMAIN, 0, Double.MAX_VALUE);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getAlpha() {
        return alpha;
    }

    public double evaluate(double[] parm1) {
        // the derating function is only to be used with Derating Function Problem
        // if the this class is misused, then prcocess will exit inorder to prevent
        // errorneous results.
        if (parm1.length > 1) {
            throw new RuntimeException("derating function may only be used in one dimension");
        }

        if (parm1[0] >= radius) {
            return 1.0;
        }
        else {
            return Math.pow(parm1[0] / radius, alpha);
        }
    }
}
