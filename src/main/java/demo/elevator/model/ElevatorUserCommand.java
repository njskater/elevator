package demo.elevator.model;


/**
 * This class represents a command requested by user and sending to elevator system.
 * @author jzhang
 */
public class ElevatorUserCommand {

    private int currentLevel;
    private int destLevel;
    private int passengerNumber;


    public ElevatorUserCommand() {
        //Default Constructor Required by Spring.
    }

    public ElevatorUserCommand(int currentLevel, int destLevel, int passengerNumber) {
        this.currentLevel = currentLevel;
        this.destLevel = destLevel;
        this.passengerNumber = passengerNumber;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }


    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getDestLevel() {
        return destLevel;
    }

    public void setDestLevel(int destLevel) {
        this.destLevel = destLevel;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

}
