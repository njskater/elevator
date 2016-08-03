package demo.elevator.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import demo.elevator.model.ElevatorUserCommand;
import demo.elevator.service.ElevatorService;

/**
 * Front end Restful end point Spring controller to take elevator command.
 * @author jzhang
 *
 */
@Controller
@RequestMapping("/elevator-command")
public class ElevatorFrontEndController {

    @Autowired
    private ElevatorService elevatorService;

    @RequestMapping(method=RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody void sendCommand(@RequestBody ElevatorUserCommand command) {
        elevatorService.takeCommand(command);
    }



}
