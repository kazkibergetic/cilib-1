/**           __  __
 *    _____ _/ /_/ /_    Computational Intelligence Library (CIlib)
 *   / ___/ / / / __ \   (c) CIRG @ UP
 *  / /__/ / / / /_/ /   http://cilib.net
 *  \___/_/_/_/_.___/
 */
package net.sourceforge.cilib.pso.dynamic.detectionstrategies;

import net.sourceforge.cilib.algorithm.Algorithm;
import net.sourceforge.cilib.algorithm.population.HasNeighbourhood;
import net.sourceforge.cilib.algorithm.population.HasTopology;
import net.sourceforge.cilib.stoppingcondition.MeasuredStoppingCondition;
import net.sourceforge.cilib.stoppingcondition.StoppingCondition;

/**
 * Uses a stopping condition to trigger response strategies.
 * Once it triggers, the stopping condition is reset to its original state.
 */
public class StoppingConditionDetectionStrategy extends EnvironmentChangeDetectionStrategy {
    StoppingCondition originalStoppingCondition;
    StoppingCondition stoppingCondition;

    public StoppingConditionDetectionStrategy() {
        originalStoppingCondition = new MeasuredStoppingCondition();
        stoppingCondition = originalStoppingCondition.getClone();
    }

    public StoppingConditionDetectionStrategy(StoppingConditionDetectionStrategy rhs) {
        super(rhs);
        originalStoppingCondition = rhs.originalStoppingCondition.getClone();
        stoppingCondition = rhs.originalStoppingCondition.getClone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StoppingConditionDetectionStrategy getClone() {
        return new StoppingConditionDetectionStrategy(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <A extends HasTopology & Algorithm & HasNeighbourhood> boolean detect(A algorithm) {
        if (stoppingCondition.f(algorithm)) {
            stoppingCondition = originalStoppingCondition.getClone();
            return true;
        }
        else
            return false;
    }

    /**
     * Sets the stopping condition.
     * @param stoppingCondition The stopping condition.
     */
    public void setStoppingCondition(StoppingCondition stoppingCondition) {
        originalStoppingCondition = stoppingCondition;
        this.stoppingCondition = originalStoppingCondition.getClone();
    }
}
