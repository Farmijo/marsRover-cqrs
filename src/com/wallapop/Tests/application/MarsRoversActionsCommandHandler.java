package com.wallapop.Tests.application;

import com.wallapop.Tests.domain.MarsRoverFactory;
import com.wallapop.marsRover.application.builders.SessionCreationData;
import com.wallapop.marsRover.application.commands.*;
import com.wallapop.marsRover.application.handlers.CreateSessionCommandHandler;
import com.wallapop.marsRover.application.handlers.MarsRoverActionCommandHandler;
import com.wallapop.marsRover.application.services.MarsRoverService;
import com.wallapop.marsRover.domain.*;
import com.wallapop.marsRover.infrastructure.InMemoryMarsRoverRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;

public class MarsRoversActionsCommandHandler {
    MarsRoverActionCommandHandler handler;
    InMemoryMarsRoverRepository repository;
    MarsRoverService service;

    @Before
    public void ActionsCommandHandler() {
        repository = new InMemoryMarsRoverRepository();
        service = new MarsRoverService(repository);
        handler = new MarsRoverActionCommandHandler(service);

        var initialOrientation = Orientation.EAST;
        var sizeField = new Coordinate(4,4);
        var initialCoordinate = new Coordinate(1,1);
        var marsRover = MarsRoverFactory.build(initialOrientation,sizeField, initialCoordinate);


        this.repository.saveMarsRover(marsRover);
    }

    @Test
    public void moveLeft_isCalled() throws Exception {
        var command = new MarsRoverRotationLeftCommand();
        this.handler.dispatch(command);

        var marsRover = repository.getMarsRover();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.NORTH);
    }

    @Test
    public void moveRight_isCalled() throws Exception {
        var command = new MarsRoverRotationRightCommand();
        this.handler.dispatch(command);

        var marsRover = repository.getMarsRover();

        Assert.assertEquals(marsRover.getOrientation(), Orientation.SOUTH);
    }
    @Test
    public void moveForward_isCalled() throws Exception {
        var command = new MarsRoverMoveForwardCommand();
        this.handler.dispatch(command);

        var marsRover = repository.getMarsRover();

        Assert.assertEquals(marsRover.getRoverX(), 2);
    }
    @Test
    public void moveBackwards_isCalled() throws Exception {
        var command = new MarsRoverMoveBackwardCommand();
        this.handler.dispatch(command);

        var marsRover = repository.getMarsRover();

        Assert.assertEquals(marsRover.getRoverX(), 0);
    }

}
