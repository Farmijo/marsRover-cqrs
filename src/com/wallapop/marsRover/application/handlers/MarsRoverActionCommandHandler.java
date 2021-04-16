package com.wallapop.marsRover.application.handlers;

import com.wallapop.marsRover.application.commands.*;
import com.wallapop.marsRover.application.services.MarsRoverService;

public class MarsRoverActionCommandHandler {
    MarsRoverService service;

    public MarsRoverActionCommandHandler(MarsRoverService service){
        this.service = service;
    }

    public void dispatch(MarsRoverRotationRightCommand command){
        var marsRover = this.service.rotateRight();
        System.out.println(String.format("Rover is at x:%d y:%d facing:%s", marsRover.getRoverX(), marsRover.getRoverY(), marsRover.getOrientation()));
    }
    public void dispatch(MarsRoverRotationLeftCommand command){
        var marsRover = this.service.rotateLeft();
        System.out.println(String.format("Rover is at x:%d y:%d facing:%s", marsRover.getRoverX(), marsRover.getRoverY(), marsRover.getOrientation()));
    }

    public void dispatch(MarsRoverMoveForwardCommand command){
        var marsRover = this.service.moveForward();
        System.out.println(String.format("Rover is at x:%d y:%d facing:%s", marsRover.getRoverX(), marsRover.getRoverY(), marsRover.getOrientation()));
    }

    public void dispatch(MarsRoverMoveBackwardCommand command){
        var marsRover = this.service.moveBackwards();
        System.out.println(String.format("Rover is at x:%d y:%d facing:%s", marsRover.getRoverX(), marsRover.getRoverY(), marsRover.getOrientation()));
    }

}
