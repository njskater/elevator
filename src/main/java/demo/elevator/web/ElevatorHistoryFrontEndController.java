package demo.elevator.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.elevator.jpa.model.ElevatorHistory;
import demo.elevator.service.ElevatorHistoryService;

/**
 * Front end Restful end point Spring controller for elevator history query.
 * @author jzhang
 *
 */
@Controller
@RequestMapping("/elevator-history")
public class ElevatorHistoryFrontEndController {

    @Autowired
    private ElevatorHistoryService elevatorHistoryService;

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Iterable<ElevatorHistory> getAllHistory() {
        return elevatorHistoryService.findAllHistory();
    }

}
