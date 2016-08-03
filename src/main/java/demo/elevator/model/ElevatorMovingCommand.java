package demo.elevator.model;

/**
 * This POJO class represents a command send to elevator to make it move towards certain level and
 * taking certain number of passenger.
 * @author jzhang
 */
public class ElevatorMovingCommand {

    private final String elevatorId;
    private final int destLevel;
    private final int sourceLevel;
    private final int passengerNumber;

    public ElevatorMovingCommand(String elevatorId, int sourceLevel, int destLevel, int passengerNumber) {
        this.elevatorId = elevatorId;
        this.sourceLevel = sourceLevel;
        this.destLevel = destLevel;
        this.passengerNumber = passengerNumber;
    }

    public String getElevatorId() {
        return elevatorId;
    }

    public int getSourceLevel() {
        return sourceLevel;
    }

    public int getDestLevel() {
        return destLevel;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    @Override
    public String toString() {
        return "ElevatorMovingCommand [elevatorId=" + elevatorId + ", destLevel=" + destLevel + ", sourceLevel=" + sourceLevel + ", passengerNumber="
                + passengerNumber + "]";
    }


}
