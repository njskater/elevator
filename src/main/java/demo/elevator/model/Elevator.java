package demo.elevator.model;

import static demo.elevator.model.Elevator.MovingStatus.DOWN;
import static demo.elevator.model.Elevator.MovingStatus.STATIONARY;
import static demo.elevator.model.Elevator.MovingStatus.UP;

/**
 * Entity Model to represent an elevator.
 * @author jzhang
 */
public class Elevator {

    public static final int DEFAULT_MAX_CAPACITY = 20;
    public static final int DEFAULT_MIN_LEVEL = 1;
    public static final int DEFAULT_MAX_LEVEL = 10;

    public enum MovingStatus {
        UP, DOWN, STATIONARY
    }

    private final int capacity;
    private final String id;
    private final int minLevel;
    private final int maxLevel;
    private MovingStatus currentStatus;
    private int currentLevel;
    private int currentPassengerNumber;

    /**
     * Construct an Elevator object using Default settings.
     * @param id a String identifier for this elevator.
     */
    public Elevator(String id) {
        this(id, DEFAULT_MAX_CAPACITY, DEFAULT_MIN_LEVEL, DEFAULT_MAX_LEVEL);
    }

    /**
     * Construct an Elevator using given settings.
     * @param id a String identifier for this elevator.
     * @param capacity max capacity of this elevator.
     * @param minLevel minimum level that this elevator can operate on.
     * @param maxLevel maximum level that this elevator can operate on.
     */
    public Elevator(String id, int capacity, int minLevel, int maxLevel) {
        this.id = id;
        this.capacity = capacity;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.currentStatus = STATIONARY;
        this.currentLevel = 1;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getId() {
        return id;
    }

    public MovingStatus getCurrentStatus() {
        return currentStatus;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public int getCurrentPassengerNumber() {
        return currentPassengerNumber;
    }

    public int getCurrentCapacity() {
        return capacity - currentPassengerNumber;
    }

    /**
     * Instruct elevator to move to given level.
     * @param level
     */
    public void moveTo(int level) {
        if (level < this.minLevel || level > this.maxLevel) {
            throw new IllegalArgumentException("Invalid Destination");
        }

        final int delta = level - currentLevel;
        if (delta > 0) {
            this.currentStatus = UP;
        } else if (delta < 0) {
            this.currentStatus = DOWN;
        } else {
            this.currentStatus = STATIONARY;
        }
        this.currentLevel = level;
    }

    /**
     * Instruct elevator to load given number of passengers.
     * @param passengerNumber number of passengers to be loaded.
     * @return remaining passenger if can't take all passengers. Returns 0 if all passengers can be loaded.
     */
    public int loadPassenger(int passengerNumber) {
        if (passengerNumber < 0) {
            throw new IllegalArgumentException("Passenger Number must be positive number");
        }
        this.currentStatus = STATIONARY;
        if (passengerNumber > this.getCurrentCapacity()) {
            final int remaining = passengerNumber - this.getCurrentCapacity();
            this.currentPassengerNumber = this.getCapacity();
            return remaining;
        }

        this.currentPassengerNumber += passengerNumber;
        return 0;
    }

    /**
     * Instruct elevator to upload given number of passengers.
     * @param passengerNumber number of passengers to be unloaded.
     */
    public void unloadPassenger(int passengerNumber) {
        if (passengerNumber < 0 || passengerNumber > this.getCurrentPassengerNumber()) {
            throw new IllegalArgumentException(
                    "Passenger Number must be positive and less than current passenger number");
        }
        this.currentStatus = STATIONARY;
        this.currentPassengerNumber -= passengerNumber;
    }

}
