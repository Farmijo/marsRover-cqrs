package com.wallapop.marsRover.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collection;
import java.util.Set;

public class Field {

    private final int sizeX;
    private final int sizeY;
    private final Collection<Coordinate> obstaclePositions;

    public static class Builder {
        private final int minSize = 0;

        private int sizeX;
        private int sizeY;

        private Collection<Coordinate> obstaclePositions = new HashSet<>();

        public Builder(int sizeX, int sizeY) {
            if (sizeX <= minSize || sizeY <= minSize)
                throw new IllegalArgumentException("Vertical and Horizontal size should be larger than 0");
            this.sizeX = sizeX;
            this.sizeY = sizeY;
        }

        public Builder addObstacles(Collection<Coordinate> obstaclePositions) {
            this.obstaclePositions = obstaclePositions;
            return this;
        }

        public Field build() {
            return new Field(this);
        }
    }

    private Field(Builder builder) {
        this.sizeX = builder.sizeX;
        this.sizeY = builder.sizeY;
        this.obstaclePositions = builder.obstaclePositions;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public Collection<Coordinate> getObstaclePositions() {
        return obstaclePositions;
    }
}
