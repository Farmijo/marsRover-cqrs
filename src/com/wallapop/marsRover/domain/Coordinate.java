package com.wallapop.marsRover.domain;

public class Coordinate {
    private int coordinateX;
    private int coordinateY;

    public Coordinate(int x, int y) {
        if(x < 0 || y < 0) throw new IllegalArgumentException("Coordinates must be ");
        this.coordinateX = x;
        this.coordinateY = y;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }
}
