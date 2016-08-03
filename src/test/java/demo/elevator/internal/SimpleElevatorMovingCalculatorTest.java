package demo.elevator.internal;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import demo.elevator.model.Elevator;
import demo.elevator.model.ElevatorMovingCommand;
import demo.elevator.model.ElevatorUserCommand;
import static org.junit.Assert.assertEquals;

/**
 * SimpleElevatorMovingCalculator Unit Test.
 * @author jzhang
 */
public class SimpleElevatorMovingCalculatorTest {

    private ElevatorMovingCalculator calculator;
    private Elevator elevatorA;
    private Elevator elevatorB;
    private Elevator elevatorC;
    private Elevator elevatorD;

    @Before
    public void setup() {
        elevatorA = new Elevator("A");
        elevatorB = new Elevator("B");
        elevatorC = new Elevator("C");
        elevatorD = new Elevator("D");

        calculator = new SimpleElevatorMovingCalculator(Arrays.asList(elevatorA, elevatorB, elevatorC, elevatorD));
    }

    /**
     * Test when all elevators on level 1 and 1 person on floor 1 want to go to floor 5.
     * Expecting the first elevator(elevator A) get this job.
     */
    @Test
    public void testAllElevatorsOnLevel1() {
        final ElevatorUserCommand command = new ElevatorUserCommand(1, 5, 1);
        final ElevatorMovingCommand movingStrategy = calculator.getMovingStrategy(command);
        assertEquals(elevatorA.getId(), movingStrategy.getElevatorId());
    }

    @Test
    public void testNearestElevatorHasCapacity() {
        //Elevator Status
        elevatorA.moveTo(10);
        elevatorB.moveTo(7);
        elevatorC.moveTo(4);
        elevatorD.moveTo(2);

        //There is 1 person on floor 6 want to go to floor 5
        final ElevatorUserCommand command = new ElevatorUserCommand(6, 5, 1);
        final ElevatorMovingCommand movingStrategy = calculator.getMovingStrategy(command);
        assertEquals(elevatorB.getId(), movingStrategy.getElevatorId());

    }

    @Test
    public void testNearestElevatorHasNoCapacity() {
        //Elevator Status
        elevatorA.moveTo(10);
        elevatorB.moveTo(7);
        elevatorB.loadPassenger(15);
        elevatorC.moveTo(4);
        elevatorD.moveTo(2);

        //There is 1 person on floor 6 want to go to floor 5
        final ElevatorUserCommand command = new ElevatorUserCommand(6, 5, 10);
        final ElevatorMovingCommand movingStrategy = calculator.getMovingStrategy(command);
        assertEquals(elevatorC.getId(), movingStrategy.getElevatorId());

    }

    @Test
    public void testNoAvailableElevator() {
        //Elevator Status
        elevatorA.moveTo(10);
        elevatorA.loadPassenger(15);

        elevatorB.moveTo(7);
        elevatorB.loadPassenger(15);

        elevatorC.moveTo(4);
        elevatorC.loadPassenger(15);

        elevatorD.moveTo(2);
        elevatorD.loadPassenger(15);


        //There is 1 person on floor 6 want to go to floor 5
        final ElevatorUserCommand command = new ElevatorUserCommand(6, 5, 10);
        final ElevatorMovingCommand movingStrategy = calculator.getMovingStrategy(command);
        Assert.assertNull(movingStrategy);

    }

}
