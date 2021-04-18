package com.wallapop.Tests.application;

import com.wallapop.marsRover.application.builders.SessionCreationData;
import com.wallapop.marsRover.application.commands.CreateMarsRoverSessionCommand;
import com.wallapop.marsRover.application.commands.CreateMarsRoverSessionWithObstaclesCommand;
import com.wallapop.marsRover.application.handlers.CreateSessionCommandHandler;
import com.wallapop.marsRover.application.handlers.MarsRoverActionCommandHandler;
import com.wallapop.marsRover.application.services.MarsRoverService;
import com.wallapop.marsRover.domain.Coordinate;
import com.wallapop.marsRover.domain.Field;
import com.wallapop.marsRover.domain.MarsRoverRepository;
import com.wallapop.marsRover.domain.Orientation;
import com.wallapop.marsRover.infrastructure.InMemoryMarsRoverRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;

public class TestCreateSessionCommandHandler {
    CreateSessionCommandHandler handler;
    InMemoryMarsRoverRepository repository;
    MarsRoverService service;


    @Before
    public void createCommandHandler() {
        repository = new InMemoryMarsRoverRepository();
        service = new MarsRoverService(repository);
        handler = new CreateSessionCommandHandler(service);
    }

    @Test
    public void createMarsRover_isCalled() throws Exception {
        var command = new CreateMarsRoverSessionCommand(4, 4, "e", 1, 1);
        this.handler.dispatch(command);

        var marsRover = repository.getMarsRover();

        Assert.assertEquals(marsRover.getRoverX(), 1);
        Assert.assertEquals(marsRover.getRoverY(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createMarsRoverWithObstacles_withInitialPositionOnObstacle_isCalledAndFails() throws Exception {
        var command = new CreateMarsRoverSessionWithObstaclesCommand(4, 4, "e", 1, 2);
        this.handler.dispatch(command);
    }

}
