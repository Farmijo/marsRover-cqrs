package com.wallapop.marsRover.application.builders;

import com.wallapop.marsRover.domain.CoordinateSystem;
import com.wallapop.marsRover.domain.Field;
import com.wallapop.marsRover.domain.Orientation;

public class SessionCreationData {

    public CoordinateSystem coordinateSystem;
    public Orientation initialOrientation;

    public static class Builder {
        private CoordinateSystem coordinateSystem;
        private Orientation initialOrientation;
        private Field field;

        public Builder() {
        }

        ;

        public Builder generateCoordinateSystem(int initPositionX, int initPositionY, int sizeFieldX, int sizeFieldY) {
            this.field = new Field.Builder(4, 4).build();
            this.coordinateSystem = new CoordinateSystem(initPositionX, initPositionY, this.field);
            return this;
        }

        public Builder setupInitialOrientation(String initialOrientation) {
            this.initialOrientation = parseOrientation(initialOrientation);
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
        this.initialOrientation = builder.initialOrientation;
    }

}
