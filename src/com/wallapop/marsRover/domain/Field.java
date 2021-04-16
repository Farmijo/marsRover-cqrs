package com.wallapop.marsRover.domain;

public class Field {

    private final int minSize = 0;

    private final int sizeX;
    private final int sizeY;

    public Field(int sizeX, int sizeY) {
        if ( sizeX <= minSize || sizeY <= minSize) throw new IllegalArgumentException("Vertical and Horizontal size should be larger than 0");
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }
}
