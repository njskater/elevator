package demo.elevator.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import demo.elevator.jpa.model.ElevatorHistory;

/**
 * Spring data repository for elevator history data CRUD.
 * @author jzhang
 *
 */
public interface ElevatorHistoryRepository extends CrudRepository<ElevatorHistory, Long> {

    Page<ElevatorHistory> findAll(Pageable pageable);

    Page<ElevatorHistory> findByElevatorId(Pageable pageable);
}
