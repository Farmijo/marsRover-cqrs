package com.wallapop.marsRover.application.services;

import com.wallapop.marsRover.application.builders.SessionCreationData;
import com.wallapop.marsRover.domain.MarsRover;
import com.wallapop.marsRover.domain.MarsRoverId;
import com.wallapop.marsRover.domain.Repository.MarsRoverRepository;

public class MarsRoverService {
    MarsRover marsRover;
    MarsRoverRepository repository;
    public MarsRoverService(MarsRoverRepository repository) {
        this.repository = repository;
    }

    public MarsRover createMarsRoverNavigationSession(SessionCreationData builder) {
        marsRover = new MarsRover(builder.id, builder.coordinateSystem, builder.initialOrientation);
        this.repository.saveMarsRover(marsRover);
        return marsRover;
    }

    public MarsRover rotateLeft(MarsRoverId id) {
        var rover = this.repository.getMarsRover(id);
        rover.rotateLeft();
        this.repository.updateMarsRover(rover);
        return rover;
    }

    public MarsRover rotateRight(MarsRoverId id) {
        var rover = this.repository.getMarsRover(id);
        rover.rotateRight();
        this.repository.updateMarsRover(rover);
        return marsRover;
    }

    public MarsRover moveBackwards(MarsRoverId id) {
        var rover = this.repository.getMarsRover(id);
        rover.moveBackwards();
        this.repository.updateMarsRover(rover);
        return marsRover;
    }

    public MarsRover moveForward(MarsRoverId id) {
        var rover = this.repository.getMarsRover(id);
        rover.moveForward();
        this.repository.updateMarsRover(rover);
        return marsRover;
    }

}
