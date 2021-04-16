package com.wallapop.marsRover.domain;

public class CoordinateSystem {

    private Coordinate currentCoordinates;
    private final int maximumXCoordinate;
    private final int maximumYCoordinate;

    public CoordinateSystem(int initialCoordinateX, int initialCoordinateY, Field field) {
        this.currentCoordinates = new Coordinate(initialCoordinateX, initialCoordinateY);
        this.maximumXCoordinate = field.getSizeX();
        this.maximumYCoordinate = field.getSizeY();
    }

    public int getCurrentCoordinateX() {
        return this.currentCoordinates.getCoordinateX();
    }

    public int getCurrentCoordinateY() {
        return this.currentCoordinates.getCoordinateY();
    }

    public void increaseCoordinateX() {
        var xCoordinate = this.currentCoordinates.getCoordinateX();
        if (this.currentCoordinates.getCoordinateX() == this.maximumXCoordinate) {
            this.currentCoordinates.setCoordinateX(0);
        } else {
            this.currentCoordinates.setCoordinateX(++xCoordinate);
        }
    }

    public void increaseCoordinateY() {
        var yCoordinate = this.currentCoordinates.getCoordinateY();
        if (yCoordinate == this.maximumYCoordinate) {
            this.currentCoordinates.setCoordinateY(0);
        } else {
            this.currentCoordinates.setCoordinateY(++yCoordinate);
        }
    }

    public void decreaseCoordinateX() {
        var xCoordinate = this.currentCoordinates.getCoordinateX();
        if (xCoordinate == 0) {
            this.currentCoordinates.setCoordinateX(this.maximumXCoordinate);
        } else {
            this.currentCoordinates.setCoordinateX(--xCoordinate);
        }
    }

    public void decreaseCoordinateY() {
        var yCoordinate = this.currentCoordinates.getCoordinateY();
        if (yCoordinate == 0) {
            this.currentCoordinates.setCoordinateY(this.maximumYCoordinate);
        } else {
            this.currentCoordinates.setCoordinateY(--yCoordinate);
        }
    }
}
