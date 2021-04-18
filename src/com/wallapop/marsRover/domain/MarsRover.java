package com.wallapop.marsRover.domain;

public class MarsRover {

    private CoordinateSystem coordinateSystem;
    private OrientationSystem orientationSystem;

    public MarsRover(CoordinateSystem coordinateSystem, OrientationSystem orientationSystem) {
        this.coordinateSystem = coordinateSystem;
        this.orientationSystem = orientationSystem;
    }

    public int getRoverX() {
        return this.coordinateSystem.getCurrentCoordinateX();
    }

    public int getRoverY() {
        return this.coordinateSystem.getCurrentCoordinateY();
    }

    public Orientation getOrientation() {
        return this.orientationSystem.getCurrentOrientation();
    }

    public MarsRover moveForward() {
        var orientation = this.orientationSystem.getCurrentOrientation();
        this.coordinateSystem.moveForward(orientation);
        return this;
    }

    public MarsRover moveBackwards() {
        var orientation = this.orientationSystem.getCurrentOrientation();
        this.coordinateSystem.moveBackwards(orientation);
        return this;
    }

    public MarsRover rotateLeft() {
        this.orientationSystem.rotateLeft();
        return this;
    }

    public MarsRover rotateRight() {
        this.orientationSystem.rotateRight();
        return this;
    }
}
