package com.wallapop.marsRover.domain;

public class MarsRover {

    private CoordinateSystem coordinateSystem;
    private Orientation orientation;


    public MarsRover(CoordinateSystem coordinateSystem, Orientation orientation) {
        this.coordinateSystem = coordinateSystem;
        this.orientation = orientation;
    }

    public int getRoverX() {
        return this.coordinateSystem.getCurrentCoordinateX();
    }

    public int getRoverY() {
        return this.coordinateSystem.getCurrentCoordinateY();
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public MarsRover moveForward() {
        switch (orientation) {
            case NORTH:
                this.coordinateSystem.increaseCoordinateY();
                break;
            case EAST:
                this.coordinateSystem.increaseCoordinateX();
                break;
            case SOUTH:
                this.coordinateSystem.decreaseCoordinateY();
                break;
            case WEST:
                this.coordinateSystem.decreaseCoordinateX();
                break;
        }
        return this;
    }

    public MarsRover moveBackwards() {
        switch (orientation) {
            case NORTH:
                this.coordinateSystem.decreaseCoordinateY();
                break;
            case EAST:
                this.coordinateSystem.decreaseCoordinateX();
                break;
            case SOUTH:
                this.coordinateSystem.increaseCoordinateY();
                break;
            case WEST:
                this.coordinateSystem.increaseCoordinateX();
                break;
        }
        return this;
    }

    public MarsRover rotateLeft() {
        switch (orientation) {
            case NORTH:
                this.orientation = Orientation.WEST;
                break;
            case EAST:
                this.orientation = Orientation.NORTH;
                break;
            case SOUTH:
                this.orientation = Orientation.EAST;
                break;
            case WEST:
                this.orientation = Orientation.SOUTH;
                break;
        }
        return this;
    }

    public MarsRover rotateRight() {
        switch (orientation) {
            case NORTH:
                this.orientation = Orientation.EAST;
                break;
            case EAST:
                this.orientation = Orientation.SOUTH;
                break;
            case SOUTH:
                this.orientation = Orientation.WEST;
                break;
            case WEST:
                this.orientation = Orientation.NORTH;
                break;
        }
        return this;
    }
}
