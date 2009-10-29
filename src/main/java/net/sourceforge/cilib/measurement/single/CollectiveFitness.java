/**
 * Copyright (C) 2003 - 2009
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
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sourceforge.cilib.measurement.single;

import net.sourceforge.cilib.algorithm.Algorithm;
import net.sourceforge.cilib.algorithm.population.PopulationBasedAlgorithm;
import net.sourceforge.cilib.entity.Entity;
import net.sourceforge.cilib.measurement.Measurement;
import net.sourceforge.cilib.type.types.Real;

/**
 *
 * @author gpampara
 */
public class CollectiveFitness implements Measurement<Real> {
    private static final long serialVersionUID = 6171032748690594619L;

    @Override
    public Measurement getClone() {
        return this;
    }

    @Override
    public String getDomain() {
        return "R";
    }

    @Override
    public Real getValue(Algorithm algorithm) {
        PopulationBasedAlgorithm pba = (PopulationBasedAlgorithm) algorithm;

        double collectiveFitness = 0.0;
        for (Entity e : pba.getTopology()) {
            collectiveFitness += e.getFitness().getValue();
        }

        return new Real(collectiveFitness);
    }

}
