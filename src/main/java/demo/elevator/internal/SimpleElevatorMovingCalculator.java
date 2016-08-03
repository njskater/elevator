package demo.elevator.internal;

import java.util.List;

import demo.elevator.model.Elevator;
import demo.elevator.model.ElevatorMovingCommand;
import demo.elevator.model.ElevatorUserCommand;

/**
 * This is a simple algorithm based on specification,
 * i.e. people on a certain floor should get nearest available elevator.
 * Assumption: available elevator means elevator that can take all people on certain floor.
 * @author jzhang
 *
 */
public class SimpleElevatorMovingCalculator implements ElevatorMovingCalculator {
    private final List<Elevator> elevators;


    public SimpleElevatorMovingCalculator(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    /**
     * Calculate moving strategy.
     * @see ElevatorMovingCalculator#getMovingStrategy(ElevatorUserCommand).
     */
    @Override
    public ElevatorMovingCommand getMovingStrategy(ElevatorUserCommand command) {
        final int currentLevel = command.getCurrentLevel();
        final int destLevel = command.getDestLevel();
        final int passengerNumber = command.getPassengerNumber();

        final String nearestElevatorId = getNearestAvailableElevator(currentLevel, passengerNumber);
        return nearestElevatorId == null ?
                null : new ElevatorMovingCommand(nearestElevatorId, currentLevel, destLevel, passengerNumber);
    }

    /**
     * Get nearest available elevator
     * @param currentLevel
     * @param passengerNumber
     * @return ID of the elevator or null if no elevator is available.
     */
    private String getNearestAvailableElevator(int currentLevel, int passengerNumber) {
        int nearest = -1;
        String nearestElevator = null;
        for (final Elevator elevator : elevators) {
            final int currentDistance = Math.abs(elevator.getCurrentLevel() - currentLevel);
            if ((nearest == -1 || currentDistance < nearest) && elevator.getCurrentCapacity() >= passengerNumber) {
                nearest = currentDistance;
                nearestElevator = elevator.getId();
            }
        }
        return nearestElevator;
    }

}
