package demo.elevator.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.elevator.internal.ElevatorMovingCalculator;
import demo.elevator.internal.SimpleElevatorMovingCalculator;
import demo.elevator.jpa.ElevatorHistoryRepository;
import demo.elevator.jpa.model.ElevatorHistory;
import demo.elevator.model.DemoElevatorEnvironment;
import demo.elevator.model.Elevator;
import demo.elevator.model.ElevatorEnvironment;
import demo.elevator.model.ElevatorMovingCommand;
import demo.elevator.model.ElevatorUserCommand;

/**
 * This class controls elevator environment and is responsible for sending command to elevator.
 * @author jzhang
 *
 */
@Service
public class ElevatorServiceImpl implements ElevatorService {
    private static final Log LOGGER = LogFactory.getLog(ElevatorServiceImpl.class);

    private final ElevatorEnvironment elevatorEnvironment;

    private final ElevatorMovingCalculator calculator;

    @Autowired
    private ElevatorHistoryRepository elevatorHistoryRepo;


    public ElevatorServiceImpl() {
        elevatorEnvironment = new DemoElevatorEnvironment();
        calculator = new SimpleElevatorMovingCalculator(elevatorEnvironment.getElevators());
    }


    @Override
    public void takeCommand(ElevatorUserCommand command) {
        final ElevatorMovingCommand movingStrategy = this.calculator.getMovingStrategy(command);
        LOGGER.info("Got moving Strategy:" + movingStrategy);

        if (movingStrategy == null) {
            return; //In case no available elevator.
        }

        final Elevator targetElevator = this.elevatorEnvironment.getElevatorById(movingStrategy.getElevatorId());
        int previousLevel = targetElevator.getCurrentLevel();
        int previousPassengerNumber = targetElevator.getCurrentPassengerNumber();

        targetElevator.moveTo(movingStrategy.getSourceLevel());
        targetElevator.loadPassenger(movingStrategy.getPassengerNumber());
        createHistory(targetElevator.getId(), previousLevel, targetElevator.getCurrentLevel(), previousPassengerNumber);

        previousLevel = targetElevator.getCurrentLevel();
        previousPassengerNumber = targetElevator.getCurrentPassengerNumber();

        targetElevator.moveTo(movingStrategy.getDestLevel());
        targetElevator.unloadPassenger(movingStrategy.getPassengerNumber());
        createHistory(targetElevator.getId(), previousLevel, targetElevator.getCurrentLevel(), previousPassengerNumber);

    }

    /**
     * Create and save an elevator history entry.
     * @param elevatorId
     * @param fromLevel
     * @param toLevel
     * @param passengerNumber
     */
    private void createHistory(String elevatorId, int fromLevel, int toLevel, int passengerNumber) {
        final ElevatorHistory elevatorHistory = ElevatorHistory.create(elevatorId,
                fromLevel, toLevel, passengerNumber);
        elevatorHistoryRepo.save(elevatorHistory);

    }
}
