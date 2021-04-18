package com.wallapop.marsRover.application.services;

import com.wallapop.marsRover.application.builders.SessionCreationData;
import com.wallapop.marsRover.domain.MarsRover;
import com.wallapop.marsRover.domain.MarsRoverRepository;

public class MarsRoverService {
    MarsRoverRepository marsRoverRepository;

    public MarsRoverService(MarsRoverRepository marsRoverRepository) {
        this.marsRoverRepository = marsRoverRepository;
    }

    public MarsRover createMarsRoverNavigationSession(SessionCreationData builder) {
        var marsRover = new MarsRover(builder.coordinateSystem, builder.initialOrientation);
        this.marsRoverRepository.saveMarsRover(marsRover);
        return marsRover;
    }

    public MarsRover rotateLeft() {
        var marsRover = this.marsRoverRepository.getMarsRover();
        marsRover.rotateLeft();
        return marsRover;
    }

    public MarsRover rotateRight() {
        var marsRover = this.marsRoverRepository.getMarsRover();
        marsRover.rotateRight();
        return marsRover;
    }

    public MarsRover moveBackwards() {
        var marsRover = this.marsRoverRepository.getMarsRover();
        marsRover.moveBackwards();
        return marsRover;
    }

    public MarsRover moveForward() {
        var marsRover = this.marsRoverRepository.getMarsRover();
        marsRover.moveForward();
        return marsRover;
    }

}
