package com.wallapop.marsRover.domain;

public class CoordinateSystem {
    private int currentCoordinateX;
    private int currentCoordinateY;
    private final int maximumXCoordinate;
    private final int maximumYCoordinate;

    public CoordinateSystem(int initialCoordinateX, int initialCoordinateY, Field field) {
        this.currentCoordinateX = initialCoordinateX;
        this.currentCoordinateY = initialCoordinateY;
        this.maximumXCoordinate = field.getSizeX();
        this.maximumYCoordinate = field.getSizeY();
    }

    public int getCurrentCoordinateX() {
        return currentCoordinateX;
    }

    public int getCurrentCoordinateY() {
        return currentCoordinateY;
    }

    public void increaseCoordinateX() {
        if (this.currentCoordinateX == this.maximumXCoordinate) {
            this.currentCoordinateX = 0;
        } else {
            this.currentCoordinateX++;
        }
    }

    public void increaseCoordinateY() {
        if (this.currentCoordinateY == this.maximumYCoordinate) {
            this.currentCoordinateY = 0;
        } else {
            this.currentCoordinateY++;
        }
    }

    public void decreaseCoordinateX() {
        if (this.currentCoordinateX == 0) {
            this.currentCoordinateX = this.maximumXCoordinate;
        } else {
            this.currentCoordinateX--;
        }
    }

    public void decreaseCoordinateY() {
        if (this.currentCoordinateY == 0) {
            this.currentCoordinateY = this.maximumYCoordinate;
        } else {
            this.currentCoordinateY--;
        }
    }
}
