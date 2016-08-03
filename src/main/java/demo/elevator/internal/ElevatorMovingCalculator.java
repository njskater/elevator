package demo.elevator.internal;

import demo.elevator.model.ElevatorMovingCommand;
import demo.elevator.model.ElevatorUserCommand;

/**
 * The class that implement this interface shall provide an algorithm to instruct elevator's movement.
 * @author jzhang
 *
 */
public interface ElevatorMovingCalculator {

    /**
     * Get a moving strategy from given {@link ElevatorUserCommand}.
     * @param command
     * @return an elevator moving strategy.
     */
    ElevatorMovingCommand getMovingStrategy(ElevatorUserCommand command);


}
