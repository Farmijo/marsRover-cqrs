package com.wallapop.marsRover.application.handlers;

import com.wallapop.marsRover.application.builders.SessionCreationData;
import com.wallapop.marsRover.application.commands.CreateMarsRoverSessionCommand;
import com.wallapop.marsRover.application.services.MarsRoverService;

public class CreateSessionCommandHandler {
    MarsRoverService service;

    public CreateSessionCommandHandler(MarsRoverService service) {
        this.service = service;
    }

    public void dispatch(CreateMarsRoverSessionCommand command) {
        var sessionCreationData = new SessionCreationData
                .Builder()
                .setupInitialOrientation(command.initialOrientation)
                .generateCoordinateSystem(command.initialPositionX, command.initialPositionY, command.sizeMapX, command.sizeMapY)
                .build();

        var marsRover = this.service.createMarsRoverNavigationSession(sessionCreationData);
        System.out.println("Created with " + marsRover.getOrientation().name());
    }

}
