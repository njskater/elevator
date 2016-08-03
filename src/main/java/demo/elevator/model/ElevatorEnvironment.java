package demo.elevator.model;

import java.util.List;

/**
 * Represents an environment that consists of a list of elevators.
 * @author jzhang
 *
 */
public interface ElevatorEnvironment {

    /**
     * Get a list of elevators in this environment.
     * @return
     */
    List<Elevator> getElevators();

    /**
     * Get an elevator by its ID from this environment.
     * @param id
     * @return
     */
    Elevator getElevatorById(String id);

}
