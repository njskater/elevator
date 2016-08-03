package demo.elevator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.elevator.jpa.ElevatorHistoryRepository;
import demo.elevator.jpa.model.ElevatorHistory;

@Service
public class ElevatorHistoryServiceImpl implements ElevatorHistoryService {
    @Autowired
    private ElevatorHistoryRepository elevatorHistoryRepository;

    @Override
    public Iterable<ElevatorHistory> findAllHistory() {
        return elevatorHistoryRepository.findAll();
    }

}
