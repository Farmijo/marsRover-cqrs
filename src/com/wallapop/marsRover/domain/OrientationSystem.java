package com.wallapop.marsRover.domain;

public class OrientationSystem {
    private Orientation orientation;
    public OrientationSystem(Orientation initialOrientation){
        this.orientation = initialOrientation;
    };

    public Orientation getCurrentOrientation() {
        return orientation;
    }

    public void rotateLeft() {
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
            default:
                throw new IllegalArgumentException("Not valid orientation");
        }
    }

    public void rotateRight() {
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
            default:
                throw new IllegalArgumentException("Not valid orientation");
        }

    }
}
