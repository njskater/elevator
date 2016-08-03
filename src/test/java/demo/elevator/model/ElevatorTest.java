package demo.elevator.model;
import org.junit.Test;

import demo.elevator.model.Elevator.MovingStatus;
import static org.junit.Assert.assertEquals;

/**
 * Elevator Model unit test.
 * @author jzhang
 */
public class ElevatorTest {

    @Test
    public void testElevatorInitialisation() {
        final String testId = "A";
        final Elevator elevatorA = new Elevator(testId);

        assertEquals(Elevator.DEFAULT_MAX_CAPACITY, elevatorA.getCapacity());
        assertEquals(Elevator.DEFAULT_MAX_CAPACITY, elevatorA.getCurrentCapacity());
        assertEquals(Elevator.DEFAULT_MIN_LEVEL, elevatorA.getCurrentLevel());
        assertEquals(0, elevatorA.getCurrentPassengerNumber());
        assertEquals(MovingStatus.STATIONARY, elevatorA.getCurrentStatus());
        assertEquals(testId, elevatorA.getId());
    }

    @Test
    public void testValidMoveTo() {
        final int destLevel = 4;

        final Elevator elevatorA = new Elevator("A");
        elevatorA.moveTo(destLevel);

        assertEquals(MovingStatus.UP, elevatorA.getCurrentStatus());
        assertEquals(destLevel, elevatorA.getCurrentLevel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMoveToLessThanMinLevel() {
        final Elevator elevatorA = new Elevator("A");
        elevatorA.moveTo(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMoveToGreterThanMaxLevel() {
        final Elevator elevatorA = new Elevator("A");
        elevatorA.moveTo(11);
    }

    @Test
    public void testLoadPassenger() {
        final int testPassengerNumber = 12;
        final Elevator elevatorA = new Elevator("A");
        final int result = elevatorA.loadPassenger(testPassengerNumber);

        assertEquals(0, result);
        assertEquals(testPassengerNumber, elevatorA.getCurrentPassengerNumber());
        assertEquals(elevatorA.getCapacity() - testPassengerNumber, elevatorA.getCurrentCapacity());
        assertEquals(MovingStatus.STATIONARY, elevatorA.getCurrentStatus());
    }

    @Test
    public void testLoadMoreThanMaxPassenger() {
        final int testPassengerNumber = 22;
        final Elevator elevatorA = new Elevator("A");
        final int result = elevatorA.loadPassenger(testPassengerNumber);

        assertEquals(2, result);
        assertEquals(elevatorA.getCapacity(), elevatorA.getCurrentPassengerNumber());
        assertEquals(0, elevatorA.getCurrentCapacity());
        assertEquals(MovingStatus.STATIONARY, elevatorA.getCurrentStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoadInvalidPassengerNumber() {
        final Elevator elevatorA = new Elevator("A");
        elevatorA.loadPassenger(-4);
    }

    @Test
    public void testUnloadPassenger() {
        final Elevator elevatorA = new Elevator("A");
        elevatorA.loadPassenger(10);
        elevatorA.unloadPassenger(5);
        assertEquals(5, elevatorA.getCurrentPassengerNumber());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnloadInvalidPassengerLessThanZero() {
        final Elevator elevatorA = new Elevator("A");
        elevatorA.loadPassenger(10);
        elevatorA.unloadPassenger(-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnloadInvalidPassengerMoreThanCurrent() {
        final Elevator elevatorA = new Elevator("A");
        elevatorA.loadPassenger(10);
        elevatorA.unloadPassenger(12);
    }
}
