package com.wallapop.marsRover.application.handlers;

import com.wallapop.marsRover.application.commands.MarsRoverMoveBackwardCommand;
import com.wallapop.marsRover.application.commands.MarsRoverMoveForwardCommand;
import com.wallapop.marsRover.application.commands.MarsRoverRotationLeftCommand;
import com.wallapop.marsRover.application.commands.MarsRoverRotationRightCommand;
import com.wallapop.marsRover.application.services.MarsRoverService;
import com.wallapop.marsRover.domain.MarsRover;
import com.wallapop.marsRover.domain.MarsRoverId;

public class MarsRoverActionCommandHandler {
    MarsRoverService service;

    public MarsRoverActionCommandHandler(MarsRoverService service) {
        this.service = service;
    }

    public void dispatch(MarsRoverRotationRightCommand command) {
        var marsRover = this.service.rotateRight(new MarsRoverId(command.id));
        System.out.println(String.format("Rover is at x:%d y:%d facing:%s", marsRover.getRoverX(), marsRover.getRoverY(), marsRover.getOrientation()));
    }

    public void dispatch(MarsRoverRotationLeftCommand command) {
        var marsRover = this.service.rotateLeft(new MarsRoverId(command.id));
        System.out.println(String.format("Rover is at x:%d y:%d facing:%s", marsRover.getRoverX(), marsRover.getRoverY(), marsRover.getOrientation()));
    }

    public void dispatch(MarsRoverMoveForwardCommand command) {
        var marsRover = this.service.moveForward(new MarsRoverId(command.id));
        System.out.println(String.format("Rover is at x:%d y:%d facing:%s", marsRover.getRoverX(), marsRover.getRoverY(), marsRover.getOrientation()));
    }

    public void dispatch(MarsRoverMoveBackwardCommand command) {
        var marsRover = this.service.moveBackwards(new MarsRoverId(command.id));
        System.out.println(String.format("Rover is at x:%d y:%d facing:%s", marsRover.getRoverX(), marsRover.getRoverY(), marsRover.getOrientation()));
    }

}
