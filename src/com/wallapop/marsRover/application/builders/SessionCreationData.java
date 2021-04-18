package com.wallapop.marsRover.application.builders;

import com.wallapop.marsRover.domain.*;

import java.util.ArrayList;

public class SessionCreationData {

    public CoordinateSystem coordinateSystem;
    public OrientationSystem orientationSystem;

    public static class Builder {
        private CoordinateSystem coordinateSystem;
        private OrientationSystem orientationSystem;
        private Field field;

        public Builder() {
        };

        public Builder generateCoordinateSystem(int initPositionX, int initPositionY, int sizeFieldX, int sizeFieldY) {
            this.field = new Field.Builder(sizeFieldX, sizeFieldY).build();
            this.coordinateSystem = new CoordinateSystem(initPositionX, initPositionY, this.field);
            return this;
        }

        public Builder generateCoordinateSystemWithObstacles(int initPositionX, int initPositionY, int sizeFieldX, int sizeFieldY) {
            var obstacles = new ArrayList<Coordinate>();
            obstacles.add(new Coordinate(1,2));
            obstacles.add(new Coordinate(3,1));
            this.field = new Field.Builder(sizeFieldX, sizeFieldY).addObstacles(obstacles).build();
            this.coordinateSystem = new CoordinateSystem(initPositionX, initPositionY, this.field);
            return this;
        }

        public Builder generateOrientationSystem(String initialOrientation) {
            var orientation = parseOrientation(initialOrientation);
            this.orientationSystem = new OrientationSystem(orientation);
            return this;
        }

        private Orientation parseOrientation(String orientation) {
            switch (orientation.toLowerCase()) {
                case "n":
                    return Orientation.NORTH;
                case "s":
                    return Orientation.SOUTH;
                case "e":
                    return Orientation.EAST;
                case "w":
                    return Orientation.WEST;
                default:
                    throw new IllegalArgumentException("Not valid orientation");
            }
        }

        public SessionCreationData build() {
            return new SessionCreationData(this);
        }

    }

    private SessionCreationData(Builder builder) {
        this.coordinateSystem = builder.coordinateSystem;
        this.orientationSystem = builder.orientationSystem;
    }

}
