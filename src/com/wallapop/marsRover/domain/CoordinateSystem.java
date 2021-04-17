package com.wallapop.marsRover.domain;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CoordinateSystem {

    private Coordinate currentCoordinates;
    private final int maximumXCoordinate;
    private final int maximumYCoordinate;
    private final Collection<Coordinate> obstacles;

    public CoordinateSystem(int initialCoordinateX, int initialCoordinateY, Field field) {
        this.currentCoordinates = new Coordinate(initialCoordinateX, initialCoordinateY);
        this.maximumXCoordinate = field.getSizeX();
        this.maximumYCoordinate = field.getSizeY();
        this.obstacles = field.getObstaclePositions();
        this.validateInitialPosition();
    }

    private void validateInitialPosition() {
        if(isInitialPositionOnObstacle() ) {
            throw new IllegalArgumentException("Initial Position is on a obstacle Position");
        }
        if(isInitialPositionOutsideField()){
            throw new IllegalArgumentException("Initial Position is outside Field Boundaries");
        }
    };

    private boolean isInitialPositionOutsideField(){
        if(this.currentCoordinates.getCoordinateX() > this.maximumXCoordinate || this.currentCoordinates.getCoordinateY() > this.maximumYCoordinate){
            return true;
        }
        return false;
    };

    private boolean isInitialPositionOnObstacle() {
        var isInitialPositionOnObstacle = obstacles.stream().anyMatch(item ->
                item.getCoordinateX() == currentCoordinates.getCoordinateX()
                        &&
                        item.getCoordinateY() == currentCoordinates.getCoordinateY()
        );
        return isInitialPositionOnObstacle;
    }

    public int getCurrentCoordinateX() {
        return this.currentCoordinates.getCoordinateX();
    }

    public int getCurrentCoordinateY() {
        return this.currentCoordinates.getCoordinateY();
    }

    public void increaseCoordinateX() {
        int newXCoordinate;
        var xCoordinate = this.currentCoordinates.getCoordinateX();
        var yCoordinate = this.currentCoordinates.getCoordinateX();

        if (this.currentCoordinates.getCoordinateX() == this.maximumXCoordinate) {
            newXCoordinate = 0;
        } else {
            newXCoordinate = xCoordinate + 1;
        }

        if(isCoordinateBusy(newXCoordinate,yCoordinate)) {
            System.out.println("The desired Coordinate is busy, marsRover won't move");
        } else {
            this.currentCoordinates.setCoordinateX(newXCoordinate);
        }
    }

    public void increaseCoordinateY() {
        int newYCoordinate;
        var xCoordinate = this.currentCoordinates.getCoordinateX();
        var yCoordinate = this.currentCoordinates.getCoordinateY();

        if (yCoordinate == this.maximumYCoordinate) {
            newYCoordinate = 0;
        } else {
            newYCoordinate = yCoordinate + 1;
        }
        if(isCoordinateBusy(xCoordinate, newYCoordinate)) {
            System.out.println("The desired Coordinate is busy, marsRover won't move");
        } else {
            this.currentCoordinates.setCoordinateY(newYCoordinate);
        }
    }

    public void decreaseCoordinateX() {
        int newXCoordinate;
        var xCoordinate = this.currentCoordinates.getCoordinateX();
        var yCoordinate = this.currentCoordinates.getCoordinateY();

        if (xCoordinate == 0) {
            newXCoordinate = this.maximumXCoordinate;
        } else {
            newXCoordinate = xCoordinate - 1;
        }

        if (isCoordinateBusy(newXCoordinate, yCoordinate)) {
            System.out.println("The desired Coordinate is busy, marsRover won't move");
        } else {
            this.currentCoordinates.setCoordinateX(newXCoordinate);
        }
    }

    public void decreaseCoordinateY() {
        int newYCoordinate;
        var yCoordinate = this.currentCoordinates.getCoordinateY();
        var xCoordinate = this.currentCoordinates.getCoordinateX();

        if (yCoordinate == 0) {
            newYCoordinate = this.maximumYCoordinate;
        } else {
            newYCoordinate = yCoordinate - 1;
        }

        if (isCoordinateBusy(xCoordinate, newYCoordinate)) {
            System.out.println("The desired Coordinate is busy, marsRover won't move");
        } else {
            this.currentCoordinates.setCoordinateY(newYCoordinate);
        }
    }

    private boolean isCoordinateBusy(int xCoordinate, int yCoordinate) {
        var coordinate = new Coordinate(xCoordinate, yCoordinate);
        var exists = obstacles.stream().anyMatch(item ->
                item.getCoordinateX() == coordinate.getCoordinateX()
                &&
                item.getCoordinateY() == coordinate.getCoordinateY()
        );

        if (exists) {
            return true;
        }
        return false;
    }
}
