package com.wallapop.marsRover.application.services;

import com.wallapop.marsRover.application.builders.SessionCreationData;
import com.wallapop.marsRover.domain.MarsRover;

public class MarsRoverService {
    MarsRover marsRover;

    public MarsRoverService(){}

    public MarsRover createMarsRoverNavigationSession(SessionCreationData builder){
         marsRover = new MarsRover(builder.coordinateSystem, builder.initialOrientation);
         return marsRover;
    }

    public MarsRover rotateLeft(){
        this.marsRover.rotateLeft();
        return marsRover;
    }
    public MarsRover rotateRight(){
        this.marsRover.rotateRight();
        return marsRover;
    }
    public MarsRover moveBackwards(){
        this.marsRover.moveBackwards();
        return marsRover;
    }
    public MarsRover moveForward(){
        this.marsRover.moveForward();
        return marsRover;
    }

}
