package demo.elevator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a demo environment that consists of a list of elevators with ID 'A' to 'D'.
 * @author jzhang
 */
public class DemoElevatorEnvironment implements ElevatorEnvironment {

    private final Map<String, Elevator> elevatorMap;

    public DemoElevatorEnvironment() {
        elevatorMap = new HashMap<String, Elevator>();
        createElevators();
    }

    @Override
    public List<Elevator> getElevators() {
        return new ArrayList<>(elevatorMap.values());
    }

    @Override
    public Elevator getElevatorById(String id) {
        return elevatorMap.get(id);
    }

    private void createElevators() {
        for (char i = 'A'; i <= 'D'; i++) {
            final String id = String.valueOf(i);
            elevatorMap.put(id, new Elevator(id));
        }
    }

}
