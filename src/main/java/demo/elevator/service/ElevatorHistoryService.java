package demo.elevator.service;

import demo.elevator.jpa.model.ElevatorHistory;

/**
 * Service to support elevator history functionalities.
 * @author jzhang
 *
 */
public interface ElevatorHistoryService {

    /**
     * Returns all {@link ElevatorHistory}.
     * @return
     */
    Iterable<ElevatorHistory> findAllHistory();
}
