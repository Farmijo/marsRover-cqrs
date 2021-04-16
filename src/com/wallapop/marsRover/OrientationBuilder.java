package com.wallapop.marsRover;

import com.wallapop.marsRover.domain.Orientation;

public class OrientationBuilder {
    static Orientation buildOrientation(String orientation) {
        switch (orientation) {
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

}
