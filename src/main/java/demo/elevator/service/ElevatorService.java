package demo.elevator.service;

import demo.elevator.model.ElevatorUserCommand;

/**
 * Class implements this interface should provide functionality to
 * making elevators take an {@link ElevatorUserCommand}.
 * @author jzhang
 *
 */
public interface ElevatorService {

    /**
     * Make elevators take an {@link ElevatorUserCommand}.
     * @param command user command send to elevators
     */
    void takeCommand(ElevatorUserCommand command);


}
