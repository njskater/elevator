package demo.elevator.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * JPA Entity to represent elevator moving history.
 * @author jzhang
 */
@Entity(name = "elevator_history")
public class ElevatorHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String elevatorId;

    @Column(nullable = false)
    private int fromLevel;

    @Column(nullable = false)
    private int toLevel;

    @Column(nullable = false)
    private int passengerNumber;

    public static ElevatorHistory create(String elevatorId, int fromLevel, int toLevel, int passengerNumber) {
        final ElevatorHistory elevatorHistory = new ElevatorHistory();
        elevatorHistory.setElevatorId(elevatorId);
        elevatorHistory.setFromLevel(fromLevel);
        elevatorHistory.setToLevel(toLevel);
        elevatorHistory.setPassengerNumber(passengerNumber);
        return elevatorHistory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(String elevatorId) {
        this.elevatorId = elevatorId;
    }

    public int getFromLevel() {
        return fromLevel;
    }

    public void setFromLevel(int fromLevel) {
        this.fromLevel = fromLevel;
    }

    public int getToLevel() {
        return toLevel;
    }

    public void setToLevel(int toLevel) {
        this.toLevel = toLevel;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((elevatorId == null) ? 0 : elevatorId.hashCode());
        result = prime * result + fromLevel;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + passengerNumber;
        result = prime * result + toLevel;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final ElevatorHistory other = (ElevatorHistory) obj;
        if (elevatorId == null) {
            if (other.elevatorId != null) return false;
        } else if (!elevatorId.equals(other.elevatorId)) return false;
        if (fromLevel != other.fromLevel) return false;
        if (id != other.id) return false;
        if (passengerNumber != other.passengerNumber) return false;
        if (toLevel != other.toLevel) return false;
        return true;
    }

}
